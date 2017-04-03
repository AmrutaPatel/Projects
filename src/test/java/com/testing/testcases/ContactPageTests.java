package com.testing.testcases;

//import static org.junit.Assert.*;

import org.junit.*;
//import org.junit.Assert;
import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import com.testing.demo.BasePage;
import com.testing.demo.ContactPage;
import com.testing.util.ReadExcel;

import junit.framework.*;
import junit.framework.Assert;
import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ContactPageTests extends BaseTestSuite {

	@SuppressWarnings("deprecation")
	@Test
	public void testMandatoryFields(){
		
		BasePage basePageObj = new BasePage(driver);
		ContactPage contactPageObj = basePageObj.navigateContact();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//get the test data from excel, enter the data and verify the results	
		ReadExcel tdObj = null;
		try {
			tdObj = new ReadExcel("src/testcases.xls", "Contact");
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//executing all the tests from excel sheet
		for (int i=1; i < tdObj.getRowCount(); i++){
			System.out.println("Executing testcase: " + tdObj.readCell("TestID", i));
			contactPageObj.CreateContact(tdObj.readCell("Firstname",i), tdObj.readCell("Lastname",i), tdObj.readCell("Email",i), tdObj.readCell("Telephone",i), tdObj.readCell("Message",i), Boolean.parseBoolean(tdObj.readCell("Submit",i)));
			
			//error message verifications
			if (Boolean.parseBoolean(tdObj.readCell("ErrorVerification",i))){
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				Assert.assertTrue(contactPageObj.firstnameError().contains(tdObj.readCell("FirstnameError",i)));
				Assert.assertTrue(contactPageObj.emailError().contains(tdObj.readCell("EmailError",i)));
				Assert.assertTrue(contactPageObj.telephoneError().contains(tdObj.readCell("TelephoneError",i)));
				Assert.assertTrue(contactPageObj.messageError().contains(tdObj.readCell("MessageError",i)));
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//verify success message
			if(Boolean.parseBoolean(tdObj.readCell("SuccessVerification",i))){
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				Assert.assertTrue(contactPageObj.verifySuccessMessage().contains(tdObj.readCell("SuccessMessage",i)));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//would be nice to click goback here but i am not able to click goback button
				//contactPageObj.clickGoBack();
			}
		 }	
	}
	
	


	
	
}
