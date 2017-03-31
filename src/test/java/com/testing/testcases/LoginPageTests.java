package com.testing.testcases;

import static org.junit.Assert.*;
import org.junit.*;
//import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import com.testing.demo.BasePage;
import com.testing.demo.ContactPage;
import com.testing.demo.LoginPage;
import com.testing.util.ReadExcel;

import junit.framework.*;
import junit.framework.Assert;
import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPageTests extends BaseTestSuite {

	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		BasePage basePageObj = new BasePage(driver);
		LoginPage logingPageObj = basePageObj.navigateLogin();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//get the test data from excel, enter the data and verify the results	
		ReadExcel tdObj = null;
		try {
			tdObj = new ReadExcel("src/testcases.xls", "Login");
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//executing login test from excel sheet
		for (int i=1; i < tdObj.getRowCount(); i++){
			System.out.println("Executing testcase: " + tdObj.readCell("TestID", i));
			logingPageObj.Login(tdObj.readCell("Username", i), tdObj.readCell("Password", i), Boolean.parseBoolean(tdObj.readCell("Login", i)));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if (Boolean.parseBoolean(tdObj.readCell("ErrorVerification", i))){
				Assert.assertTrue(logingPageObj.VerifyErrorMessage().contains(tdObj.readCell("ErrorMessage",i)));
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (Boolean.parseBoolean(tdObj.readCell("SuccessVerification", i))){
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				logingPageObj.ClickUser();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertTrue(logingPageObj.VerifyWelcomeMessage().contains(tdObj.readCell("SuccessMessage", i)));
			}
			
		}
	}

}
