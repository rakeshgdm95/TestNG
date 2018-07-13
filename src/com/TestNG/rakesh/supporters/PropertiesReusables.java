package com.TestNG.rakesh.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReusables {
	private Properties pr;
	private FileInputStream fip;
	private String filepath;
public PropertiesReusables(String filepath) throws IOException {
	this.filepath=filepath;
	fip=new FileInputStream(filepath);
	pr=new Properties();
	pr.load(fip);
}
public String getpropertyvalue(String key) {
	
	String value=pr.getProperty(key);
	
	
	return value;
}

}
