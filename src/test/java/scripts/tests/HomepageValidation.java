package scripts.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Homepage;
import pages.Log;
import scripts.Common;
import scripts.Util;

public class HomepageValidation extends Common{
	
	@BeforeClass
	public void before() {
		WebDriverManager.chromedriver().setup();
		Util.driver=new ChromeDriver();
		Util.driver.manage().window().maximize();
		Util.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(testName="Validate Default Tab")
	public void validateDefaultTab() {
		try {
			Util.driver.get(Util.getValue("homepage"));
			Log.log("Navigated to homepage : "+Util.getValue("homepage"));
			Homepage homepage=new Homepage();
			homepage.validateDefaultTab(Util.getValue("defaultTab"));
		}catch(Exception e){
			Log.fail("Validate Default Tab"+e.getMessage());
		}
	}

	@Test(testName="Validate checkboxes on the homepage", dependsOnMethods="validateDefaultTab")
	public void validateCheckboxesOnHomepage() {
		try {
			Homepage homepage=new Homepage();
			homepage.validateVerifiedPublisherCheckBox();
			homepage.validateOfficialImagesCheckBox();
			homepage.validateCheckBoxCount(Integer.parseInt(Util.getValue("checkCount")));	
		}catch(Exception e){
			Log.fail("Validate Checkboxes on homepage failed"+e.getMessage());
		}
	}

	@Test(testName="Validate Categories filter on the homepage", dependsOnMethods="validateDefaultTab")
	public void validateCategoriesFilter() {
		try {
			Homepage homepage=new Homepage();
			homepage.validateCategoriesCheckboxes();
		}catch(Exception e){
			Log.fail("Validate Categories filter on the homepage"+e.getMessage());
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		Util.driver.close();
	}

}
