package com.nbk.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections4.map.HashedMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbk.constants.FrameworkConstants;
import com.nbk.enums.ConfigProperties;

public class JsonUtilities {
	
	private  static Map<String, String> CONFIGMAP;
	private JsonUtilities() {}
	
	static {
		try {
			CONFIGMAP =new ObjectMapper().readValue(new File(FrameworkConstants.getConfigjsonpath()) , new TypeReference<HashedMap<String, String>>() {
			});
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public static String getValue(ConfigProperties key) throws Exception {

		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception(" Property name "+key+"is not found. Please check config.propreties.");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
		
	}

}
