package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.Common;
import scripts.Util;

public class Homepage extends Common{
	
	@FindBy(xpath="//button[contains(text(),'Containers')]") WebElement containerTab;
	
	@FindBy(xpath="//button[contains(@class,'selectedClass')]") WebElement defaultTab;
	
	@FindBy(xpath="//div[div/label/div/span[contains(text(),'Verified Publisher')]]/input") WebElement checkBoxVerifiedPublisher;
	
	@FindBy(xpath="//div[div/label/div/span[contains(text(),'Official Images')]]/input") WebElement checkBoxOfficialImages;
	
	@FindBy(xpath="//div[div[text()='Images']]//input") List<WebElement> allCheckBoxes;
	
	@FindBy(xpath="//div[@id='categoriesFilterList']//div/input") List<WebElement> categoriesFilter;
	
	@FindBy(xpath="//div[@id='categoriesFilterList']//label[text()='Analytics']") WebElement analytics;
	
	@FindBy(xpath="//div[@id='categoriesFilterList']//label[text()='Base Images']") WebElement baseImages;
	
	@FindBy(xpath="//div[@id='categoriesFilterList']//label[text()='Databases']") WebElement databases;
	
	@FindBy(xpath="//div[@id='categoriesFilterList']//label[text()='Storage']") WebElement storage;
	
	@FindBy(xpath="//div[text()='Publisher Content'][contains(@class,'closeFilter')]") WebElement publisherContentHeader;
	
	@FindBy(xpath="//div[text()='Base Images'][contains(@class,'closeFilter')]") WebElement baseImagesHeader;
	
	@FindBy(xpath="//div[text()='Databases'][contains(@class,'closeFilter')]") WebElement databsesHeader;
	
	@FindBy(xpath="//div[@id='categoriesFilterList']//input[@value='base']") WebElement baseImagesCheckbox;
	
	@FindBy(xpath="//div[@id='categoriesFilterList']//input[@value='database']") WebElement databaseCheckbox;
	
	public Homepage() {
		PageFactory.initElements(Util.driver, this);
	}

	
	public void validateDefaultTab(String expectedText) throws Exception {
		try {
		Util.waitForElementToBeVisible(defaultTab);
		assertTrue(containerTab.isDisplayed(),"Container Tab Displayed");	
		Log.log("Default Tab Text : "+defaultTab.getText());
		assertTrue(defaultTab.getText().contains(expectedText),"Default Tab Contains "+expectedText);		
		}catch(Exception e) {
			throw e;
		}
		}
	
	public void validateVerifiedPublisherCheckBox() throws Exception{
		try {
		Log.log("Verifying Verified Publisher Checkbox");
		Util.waitForElementToBeVisible(defaultTab);
		assertTrue(checkBoxVerifiedPublisher.isEnabled(),"Verified Publisher Checkbox id displayed");		
	}catch(Exception e) {
		throw e;
	}
	}
	
	public void validateOfficialImagesCheckBox() throws Exception{
		try {
		Log.log("Verifying Official Images Checkbox");
		Util.waitForElementToBeVisible(defaultTab);
		assertTrue(checkBoxOfficialImages.isEnabled(),"Official Images Checkbox id displayed");		
	}catch(Exception e) {
		throw e;
	}
	}
	
	public void validateCheckBoxCount(int count) throws Exception{
		try {
		Log.log("Validating Checkbox count below Images");
		Log.log("Actual Check box count is : "+allCheckBoxes.size());
		assertTrue(allCheckBoxes.size()==count,"Checkbox count is : "+count);
		}catch(Exception e) {
			throw e;
		}
		}
	public void validateCategoriesCheckboxes() throws Exception{
		try {
		Util.waitForElementToBeVisible(defaultTab);
		Log.log("Validating \"Analytics\" filter");
		assertTrue(Common.isDisplayed(analytics),"\"Analytics\" checkbox is displayed");
		Log.log("Validating \"Base Images\" filter");
		assertTrue(Common.isDisplayed(baseImages),"\"Base Images\" checkbox is displayed");
		Log.log("Validating \"Databases\" filter");
		assertTrue( Common.isDisplayed(databases),"\"Databases\" checkbox is displayed");
		Log.log("Validating \"Storage\" filter");
		assertTrue(Common.isDisplayed(databases),"\"Storage\" checkbox is displayed");
		}catch(Exception e) {
			throw e;
		}
		}
	
	public void clickVerifiedPublisherCheckBox() throws Exception{
		try {
		Log.log("Verifying Verified Publisher Checkbox");
		Util.waitForElementToBeVisible(defaultTab);
		assertTrue(checkBoxVerifiedPublisher.isEnabled(),"Verified Publisher Checkbox is displayed");	
		Log.log("Clicking on \"Verified Publisher\" checkbox");
		checkBoxVerifiedPublisher.click();
		Util.waitForElementToBeVisible(publisherContentHeader);
		Log.log("Validate that Publisher Content filter is applied successfully");
		assertTrue(Common.isDisplayed(publisherContentHeader),"\"Publisher Content\" filter is applied successfully");
	}catch(Exception e) {
		throw e;
	}
	}
	
	public void clickBaseImagesCheckBox() throws Exception{
		try {
		Log.log("Verifying Base Images Checkbox");
		Util.waitForElementToBeVisible(defaultTab);
		assertTrue(Common.isDisplayed(baseImages),"Base Images Checkbox is displayed");	
		Log.log("Clicking on \"Base Images\" checkbox");
		baseImagesCheckbox.click();
		Util.waitForElementToBeVisible(baseImagesHeader);
		Log.log("Validate that Base Images filter is applied successfully");
		assertTrue(Common.isDisplayed(baseImagesHeader),"\"Base Images\" filter is applied successfully");
	}catch(Exception e) {
		throw e;
	}
	}
	
	public void clickDatabaseCheckBox() throws Exception{
		try {
		Log.log("Verifying Database Checkbox");
		Util.waitForElementToBeVisible(defaultTab);
		assertTrue(Common.isDisplayed(databases),"Database Checkbox is displayed");	
		Log.log("Clicking on \"Database\" checkbox");
		databaseCheckbox.click();
		Util.waitForElementToBeVisible(databsesHeader);
		Log.log("Validate that Database filter is applied successfully");
		assertTrue(Common.isDisplayed(databsesHeader),"\"Database\" filter is applied successfully");
	}catch(Exception e) {
		throw e;
	}
	}
	
	public void disableDatabaseFilter() throws Exception{
		try {
		Log.log("Removing database filter");
		Util.waitForElementToBeVisible(defaultTab);
		assertTrue(Common.isDisplayed(databsesHeader),"Database Additional Filter is displayed");	
		Log.log("Clicking on \"Database\" filter close button");
		databsesHeader.click();
		Util.waitForElementToBeVisible(databases);	
		if(databaseCheckbox.isSelected()) {
			Log.fail("Database filter is not removed from filter");
		}else {
			Log.pass("Database filter is removed from filter");
		}
	}catch(Exception e) {
		throw e;
	}
	}

}
