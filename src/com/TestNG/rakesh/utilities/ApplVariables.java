package com.TestNG.rakesh.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.TestNG.rakesh.base.BaseEngine;
import com.TestNG.rakesh.supporters.ExcelReader;
import com.TestNG.rakesh.supporters.PropertiesReusables;

public class ApplVariables {
	private static String orfilePtah="C:\\Users\\MandU\\eclipse-workspace\\TestNG\\src\\com\\TestNG\\rakesh\\objectrepository\\or.properties";
	private static String conffilePtah="C:\\Users\\MandU\\eclipse-workspace\\TestNG\\config.properties";
	private static String excelfilePtah="C:\\Users\\MandU\\eclipse-workspace\\TestNG\\src\\com\\TestNG\\rakesh\\testData\\TestData.xls";

	public static PropertiesReusables getOrObj(String file) throws EncryptedDocumentException, InvalidFormatException, IOException,InterruptedException
	{
		PropertiesReusables propertiesReusables = new PropertiesReusables(file);
		return propertiesReusables;
	}
	
	
	
	public static String getOrfilePath()
	{
		return orfilePtah;
	}

	public static String getConffilePath()
	{
		return conffilePtah;
	}
	public static String getExcelfilePath()
	{
		return excelfilePtah;
	}

	public static ExcelReader getExcelObj() throws EncryptedDocumentException, InvalidFormatException, IOException,InterruptedException
	{
		ExcelReader excelReader = new ExcelReader(excelfilePtah);
		return excelReader;
	}




	

	}
