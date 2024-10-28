package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pom.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomepageTest {

	 WebDriver driver;
	    Homepage homepage;

	    @BeforeClass
	    public void setUp() {
	        // Use WebDriverManager to manage the ChromeDriver binary
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        
	        // Navigate to the website
	        driver.get("https://www.demoblaze.com/index.html"); // Replace with the actual URL if different

	        // Initialize the Homepage object
	        homepage = new Homepage(driver);
	    }

	    @Test
	    public void testHomebutton() {
	        // Click on the Sign In button
	        homepage.clickSignIn();
	        

		    }
	        
	        // Add assertions here to verify the Sign In page is loaded correctly
	        // Example: Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	    


	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
