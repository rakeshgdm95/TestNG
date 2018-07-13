package testbasic;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseEngine {
	private static WebDriver driver;
	private String curDir;
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional("chrome")String browser) {
		curDir = System.getProperty("user.dir");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", curDir+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			manageInit();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", curDir+"//drivers//firefoxdriver.exe");
			driver = new FirefoxDriver();
			manageInit();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", curDir+"//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			manageInit();
		}
	}
	
	private void manageInit() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void closeBrowser() {
		if (driver!=null) 
		driver.close();
		else
			System.out.println("DRIVER IS POINTING TO NULL...PLZ CHECK");
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	@BeforeMethod
	public void beforeTCExecution(Method method) {
		String tcName = method.getName();
		System.out.println("TC NAME IS: " + tcName);
	}
	
	@AfterMethod
	public void AFTERTCExecution(ITestResult result) throws IOException {
		String tcName = result.getName();
	if (result.getStatus()==result.FAILURE) {
			TakesScreenshot t=(TakesScreenshot)getDriver();
			File file = t.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile
(file, new File(curDir+"\\failurescreenshots\\"+tcName+".jpeg"));
		}
		else if (result.getStatus()==result.SKIP) {
			TakesScreenshot t=(TakesScreenshot)getDriver();
			File file = t.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile
(file, new File(curDir+"\\failurescreenshots\\"+tcName+".jpeg"));
		}
		
	}
	
}
