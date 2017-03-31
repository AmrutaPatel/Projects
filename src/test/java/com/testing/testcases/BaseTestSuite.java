package com.testing.testcases;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.testing.util.ReadExcel;

public class BaseTestSuite {

	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Libraries\\chromedriver-2.28.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://jupiter.cloud.planittesting.com");
		Thread.sleep(200);
	}
	
	@Test
	public void testing(){
		
	}
}
