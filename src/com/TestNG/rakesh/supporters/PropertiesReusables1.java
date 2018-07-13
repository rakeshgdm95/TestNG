package com.TestNG.rakesh.supporters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesReusables1 {
	private String filePath;
	private FileInputStream fip;
	private Properties properties;
	//passing file and loading the file into java program
	public PropertiesReusables1(String filePath) throws IOException
	{
		this.filePath = filePath;
		fip = new FileInputStream(filePath);
		properties = new Properties();
		properties.load(fip);
	}
	
	public String getPropertyValue(String key) {
		String value = null;
		if (properties!=null) 
			value = properties.getProperty(key);
		return value;
	}
	
	public String getPropertyDefValue(String key,String def) {
		String value = null;
		if (properties!=null) 
		{
			value = properties.getProperty(key);
			if (value == null) {
				value = def;
			}
		}
		return value;
	}
	
	public void setKeyValuePair(String key,String value) throws IOException
	{
		if (properties!=null) {
			properties.setProperty(key, value);
			FileOutputStream fop = new FileOutputStream(filePath);
			properties.store(fop, "Succesfully added the data");
		}
	}
	
	public void removeKey(String key) throws IOException
	{
		if (properties!=null) {
			properties.remove(key);
			FileOutputStream fop = new FileOutputStream(filePath);
			properties.store(fop, "Succesfully added the data");
		}
	}
		
	public Map<String, String> getAllPropertiesEntries()
	{
		Map<String, String> map = new LinkedHashMap();
		if (properties!=null) {
			Set<Object> keys = properties.keySet();
			for(Object key : keys)
			{
				String  key1 = (String)key;
				String value = properties.getProperty(key1);
				map.put(key1, value);
			}
		}
		return map;
	}

}
