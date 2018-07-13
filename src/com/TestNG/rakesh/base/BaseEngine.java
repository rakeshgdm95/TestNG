package com.TestNG.rakesh.base;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xdgf.usermodel.section.geometry.Ellipse;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



	import java.io.File;
	import java.io.IOException;
	import java.lang.reflect.Method;
	import java.util.Scanner;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.TestNG.rakesh.utilities.ScreenshotUtility;
import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class BaseEngine{
		private static	String cDir;
		private static WebDriver driver;
		private static ExtentReports extentReports;
		private static ExtentTest extentTest;
 @Parameters({"browser"})
 @BeforeSuite
public void openBrowser(@Optional("chrome")String browser) {
		cDir = System.getProperty("user.dir");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", cDir+("\\drivers\\chromedriver.exe"));
			driver =new ChromeDriver();
			manageInit();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",cDir+ "\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			manageInit();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			manageInit();
		}
 }
	 public void manageInit() 
	 {
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
	      driver.manage().deleteAllCookies();	  }
public static WebDriver getDriver() {
	return driver;
	
}

@AfterSuite	
public void closeBrowser() {
if (driver!=null)
 //  driver.close();
//else
	System.out.println("pointer is showing null......plz check");
}

@BeforeMethod
public void beforeTCExecution(Method method)
{
	String tcName=method.getName();
	System.out.println("Testcase name is:  "+tcName);
	extentTest  =  extentReports.startTest(tcName);
}
@AfterMethod
public void AFTERTCExecution(ITestResult result) throws IOException {
	String tcName = result.getName();
	if (result.getStatus()==result.FAILURE) 
	{
		ScreenshotUtility.screenshot(getDriver(), tcName, cDir);
		getExtentTestObj().log(LogStatus.FAIL, result.getThrowable());
	}
	else if (result.getStatus()==result.SKIP) 
	{
		ScreenshotUtility.screenshot(getDriver(), tcName, cDir);
		getExtentTestObj().log(LogStatus.SKIP, result.getThrowable());
	}
	//BaseEngine b = new BaseEngine();
	//b.screenShotOne(driver, tcName, curDir);
	extentReports.endTest(extentTest);
	extentReports.flush();
}		
	


@BeforeTest
public void initiateExtObj() {
	 extentReports = new ExtentReports(cDir+"//reports//report.html");
}

@AfterTest
public void afterReport() {
	extentReports.close();
}


public static ExtentTest getExtentTestObj() {
	return extentTest;
}

public static String getDir()
{
	return cDir;
}

}
	