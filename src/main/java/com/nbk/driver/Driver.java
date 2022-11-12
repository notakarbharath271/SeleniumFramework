package com.nbk.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nbk.constants.FrameworkConstants;
import com.nbk.enums.ConfigProperties;
import com.nbk.utilities.JsonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static void initDriver(String browser) throws Exception {

		if (Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
			DriverManager.setDriver( new ChromeDriver());
			
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				 //	System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
				 	DriverManager.setDriver(new FirefoxDriver());
			}
			//DriverManager.getDriver().get(PropertyUtility.get(ConfigProperties.URL));
			
			DriverManager.getDriver().get(JsonUtilities.getValue(ConfigProperties.URL));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getTimeInSeconds()));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
