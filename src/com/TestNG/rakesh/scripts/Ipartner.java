package com.TestNG.rakesh.scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hwpf.model.ListTables;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.TestNG.rakesh.base.ActionEngine;
import com.TestNG.rakesh.base.BaseEngine;
import com.TestNG.rakesh.supporters.ExcelReader;
import com.TestNG.rakesh.supporters.PropertiesReusables;
import com.TestNG.rakesh.utilities.ApplVariables;
import com.TestNG.rakesh.utilities.LocMechValues;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class Ipartner extends ActionEngine {
	private static PropertiesReusables prConf;
	PropertiesReusables prOr;
	PropertiesReusables prexcel;
	@Test(priority=1)
public void login() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
				
		prConf=ApplVariables.getOrObj(ApplVariables.getConffilePath());
		prOr=ApplVariables.getOrObj(ApplVariables.getOrfilePath());
		prexcel=ApplVariables.getOrObj(ApplVariables.getExcelfilePath());
		{
		String url = prConf.getpropertyvalue("I_url");
		getDriver().get(url);
		getExtentTestObj().log(LogStatus.INFO, "URL is entered as : " + url);
		
		click(prOr.getpropertyvalue("I_xpt"), LocMechValues.xpath);
		

		Thread.sleep(7000);
		System.out.println("git did");

		

		switchmultWinds(1);
		
		enterData(prOr.getpropertyvalue("I_un"), LocMechValues.id, prConf.getpropertyvalue("Icnf_un"));
		enterData(prOr.getpropertyvalue("I_pw"), LocMechValues.id, prConf.getpropertyvalue("Icnf_pw"));
		
		selectByValue(prOr.getpropertyvalue("I_prdt"), LocMechValues.id, "1");
		
		click(prOr.getpropertyvalue("I_lg_xpt"), LocMechValues.xpath);
}
}		
		@Test (priority=2)
		public void logOut() {
		click(prOr.getpropertyvalue("I_logoutxpt"), LocMechValues.xpath);
		}	
}

	
