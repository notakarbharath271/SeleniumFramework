package com.nbk.utilities;

public final class DyanmicXpath {

	private DyanmicXpath() {

	}
	
	public static String getXpath(String xpath,String value) {
		 return String.format(xpath, value);     //  or xpath.replace("%replacable%", value);
		
	}
}
