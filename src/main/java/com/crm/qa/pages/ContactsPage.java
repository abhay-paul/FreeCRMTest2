package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseClass;


public class ContactsPage extends BaseClass {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(name = "title")
	WebElement title;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement surName;

	@FindBy(id = "mobile")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
//	@FindBy(xpath="//a[contains(text(),'Contacts')]")
//	WebElement contactsLink;
//	
//	@FindBy(xpath="//a[contains(text(),'New Contact')]")
//	WebElement newContactsLink;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectContactByName(String name) {
		driver.findElement(
				By.xpath("//a[text()='" + name + "']//parent::td//preceding-sibling::td//input[@name='contact_id']"))
				.click();
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
//	public void clickOnNewContactsLink() {
//		Actions action= new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		new WebDriverWait(driver,Duration.ofSeconds(30))
//		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Contacts')]")));
//		newContactsLink.click();
//	}
	
	public void createNewContact(String titles,String fName, String sName, String mobiles ) {
		Select select= new Select(title);
		new WebDriverWait(driver, Duration.ofSeconds(30))
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("title")));
		select.selectByVisibleText(titles);
		title.sendKeys(titles);
		firstName.sendKeys(fName);
		surName.sendKeys(sName);
		mobile.sendKeys(mobiles);
		saveBtn.click();
		
		
		
		
	}
}
