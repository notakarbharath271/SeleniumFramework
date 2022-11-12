package com.nbk.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.nbk.constants.FrameworkConstants;
import com.nbk.enums.ConfigProperties;

public final class PropertyUtility {

	private static Properties properties = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<String,String>();
	private PropertyUtility() {

	}
	
	static {
	
		try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigProPath());) {			
			properties.load(fileInputStream);
			/*
			for (Object key: properties.keySet()) {
				CONFIGMAP.put(String.valueOf(key),String.valueOf(properties.get(key)));
			}*/
			/*
			for(Map.Entry<Object, Object> entry:properties.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
			}*/
			//or
			properties.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
			throw new Exception(" Property name "+key+"is not found. Please check config.propreties.");
		}
		return CONFIGMAP.get(key.toString().toLowerCase());
	}
	/*
public static String getValue(String key) throws Exception {

	if(Objects.isNull(properties.getProperty(key))|| Objects.isNull(key)) {
		throw new Exception(" Property name "+key+"is not found. Please check config.propreties.");
	}
	return properties.getProperty(key);
	
}
*/

}
