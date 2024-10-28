package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Aboutus {
	WebDriver driver;

    @FindBy(xpath ="//a[normalize-space()='About us']")
    WebElement Aboutus;


    public Aboutus(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  

	public void login(String username, String password) {
		
		// TODO Auto-generated method stub
		
		Aboutus.click();
	}



	public static void clickthebutton() {
		// TODO Auto-generated method stub
		
	}

}
