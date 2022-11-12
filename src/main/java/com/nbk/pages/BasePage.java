package com.nbk.pages;

import org.openqa.selenium.By;

import com.nbk.driver.DriverManager;
import com.nbk.enums.WaitStrategy;
import com.nbk.extentreports.ExtentLogger;
import com.nbk.factory.ExplicityWaitFactory;

public class BasePage {
	
	protected void clickOnElement(By by,WaitStrategy waitStrategy,String elementname) {
		ExplicityWaitFactory.performeExplicitywait(waitStrategy, by).click();
		try {
			ExtentLogger.pass(elementname+" clicked",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	protected void sendKeysInTOTextField(By by,String value,WaitStrategy waitStrategy,String elementname) {
		ExplicityWaitFactory.performeExplicitywait(waitStrategy, by).sendKeys(value);
		try {
			ExtentLogger.pass(value+" is entered sucessfully in "+elementname,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	


}
