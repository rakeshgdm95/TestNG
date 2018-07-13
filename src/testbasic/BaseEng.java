package testbasic;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Driver;
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

public class BaseEng {
	private  String cDir;
	private static WebDriver driver;
@Parameters({"browser"})
@BeforeSuite
public void openBrowser(@Optional("chrome")String browser){
    cDir= System.getProperty("user.dir");
   if (browser.equalsIgnoreCase("chrome")) {
	   System.setProperty("webdriver.chrome.driver",cDir+"//drivers//chromedriver.exe");
	    driver=new ChromeDriver();
	   manageInit();
   }
   else if(browser.equalsIgnoreCase("firefox")) {
	   System.setProperty("webdriver.gecko.driver",cDir+ "//drivers//geckodriver.exe");
	    driver=new FirefoxDriver();
	   manageInit();
   }
   else if (browser.equalsIgnoreCase("ie")) {
	System.setProperty("webdriver.ie.driver", cDir+"//drivers//IEDriverServer.exe");
	 driver=new InternetExplorerDriver();
	manageInit();
	
}
   }
private void manageInit() {
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(65,TimeUnit.SECONDS);
}
@AfterSuite
public void closebrowser() {
	if (driver!=null)
		driver.close();
	else
		System.out.println("driver is pointing to null.........plz check");
}
public WebDriver getDriver() {
	return driver;
}
@BeforeMethod
public void beforeTCExecution(Method method)
{
	String tcName=method.getName();
	System.out.println("TestCase Name:" + tcName);
}
@AfterMethod
public void afterTCExecution(ITestResult result) throws IOException{
	String tcName= result.getName();
	if (result.getStatus()==result.FAILURE) {
		TakesScreenshot tc=(TakesScreenshot)getDriver();
		File file=tc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File (cDir+"//TestNG//screenShots"+tcName+".jpeg"));
	}
	else if (result.getStatus()==result.SKIP) {
		TakesScreenshot tc=(TakesScreenshot)getDriver();
		File file=tc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(cDir+"//TestNG/screenShots"+tcName+".jpeg"));
	}
	else if (result.getStatus()==result.SUCCESS) {
		System.out.println("TestCase success");}
	
}
}
