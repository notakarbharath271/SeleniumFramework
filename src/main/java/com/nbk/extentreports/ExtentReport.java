package com.nbk.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nbk.constants.FrameworkConstants;
import com.nbk.enums.CatagoryType;

public final class ExtentReport {

	private static ExtentReports reports;

	private ExtentReport() {
	}

	public static void initExtent() throws Exception {
		if (Objects.isNull(reports)) {
			reports = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
			spark.config().setDocumentTitle("OrangeHRM ExtentReports");
			spark.config().setReportName("OrangeHRMReports");
			spark.config().setTheme(Theme.DARK);
			reports.setSystemInfo("Author", "BHARATH KUMAR");
			reports.setSystemInfo("Operating System", "WINDOWS 11");
			reports.attachReporter(spark);
		}
	}

	public static void flushReport() throws Exception {
		if (Objects.nonNull(reports)) {
			reports.flush();
		}
		ExtentReportManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());
	}

	public static void createTest(String testName) {

		ExtentReportManager.setExtentTest(reports.createTest(testName));
	}

	public static void addAuthots(String[] authors) {
		for(String author:authors) {
			ExtentReportManager.getExtentTest().assignAuthor(author);
		}
	}

	public static void addCatogries(CatagoryType[] catagories) {
		for(CatagoryType catagory:catagories) {
			ExtentReportManager.getExtentTest().assignCategory(catagory.toString());
		}
	}
	
	public static void addDevices(String[] devices) {
		for(String device:devices) {
			ExtentReportManager.getExtentTest().assignDevice(device);
		}

	}

}
