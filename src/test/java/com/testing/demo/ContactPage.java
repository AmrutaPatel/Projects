package com.testing.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "forename")
	WebElement txtForename;
	
	@FindBy(id = "surname")
	WebElement txtSurname;
	
	@FindBy(id = "email")
	WebElement txtEmail;
	
	@FindBy(id = "telephone")
	WebElement txtTelephone; 			
	
	@FindBy(id = "message")
	WebElement txtMessage;
	
	@FindBy (linkText = "Submit")
	WebElement btnSubmit;
	
	
	@FindBy(id= "forename-err")
	WebElement errForeName;
	
	@FindBy(id = "email-err")
	WebElement errEmail;
	
	@FindBy(id = "telephone-err")
	WebElement errTelephone; 			
	
	@FindBy(id = "message-err")
	WebElement errMessage;
	
	@FindBy(xpath = "html/body/div[2]/div/a")
	WebElement btnGoBack;
	
	
	@FindBy(css =".alert-success")
	WebElement msgSuccess;
	
	
	public String firstnameError(){
		try{
			return errForeName.getText();
		}
		catch (NoSuchElementException e){
			return "";
		}
	}
	
	public String emailError(){
		try{
			return errEmail.getText();
		}
		catch (NoSuchElementException e){
			return "";
		}
	}	
	
	public String telephoneError(){
		try{
			return errTelephone.getText();
		}
		catch (NoSuchElementException e){
			return "";
		}
	}
	
	public String messageError(){
		try{
			return errMessage.getText();
		}
		catch (NoSuchElementException e){
			return "";
		}
	}
	
	public void CreateContact(String firstName, String lastName, String email, String phone, String msg, Boolean submit ){
		txtForename.clear();
		txtForename.sendKeys(firstName);
		txtSurname.clear();
		txtSurname.sendKeys(lastName);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtTelephone.clear();
		txtTelephone.sendKeys(phone);
		txtMessage.clear();
		txtMessage.sendKeys(msg);
		if (submit) {btnSubmit.click();}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	public void clickGoBack(){
		btnGoBack.click();
	}	
	
	public String verifySuccessMessage(){
		return	msgSuccess.getText();
	}
}
