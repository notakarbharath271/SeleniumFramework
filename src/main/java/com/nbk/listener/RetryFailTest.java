package com.nbk.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.nbk.enums.ConfigProperties;
import com.nbk.utilities.PropertyUtility;

public class RetryFailTest implements IRetryAnalyzer{

	
	private int count=0;
	private int retries =1; 
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		try {
			if(PropertyUtility.get(ConfigProperties.RETRYFAILTESTS).equalsIgnoreCase("yes")) {
			 value=count<retries;
			count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
