package pages;

import com.aventstack.extentreports.Status;

import util.ExtentTestManager;

public class Log {
	public static void log(String message) {
		ExtentTestManager.getTest().log(Status.INFO, message);
	}
	
	public static void pass(String message) {
		ExtentTestManager.getTest().log(Status.PASS, message);
	}
	
	public static void fail(String message) {
		ExtentTestManager.getTest().log(Status.FAIL, message);
	}
}
