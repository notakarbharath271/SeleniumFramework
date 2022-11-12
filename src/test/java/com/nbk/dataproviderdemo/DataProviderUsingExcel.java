package com.nbk.dataproviderdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingExcel {

	//@Test(dataProvider = "data")
	public void testDemo(String username, String password, String fname, String lname, String midname, String email) {
		System.out.println("User name : " + username);
		System.out.println("Password : " + password);
		System.out.println("first name : " + fname);
		System.out.println("last name : " + lname);
		System.out.println("Middle name : " + midname);
		System.out.println("Email : " + email);
	}
	@Test(dataProvider = "datausingMap")
	public void testDemo(Map<String, String> map) {
		System.out.println("User name : " + map.get("username"));
	}
	@DataProvider(name="datausingMap")
	public Object[] readDataFromExcelUsingMap() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\DataProviderUsingExcelsheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("TestData");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[] data = new Object[rowCount];
		Map<String,String> map;
		for (int i = 1; i <= rowCount; i++) {
			map=new HashedMap<>();
			for (int j = 0; j < colCount; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1]=map;				
			}
		}
		return data;
		

	}

	@DataProvider(name = "data")
	public Object[][] readDataFromExcel() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\DataProviderUsingExcelsheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("TestData");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;

	}

}
