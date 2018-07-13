package com.TestNG.rakesh.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.TestNG.rakesh.supporters.ExcelReader;

import freemarker.core.ReturnInstruction.Return;

public class ActionEngine extends BaseEngine{
public static WebElement getElement(String locType,String locMech) {
	WebElement element=null;
	switch (locMech) {
	case "id":
		element= getDriver().findElement(By.id(locType));
		break;
	case "class":
		element=getDriver().findElement(By.className(locType));
		break;
	case "name":
		element=getDriver().findElement(By.name(locType));
		break;
	case "xpath":
		element=getDriver().findElement(By.xpath(locType));
		break;
	case "css":
		element=getDriver().findElement(By.cssSelector(locType));
		break;
	case "linkText":
		element=getDriver().findElement(By.linkText(locType));
		break;
	case "partialLinkText":
		element=getDriver().findElement(By.partialLinkText(locType));
		break;
	case "tagName":
		element=getDriver().findElement(By.tagName(locType));
		break;
	}
	return element;
}
public static  List<WebElement> getElements(String locType,String locMech) {
	List<WebElement> element=null;
	switch (locMech) {
	
	case "id":
		element=getDriver().findElements(By.id(locType));
		break;
	case "name":
		element=getDriver().findElements(By.name(locType));
		break;
	case "class":
		element=getDriver().findElements(By.className(locType));
		break;	
	case "xpath":
		element=getDriver().findElements(By.xpath(locType));
		break;
	case "css":
		element=getDriver().findElements(By.cssSelector(locType));
		break;
	case "linkText":
		element=getDriver().findElements(By.linkText(locType));
		break;
	case "partialLinkText":
		element=getDriver().findElements(By.partialLinkText(locType));
		break;
	case "tagName":
		element=getDriver().findElements(By.tagName(locType));
		break;
	}
	return element;
}
public static void click(String locType,String locMech)
{
	WebElement element=getElement(locType, locMech);
	if(element.isDisplayed()&&element.isEnabled())
		element.click();
	else 
		System.out.println("element is not Displayed");
}

public static void enterData(String locType,String locMech,String testData)
{
	WebElement element=getElement(locType, locMech);
	if(element.isDisplayed()&&element.isEnabled()) {
		element.clear();
	    element.sendKeys(testData);
	    }
	else 
		System.out.println("element is not Displayed");
}
public static void mouseHover(String locType,String locMech)
{
	WebElement element=getElement(locType, locMech);
	Actions actions=new Actions(getDriver());
	if(element.isDisplayed()&&element.isEnabled()) {
		actions.moveToElement(element).build().perform();
	}
	else
		System.out.println("element is not Displayed");
}
public static void sendkeysEnter() {
	Actions actions=new Actions(getDriver());
	actions.sendKeys(Keys.ENTER).build().perform();;
}
public static void rightClick(String locType,String locMech) {
	WebElement element=getElement(locType, locMech);
	Actions actions=new Actions(getDriver());
	if (element.isDisplayed()&&element.isEnabled()) {
		actions.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	}
	else
		System.out.println("element is not Displayed ");
}
public static void selectByValue(String locType,String locMech,String value) {
	WebElement element=getElement(locType, locMech);
	if(element.getTagName().equalsIgnoreCase("select")) {
	Select select=new Select(getElement(locType, locMech));
	select.selectByValue(value);
}
	else 
	{
		List<WebElement> elements=getElements(locType, locMech);
	    elements.get(0).click();
	}
}

public static void switchBW2Windows() {
	String curWin=getDriver().getWindowHandle();
	Set<String> windows=getDriver().getWindowHandles();
	for(String window:windows)
	{
		if(!window.equalsIgnoreCase(curWin));
		getDriver().switchTo().window(window);
		break;
	}	
}
public static void switchmultWinds(int index) {
	/*String curwin=getDriver().getWindowHandle();
	Set<String> windows=getDriver().getWindowHandles();
	List<String> list=new ArrayList();
	String windName=list.get(index);
	getDriver().switchTo().window(windName);*/
	Set<String> window=getDriver().getWindowHandles();
	System.out.println(window);
	ArrayList<String> list=new ArrayList<String>(window);
	getDriver().switchTo().window(list.get(index));
}

public static boolean waitForTime(String locType,String locMech) {
	boolean wait=true;
	for(int i=0;i<=45;i++)
	{
		try {
			Thread.sleep(2000);
			WebElement element=getElement(locType, locMech);
			if(element.isDisplayed()&&element.isEnabled())
			{
				wait=true;
				break;
			}
     } catch (InterruptedException e){
    	 e.printStackTrace();
    	 wait = false;	 
     }
	}
	
	return false;
	
}

}
