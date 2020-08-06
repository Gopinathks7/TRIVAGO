package com.common;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.generic.Property;

public class BasePage implements AutomationConstants
{
	
	public Logger log=Logger.getLogger(this.getClass());
	  public WebDriver driver;
	  public String strConfigFile;
	  public long timeout;
	  WebDriverWait wait;
	  JavascriptExecutor executor;
	  WebElement element;
	  public BasePage(WebDriver driver){
		  this.driver=driver;
		  strConfigFile=AutomationConstants.CONFIG_PATH+AutomationConstants.CONFIG_FILE;
		  timeout=Long.parseLong(Property.getPropertyValue(strConfigFile, "EXPLICIT"));
	  }
	  
	
	  public void moveToElement(WebElement element){
		  Actions actions=new Actions(driver);
		  actions.moveToElement(element).perform();
}

	  public void scrollToProduct(WebElement element)
	  {
		  executor=(JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].scrollIntoView();",element );
	  }
	  
	  public void closeBrowserOpened()
	  {
		  driver.quit();
	  }
	  
	
	  
	  public void switchingToFrame()
	  {
		 
		  driver.switchTo().frame(1);
	  }
	  
	  
	  public void assertTrueCmp(String actual,String expected)
	  {
		  Assert.assertTrue(actual.contains(expected));
	  }
	  
	  public void getSelectByVisibleText(WebElement element,String text)
	  {
		  
		  Select select=new Select(element);
		  select.selectByVisibleText(text);
	  }
	
	  public void switchBrowser() 
	  {
		
		  String newurl="https://www.agoda.com/en-in/search?cid=1844602&currency=INR&checkin=2020-08-24&checkout=2020-08-25&NumberofAdults=2&NumberofChildren=0&Rooms=1&mcid=3038&tchash=N30w8kJ7iaU&trv_curr=INR&trv_dp=6922&trv_ttt=19&trv_tttb=15&trv_los=1&trv_losb=1&trv_pg=0&trv_defdate=0&tag=9fec938e-a721-4d0a-ac1a-d3bf9b1e06e8&selectedproperty=1523346&city=4923&adults=2&children=0&hc=INR&los=1";
		  Set<String> window = driver.getWindowHandles();
		  Iterator<String>itr=window.iterator();
		  String parent=itr.next();
		  driver.switchTo().window(parent);
		  String child=itr.next();
		  driver.switchTo().window(child);
		driver.navigate().to(newurl);
		driver.manage().deleteAllCookies();

	  
	  }
	  
	  public void getListOFWebElement(List<WebElement > element,String xpath)
	  
	  {
		driver.findElements(By.xpath(xpath)) ;
	  }
	  
	  
	  public void getCount(List<WebElement> element)
  	  {
		  try
		  {
	int count=element.size();
	for(int i=0;i<count;i++)
	{
		WebElement ele=element.get(i);
		String expected=ele.getText();
		Thread.sleep(2000);
		log.info("The Hotel present on the first page is ==>"+expected);
  }
}
	  catch (Exception e) {
		// TODO: handle exception
	}
}
}