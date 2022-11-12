package com.nbk.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nbk.driver.DriverManager;

public final class ScreenshotUtilis {

	
	private ScreenshotUtilis() {}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
