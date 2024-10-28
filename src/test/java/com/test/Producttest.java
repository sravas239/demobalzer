package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pom.Productpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Producttest {

	public static WebDriver driver;
	public static Productpage productPage;

    @BeforeClass
    public void setup() {
       
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        
        // Initialize the ProductPage
        productPage = new Productpage(driver);
    }
   
     
    @Test
    public void testPrintProductDetails() {
        // Call the method to print product details
        productPage.printProductDetails();
    }
    
    
//    @Test
    public void testDisplayProductNamesAndPrices()
    {
    	 List<WebElement> productElements = driver.findElements(By.cssSelector(".card-block"));

         // Iterate through each product and display its name and price
         for (WebElement product : productElements) {
             String productName = product.findElement(By.cssSelector(".card-title a")).getText();
             String productPrice = product.findElement(By.cssSelector(".card-text")).getText();

             System.out.println("Product Name: " + productName);
             System.out.println("Product Price: " + productPrice);
             System.out.println("--------------");
         }
}

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

