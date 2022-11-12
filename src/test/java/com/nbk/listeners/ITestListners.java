package com.nbk.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListners implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart suite method executed");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish suite method executed");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart method executed");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess method executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure method executed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped method executed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage method executed");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout method executed");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart method executed");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish method executed");
	}

}
