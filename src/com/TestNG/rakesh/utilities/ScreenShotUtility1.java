package com.TestNG.rakesh.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility1 {
	
public static void screenShot(WebDriver driver,String tcName,String curDir) throws IOException
{
	TakesScreenshot t=(TakesScreenshot)driver;
	File file = t.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile
(file, new File(curDir+"\\failurescreenshots\\"+tcName+".jpeg"));
}



}
