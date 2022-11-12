package com.nbk.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.nbk.driver.DriverManager;

public final class HomePageTests extends BaseTest{
	
	private HomePageTests() {}
	@Test
	public void test3() {
		   DriverManager.getDriver().findElement(By.name("q")).sendKeys("RestAssured",Keys.ENTER);
	}

}
