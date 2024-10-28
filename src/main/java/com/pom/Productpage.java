package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	
	private WebDriver driver;

    @FindBy(css = ".card-block")
    private List<WebElement> productElements;

    @FindBy(css = ".card-title a")
    private List<WebElement> productNames;

    @FindBy(css = ".card-text")
    private List<WebElement> productPrices;

    public Productpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printProductDetails() {
        if (productNames.size() == productPrices.size() && !productNames.isEmpty()) {
            for (int i = 0; i < productNames.size(); i++) {
                String name = productNames.get(i).getText();
                String price = productPrices.get(i).getText();
                System.out.println("Product: " + name + ", Price: " + price);
            }
        } else if (productNames.isEmpty() || productPrices.isEmpty()) {
            System.out.println("Product names or prices are not loaded.");
        } else {
            System.out.println("Mismatch between product names and prices count.");
        }
    }
}
    