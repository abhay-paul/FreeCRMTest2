package com.crm.qa.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseClass;


public class HomePage extends BaseClass{
	
	//Page factory
	
	@FindBy(xpath="//td[contains(text(),'Abhay Paul')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean userNameLabel() {
		return userNameLabel.isDisplayed();
	}
	public String verigyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContactsLink() {
		Actions action= new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		new WebDriverWait(driver,Duration.ofSeconds(30))
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Contacts')]")));
		newContactsLink.click();
	}
	
}






