package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends BaseClass {

	ContactsPage contactsPage;
	DealsPage dealsPage;
	HomePage homePage;
	LoginPage loginPage;
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		homePage = new HomePage();
		
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verigyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Title doesn't match");
	}

	@Test(priority = 2)
	public void clickOnContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 3)
	public void verifyUserNameLabelTest() {
		boolean b = homePage.userNameLabel();
		Assert.assertTrue(b);
	}

	@Test(priority = 4)
	public void clickOnDealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
