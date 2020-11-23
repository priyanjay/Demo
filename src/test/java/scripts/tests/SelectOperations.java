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

public class SelectOperations extends Common{
	
	@BeforeClass
	public void before() {
		WebDriverManager.chromedriver().setup();
		Util.driver=new ChromeDriver();
		Util.driver.manage().window().maximize();
		Util.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(testName="Click on Verified Publisher and validate navigation", priority=0)
	public void verifiedPublisherNavigation() {
		try {
			Util.driver.get(Util.getValue("homepage"));
			Log.log("Navigated to homepage : "+Util.getValue("homepage"));
			Homepage homepage=new Homepage();
			homepage.clickVerifiedPublisherCheckBox();
		}catch(Exception e){
			Log.fail("Validate Publisher Content operation "+e.getMessage());
		}
	}

	@Test(testName="Click on Base Image and database filter and validate navigation", dependsOnMethods="verifiedPublisherNavigation")
	public void verifyBaseImageDatabaseSelectBox() {
		try {
			Homepage homepage=new Homepage();
			homepage.clickBaseImagesCheckBox();
			homepage.clickDatabaseCheckBox();
		}catch(Exception e){
			Log.fail("Validate Base Images operation "+e.getMessage());
		}
	}
	
	@Test(testName="Remove Database filter and validate result", dependsOnMethods="verifyBaseImageDatabaseSelectBox")
	public void removeDatabaseFilter() {
		try {
			Homepage homepage=new Homepage();
			homepage.disableDatabaseFilter();
		}catch(Exception e){
			Log.fail("Validate Base Images operation "+e.getMessage());
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		Util.driver.close();
	}
	
}
