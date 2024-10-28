package com.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Demoblaze {
	WebDriver driver;

    @Test(dataProvider = "excelData", dataProviderClass = ExcelProvider.class)
    public void testLogin(String username, String password) {
        driver = new ChromeDriver();
    

        driver.get("https://www.demoblaze.com");

        // Assuming you have a login method that accepts username and password
        login(username, password);

        // Validate login or perform further actions
    }

    public void login(String username, String password) {
        // Your login automation code using Selenium WebDriver
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public void takeScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("path/to/screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

