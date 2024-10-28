package com.pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {
	
	WebDriver driver;

	 
	@FindBy(xpath="//a[@id='login2']")
	WebElement Login;

    @FindBy(id="loginusername")
    WebElement usernameField;

    @FindBy(id="loginpassword")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

	public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       
    }

  

	public void login(String username, String password) {
		
		// TODO Auto-generated method stub
	
	     
		Login.click();
		usernameField.sendKeys("sravani08.guduru@gmail.com");
        passwordField.sendKeys("Sravas@08");
        loginButton.click();
	}

}
