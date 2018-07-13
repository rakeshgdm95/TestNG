package testbasic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;


public class Reuseable {
	  String filepath;
	  Properties pr;
	  FileInputStream fip;
public	Reuseable() throws IOException{
		this.filepath = filepath;
		
		fip=new FileInputStream(filepath);
		Properties pr=new Properties();
		pr.load(fip);
		
	}
public String getproperTValue(String key) {
	String un=pr.getProperty(key);
	return un;
}
	
}
