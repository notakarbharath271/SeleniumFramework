package com.nbk.constants;

import com.nbk.enums.ConfigProperties;
import com.nbk.utilities.PropertyUtility;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String PROJECTPATH = System.getProperty("user.dir");
	private static final String CONFIGPROFILEPATH = PROJECTPATH + "/src/test/resources/Config/config.properties";
	private static final String CHROMEDRIVERPATH = PROJECTPATH+ "/src/test/resources/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = PROJECTPATH+ "/src/test/resources/executables/geckodriver.exe";
	private static final String CONFIGJSONPATH = PROJECTPATH + "/src/test/resources/Config/configJson.json";
	private static final String EXTENTREPORTFOLDERPATH = PROJECTPATH+"/extent-test-output/";
	private static final String EXCELTESTPATH = PROJECTPATH+"/src/test/resources/Excel/ExcelTestData.xlsx";
	private static final String RUNNERSHEETNAME="RUNMANAGER";
	private static final String TESTDATAHEETNAME="TestData";
	
	

	private static String extentreportfilepath="";
	

	private static final int IMPLICITYWAITTIME = 30;
	private static final int EXPLICITYWAITTIME = 30;

	public static int getExplicitywaittime() {
		return EXPLICITYWAITTIME;
	}

	public static int getTimeInSeconds() {
		return IMPLICITYWAITTIME;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigProPath() {
		return CONFIGPROFILEPATH;
	}
	public static String getConfigjsonpath() {
		return CONFIGJSONPATH;
	}
	

	public static String getExtentreportfilepath() throws Exception {
		if(extentreportfilepath.isEmpty()) {
			extentreportfilepath=createReportpath();
		}
		return extentreportfilepath;
	}
	
	public static String createReportpath() throws Exception {
		if(PropertyUtility.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
			
		}else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
	public static String getExceltestpath() {
		return EXCELTESTPATH;
	}
	
	public static String getRunnersheetname() {
		return RUNNERSHEETNAME;
	}

	public static String getTestdataheetname() {
		return TESTDATAHEETNAME;
	}

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}
	

}
