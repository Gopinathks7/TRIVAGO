package com.scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
public class Trivago
{

	public static void main(String[] args) throws InterruptedException 
	{
		String key="webdriver.chrome.driver";
		String value="E:\\BrowserDrivers\\common\\chromedriver.exe";
		System.setProperty(key, value);
		Proxy p= new Proxy();
		p.setHttpProxy("https://www.trivago.in/");
		DesiredCapabilities capabilities=new DesiredCapabilities().chrome();
		capabilities.setCapability(CapabilityType.PROXY, p);
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("start-maximized"); 
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); 

		WebDriver driver= new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.trivago.in/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement place = driver.findElement(By.id("querytext"));
		place.sendKeys("Bangalore");
		
		String xpath=".//span[@class='search-button__label']";
		
		String xpath2=".//span[contains(text(),'Bengaluru')]";
		List<WebElement> selectplace=driver.findElements(By.xpath(xpath2));
		int count=selectplace.size();
		selectplace.get(count-1).click();
		WebElement search=driver.findElement(By.xpath(xpath));
		search.click();
		String xpath3="//*[@id='js-splitview-map-container']/div/div[2]/button[2]/span[1]";
				WebElement close=driver.findElement(By.xpath(xpath3));
				close.click();
				WebElement selectitme=driver.findElement(By.id("mf-select-sortby"));
				Select select= new Select(selectitme);
				Thread.sleep(1000);
				select.selectByVisibleText("Rating only");
				String hot=".//span[@class='item-link name__copytext']";
				List<WebElement>hotels=driver.findElements(By.xpath(hot));
				int count1=hotels.size();
				System.out.println(count1);
				Thread.sleep(2000);
				try
				{
					for(int i=0;i<count;i++)
					{
						WebElement el=hotels.get(i);
							
						String text=el.getText();
						System.out.println(text+"    ");
					}
					}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				
				
				
	}
	





	


