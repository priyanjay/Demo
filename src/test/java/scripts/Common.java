package scripts;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Log;
import util.TestListener;

public class Common {
	
	@BeforeMethod
	public void setupName(Method method) {
		TestListener.currentTestName = method.getAnnotation(Test.class).testName();
	}
	
	public static boolean isDisplayed(WebElement element) {
		if(element.isDisplayed()) {
			Log.pass("Element \""+element.getText()+"\" is displayed on the page "+Util.driver.getCurrentUrl());
			return true;
		}else {
			Log.fail("Element \""+element.getText()+"\" is not displayed on the page "+Util.driver.getCurrentUrl());
			return false;
		}
	}
	
}
