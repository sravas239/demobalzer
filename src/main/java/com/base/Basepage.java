package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Basepage {

	protected WebDriver driver;
	

	 @FindBy(xpath ="//li[@class='nav-item active']//a[@class='nav-link']")
	 WebElement Homepage;
    
    @FindBy(xpath ="//a[normalize-space()='Contact']")
	 WebElement contactlogin;
    
    @FindBy(xpath ="//a[normalize-space()='About us']")
	 WebElement Aboutus;
    
    @FindBy(xpath ="//a[@id='cartur']")
	 WebElement cartur;
    
    @FindBy(xpath = "//a[@id='login2']") // Replace with the actual locator
    protected WebElement login;
    
    @FindBy(xpath = " //a[@id='signin2']") // Replace with the actual locator
    protected WebElement signin;
 
  

    public Basepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
