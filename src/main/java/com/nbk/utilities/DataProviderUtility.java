package com.nbk.utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.nbk.constants.FrameworkConstants;

public final class DataProviderUtility {
	private static List<Map<String, String>> list = new ArrayList<>();
	@DataProvider(parallel = true)
	public static Object[] getData(Method method) {
		
		String testname = method.getName();
		
		if(list.isEmpty()) {
		 list =ExcelUtility.getTestDetials(FrameworkConstants.getTestdataheetname());
		}
		List<Map<String, String>> smallist = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("TestName").equalsIgnoreCase(testname) &&list.get(i).get("Execute").equalsIgnoreCase("yes")) {
					smallist.add(list.get(i));
				}
			}
		return smallist.toArray();
		
	}

}
