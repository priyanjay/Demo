package scripts;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	public static WebDriver driver;

	public static String getValue(String key) { 
		try {
			FileReader reader=new FileReader("src/main/resources/env.properties");
			Properties p=new Properties();  
			p.load(reader);  
			return p.getProperty(key);
		}catch(Exception e) {

		}  
		finally {
		}
		return null;
	}
	
	
	public static void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
