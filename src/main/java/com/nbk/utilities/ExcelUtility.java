package com.nbk.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nbk.constants.FrameworkConstants;

public final class ExcelUtility {
	
	private ExcelUtility() {}
	
	public static List<Map<String, String>> getTestDetials(String sheetName) {
		List<Map<String,String>>list =null;
		
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getExceltestpath());XSSFWorkbook wb = new XSSFWorkbook(fis);) {
			
		XSSFSheet sheet= wb.getSheet(sheetName);
		int lastrowcount =	sheet.getLastRowNum();
		int lastcolumncount = sheet.getRow(0).getLastCellNum();
		Map<String,String> map = null;
		list=new ArrayList<>();
		for(int i=1;i<=lastrowcount;i++) {
			map= new HashMap<>();
			for(int j=0;j<lastcolumncount;j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}			
			list.add(map);
		}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
