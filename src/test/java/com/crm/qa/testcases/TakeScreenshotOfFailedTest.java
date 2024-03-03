package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.listeners.CustomListener;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

@Listeners(CustomListener.class)
public class TakeScreenshotOfFailedTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	
	public TakeScreenshotOfFailedTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
		homePage= new HomePage();
		
		//homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void loginToCRMApplication() {
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		String title= homePage.verigyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO1");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
