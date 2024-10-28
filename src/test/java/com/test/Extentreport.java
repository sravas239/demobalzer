package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pom.Productpage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Extentreport {
	public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
  
    @BeforeClass
    public void setup() {
    	 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.demoblaze.com/");

	        // Setup ExtentReports and attach the reporter
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        // Optional: Additional configurations
	        htmlReporter.config().setReportName("Demoblaze of the Products Test Report");
	        htmlReporter.config().setDocumentTitle("Test Report");
        
    }

    @Test
    public void testPrintProductDetails() {
        test = extent.createTest("testPrintProductDetails", "Test to print product details from the page");

        try {
            // Your test logic here
            Productpage productPage = new Productpage(driver);
            productPage.printProductDetails();

            // Log test status as passed
            test.log(Status.PASS, "Product details printed successfully");

        } catch (Exception e) {
            // Log test status as failed
            test.log(Status.FAIL, "Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        // Flush the report
        extent.flush();
    }
}

