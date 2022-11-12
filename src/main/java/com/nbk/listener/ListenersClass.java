package com.nbk.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.nbk.annotations.FrameworkAnnotation;
import com.nbk.extentreports.ExtentLogger;
import com.nbk.extentreports.ExtentReport;

public class ListenersClass implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initExtent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthots(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCatogries(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).catagory());
		ExtentReport.addDevices(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).device());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			//ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * 
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * 
		 */
	}

}
