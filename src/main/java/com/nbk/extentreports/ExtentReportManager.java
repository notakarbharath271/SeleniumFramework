package com.nbk.extentreports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {
	
	private ExtentReportManager() {}
	
private static ThreadLocal<ExtentTest> etest = new ThreadLocal<>();
	
	
	 static ExtentTest getExtentTest() {
		return etest.get();
	}
	
	 static void setExtentTest(ExtentTest test) {
		etest.set(test);	}
	
	 static void unload() {
		etest.remove();
	}

}
