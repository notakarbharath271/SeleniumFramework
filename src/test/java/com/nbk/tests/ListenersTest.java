package com.nbk.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ListenersTest {
	
	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("Before suite method got executed");
	}
	
	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("After suite method got executed");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method got executed");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After  method got executed");
	}
	
	@Test
	public void test1() {
		System.out.println("Test1 method got executed");
	}
	@Test
	public void test2() {
		System.out.println("Test2 method got executed");
		Assert.assertTrue(false);
	}

	@Test
	public void test3() {
		System.out.println("Test3 method got executed");
	}


}
