package com.crm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPagetest extends BaseClass{
	Logger logger= LogManager.getLogger(ContactsPagetest.class);
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	static String sheetName= "Contacts Data";
	public ContactsPagetest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		logger.info("prerequisities are getting completed");
		initialization();
		logger.info("Browser initialized");
		loginPage= new LoginPage();
		homePage= new HomePage();
		contactsPage= new ContactsPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabeltest() {
		contactsPage= homePage.clickOnContactsLink();
		boolean b= contactsPage.verifyContactsLabel();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2)
	public void selectContactByNameTest() {
		contactsPage= homePage.clickOnContactsLink();
		contactsPage.selectContactByName("Shawn Parker");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void createNewContact(String title, String firstName, String lastName, String mobile) {
		logger.info("clicking on new contacts link from home page");
		homePage.clickOnNewContactsLink();
		//contactsPage.createNewContact("Mr.", "Jyoti", "Paul", "1234567893");
		//contactsPage.createNewContact(title,firstName, lastName, mobile);
		logger.info("clicked on new contacts link from home page");
		System.out.println(title+" "+firstName+" "+lastName+" "+mobile );
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
