package com.testing.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.lang.*;
public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[contains(@id,'product-')]/div/h4")
	List<WebElement> productNames;
	
	@FindBy(xpath=".//*[contains(@id,'product-')]/div/p/span")
	List<WebElement> productPrice;
	
	public void findByProduct(){
		System.out.println(productNames.size());
		for(WebElement e: productNames){
			System.out.println(e.getText());
		}
	}
	public void findByPrice(){
		System.out.println(productPrice.size());
		for(WebElement e: productPrice){
			System.out.println(e.getText());
		}
	}
	

}
