package com.testing.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//public abstract class BasePage {
public class BasePage {
	protected static WebDriver driver;
	
	public BasePage (WebDriver driver){
		//BasePage.driver =  driver;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//variables
	@FindBy(id = "nav-home")
	public WebElement linkHome; 
	
	@FindBy(id = "nav-shop")
	public WebElement linkShop;
	
	@FindBy(id = "nav-contact")
	public WebElement linkContact;
	
	@FindBy(id = "nav-login")
	public WebElement linkLogin;
	
	@FindBy(id = "nav-cart")
	public WebElement linkCart;
	
	@FindBy(className = "cart count")
	public WebElement cartCount;
	
	
	//navigate functions
	public HomePage navigateHome(){
		linkHome.click();
		return new HomePage(BasePage.driver);
	}
	
	public ShopPage navigateShop(){
		linkShop.click();
		return new ShopPage(BasePage.driver);
	}
	
	public ContactPage navigateContact(){ 
		linkContact.click(); 
		return new ContactPage(BasePage.driver);
	}
	
	public LoginPage navigateLogin(){
		linkLogin.click();
		return new LoginPage(BasePage.driver);
	}
	
	public CartPage navigateCart(){
		linkCart.click();
		return new CartPage(BasePage.driver);
	}
	
	public int getCartCount(){
		return  Integer.parseInt(cartCount.getText());
	}

	
	
}
