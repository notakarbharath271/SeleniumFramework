package com.nbk.extentreports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.nbk.enums.ConfigProperties;
import com.nbk.utilities.PropertyUtility;
import com.nbk.utilities.ScreenshotUtilis;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}
	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}
	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message,boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtility.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
			&&	isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtilis.getBase64Image()).build());
		}else {
			pass(message);
		}
			
	}
	public static void fail(String message,boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtility.get(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
			&&	isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtilis.getBase64Image()).build());
		}else {
			fail(message);
		}
			
	}
	public static void skip(String message,boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtility.get(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
			&&	isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtilis.getBase64Image()).build());
		}
		else {
			skip(message);
		}
			
	}
	
	

}
