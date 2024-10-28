package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pom.Contactpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contacttest {
	WebDriver driver;
	Contactpage Contactpage ;

    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Navigate to the login page of the website
        driver.get("https://www.demoblaze.com/index.html"); // Replace with the actual login page URL

        // Initialize the Loginpage object
        Contactpage  = new Contactpage(driver);
    }

    @Test
    public void Contactpage () {
    	
//    	Contactpage.clickSignIn();
    	
    
        // Perform login action with valid credentials
        String Email = "sravani08.guduru@gmail.com"; // Replace with valid email
        String Name = "Sravani";   // Replace with valid name
        String Text="Hello Everyone";
        
        
        Contactpage.Contactpage (Email, Name,Text);
        
}
        
        // Add assertions here to verify successful login
        // Example: Assert.assertTrue(driver.getCurrentUrl().contains("dashboard") || any other expected behavior);
    



    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

}
