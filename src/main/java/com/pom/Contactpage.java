package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	WebDriver driver;


	@FindBy(xpath ="//a[normalize-space()='Contact']")
	static
	 WebElement contactlogin;
	
    @FindBy(xpath="//*[@id='recipient-email']")
	static
    WebElement contactEmailField;

    @FindBy(xpath="//*[@id='recipient-name']")
	static
    WebElement contactnameField;
    
    @FindBy(xpath ="//*[@id='message-text']")
	static
    WebElement contactmessagetext;
    
    @FindBy(xpath = "//button[contains(text(),'Send message')]")
	static
    WebElement SendmessageButton;

    public Contactpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    public Contactpage (String Email, String Name, String Text) {
    	contactlogin.click();
    	contactEmailField.sendKeys(Email);
    	contactnameField.sendKeys( Name);
    	contactmessagetext.sendKeys(Text);   
        SendmessageButton.click();

}

	

	

	public void clickSignIn() {
		// TODO Auto-generated method stub
		
	}

	public void Contactpage(String email, String name, String text) {
		// TODO Auto-generated method stub
		
		
	}



	
}
