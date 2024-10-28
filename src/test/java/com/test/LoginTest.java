package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class LoginTest {
	
	
	 WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	      
	        
	        // Initialize the ChromeDriver
	        driver = new ChromeDriver();
	        
	        // Initialize WebDriverWait with a 10-second timeout
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Open the login page
	        driver.get("https://www.demoblaze.com/");
	    }

	    @Test
	    public void testLogin() {
	        // Wait until the username field is visible and clickable
	    	 WebElement loginModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
	         loginModalButton.click();
	         
	         // Wait until the username field is visible and clickable
	         WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
	         usernameField.sendKeys("Sravani08.guduru@gmail.com");

	         // Wait until the password field is visible and clickable
	         WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
	         passwordField.sendKeys("Sravas@08");

	         // Wait until the login button is clickable and click it
	         WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Log in')]")));
	         loginButton.click();


	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
