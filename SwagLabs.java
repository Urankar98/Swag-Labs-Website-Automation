package com.fbs.Assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLabs {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		driver.manage().window().maximize();

		loginCheck(); // Login 

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); // Add Item to Cart
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click(); // Click on Cart
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		
		checkoutProcess();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("finish")).click();
		
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath("//h2[@class='complete-header']"));
			System.out.println("Your Order Placed Successfully..Thank You For Shopping!!");

		}catch(NoSuchElementException e) {
			System.out.println("Please Try Again!!");
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

	static void loginCheck() throws InterruptedException {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		Thread.sleep(3000);

		try {
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
			System.out.println("Login Successfull");
		} catch (NoSuchElementException e) {
			System.out.println("Login Failed");
			
		}
	}
	
	static void checkoutProcess() {
		
		driver.findElement(By.id("first-name")).sendKeys("Ashutosh");
		driver.findElement(By.id("last-name")).sendKeys("Urankar");
		driver.findElement(By.id("postal-code")).sendKeys("411002");
		driver.findElement(By.id("continue")).click();
	}

}
