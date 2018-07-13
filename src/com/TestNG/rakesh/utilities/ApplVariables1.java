package com.TestNG.rakesh.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.TestNG.rakesh.supporters.ExcelReader;
import com.TestNG.rakesh.supporters.PropertiesReusables;


public class ApplVariables1 {
	private static String orFilePtah="C:\\Users\\MandU\\eclipse-workspace\\TestNG\\src\\com\\TestNG\\rakesh\\objectrepository\\or.properties";
	private static String confFilePtah="C:\\Users\\MandU\\eclipse-workspace\\TestNG\\config.properties";
	private static String excelFilePtah="C:\\Users\\MandU\\eclipse-workspace\\TestNG\\src\\com\\TestNG\\rakesh\\testData\\TestData.xls";

	public static String getOrFilePath()
	{
		return orFilePtah;
	}

	public static String getConfFilePath()
	{
		return confFilePtah;
	}
	public static String getExcelFilePath()
	{
		return excelFilePtah;
	}

	public static ExcelReader getExcelObj() throws EncryptedDocumentException, InvalidFormatException, IOException,InterruptedException
	{
		ExcelReader excelReader = new ExcelReader(excelFilePtah);
		return excelReader;
	}


	public static PropertiesReusables getOrObj(String file) throws EncryptedDocumentException, InvalidFormatException, IOException,InterruptedException
	{
		PropertiesReusables propertiesReusables = new PropertiesReusables(file);
		return propertiesReusables;
	}

	public static PropertiesReusables getConfObj(String file) throws IOException,EncryptedDocumentException,InvalidFormatException ,InterruptedException{
		PropertiesReusables propertiesReusables=new PropertiesReusables(file);
		return propertiesReusables;
	}

}
