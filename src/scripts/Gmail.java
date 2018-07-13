package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import testbasic.BaseEng;
import testbasic.BaseEngine;

public class Gmail extends BaseEngine{
@Test
public  void gmail(){
	
	
	getDriver().get("https://www.gmail.com");
	
	
	
	
}

}
