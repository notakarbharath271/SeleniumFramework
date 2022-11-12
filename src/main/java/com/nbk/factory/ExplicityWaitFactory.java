package com.nbk.factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nbk.constants.FrameworkConstants;
import com.nbk.driver.DriverManager;
import com.nbk.enums.WaitStrategy;

public class ExplicityWaitFactory {
	
	public static WebElement performeExplicitywait(WaitStrategy waitStrategy,By by) {
		
		WebElement element =null;
		if(waitStrategy==WaitStrategy.CLICKABLE){
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitywaittime()))
			.until(ExpectedConditions.elementToBeClickable(by));//old faction way
			 		//.until(d->d.findElement(by)).isEnabled();//java8 feature

			}else if (waitStrategy==WaitStrategy.PRESENCES) {
			 element =	new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitywaittime()))
				.until(ExpectedConditions.presenceOfElementLocated(by));//old faction way
				 		//.until(d->d.findElement(by)).isEnabled();//java8 feature
			}
		return element;
	}

}
