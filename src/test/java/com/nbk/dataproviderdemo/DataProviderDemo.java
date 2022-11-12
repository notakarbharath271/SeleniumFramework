package com.nbk.dataproviderdemo;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	@Test(dataProvider = "dataProvider")
	public void dataTest(String value) {
		System.out.println("Meethod 1 : "+value);
	}
	@Test(dataProvider = "dataProvider")
	public void dataTest2(String value) {
		System.out.println("Meethod 2 : "+value);
	}
	

	@DataProvider
	public Object[] dataProvider(Method method) {
		if(method.getName().equalsIgnoreCase("dataTest")) {
		return new Object[] {"Sarath","Bharath","Lavanya"};
		}else if(method.getName().equalsIgnoreCase("dataTest2")) {
			return new Object[] {"Satheesh","Keethika","Raji"};
		}
		return null;
	}
}
