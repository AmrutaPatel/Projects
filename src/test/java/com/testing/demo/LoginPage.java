package com.testing.demo;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="loginUserName")
	WebElement txtUsername;
	
	@FindBy(id="loginPassword")
	WebElement txtPassword;
	
	@FindBy(css="button.btn.btn-primary")
	WebElement btnLogin;
	
	@FindBy(css="button.btn.btn-cancel")
	WebElement btnCancel;
	
	@FindBy(id="login-error")
	WebElement errMessage;
	
	@FindBy(id="nav-user")
	WebElement navigateUser;
	
	@FindBy(xpath = "html/body/div[2]/div/div/h1")
	WebElement msgWelcome;
	
	public void Login(String username, String password, boolean submit){
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		if (submit) { 
			btnLogin.click();
		}
		else{
			btnCancel.click();
		}
	}
	
	public String VerifyErrorMessage(){
		try{
			return errMessage.getText();
		}catch(NoSuchElementException e){
			return "";
		}
	}
	
	public void ClickUser(){
		navigateUser.click();
	}
	
	public String VerifyWelcomeMessage(){
		try{
			return msgWelcome.getText();
		}catch(NoSuchElementException e){
			return "";
		}
	}
	
}
