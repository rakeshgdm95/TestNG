package com.TestNG.rakesh.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public interface ScreenshotUtility {
public static void screenshot(WebDriver driver,String tcName,String cDir) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File file=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(cDir+"\\failurescreenshots\\"+tcName+".jpeg"));	
}
   
}
