package com.nbk.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nbk.driver.DriverManager;
/**
 * thumb rule
 * 1.Never hard code 
 * 2. Keep the right things at right place
 * 
 *
 */
public final class LoginTests extends BaseTest{

	
	 private LoginTests() {}
	@Test
	public void test1() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);

	}
	@Test
	public void test2() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium",Keys.ENTER);

	}
	
	@Test(dataProvider = "data")
	public void dataDemo(String value) {
		System.out.println(value);
	}
	@DataProvider(name="data")
	public Object[] dataProvider() {
		return new Object[]{"Bharath","Sarath","Lavanya"};
	}


}
