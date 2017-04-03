package com.testing.testcases;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.testing.demo.BasePage;
import com.testing.demo.LoginPage;
import com.testing.demo.ShopPage;

public class ShopPageTests extends BaseTestSuite {

	@Test
	public void test() {
		BasePage basePageObj = new BasePage(driver);
		ShopPage shopPageObj = basePageObj.navigateShop();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		shopPageObj.findByPrice();
	}

}
