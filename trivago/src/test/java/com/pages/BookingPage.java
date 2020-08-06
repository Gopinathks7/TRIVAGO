package com.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.BasePage;

public class BookingPage extends BasePage
{
WebDriver driver;
	public BookingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
@FindBy(id="querytext")
private WebElement searchItem;

@FindBy(xpath=".//span[@class='search-button__label']")
private WebElement clicksearch;

@FindBy(xpath="//*[@id='suggestion-64975/200']/div/span[2]")
private WebElement selectplace;


@FindBy(xpath=".//span[@class='search-button__label']")
private WebElement searchbutton;

@FindBy(xpath="//*[@id='js-splitview-map-container']/div/div[2]/button[2]/span[1]")
private WebElement closebutton;

@FindBy(id="mf-select-sortby")
private WebElement selectItem;

@FindBy(xpath=".//span[@class='item-link name__copytext']")
private List<WebElement> hotelList;


@FindBy(xpath=" //*[@id='4600452']/div/article/div[1]/div[2]/section/div[1]/article/div/div[2]/button/span/span[1]")
private WebElement dealButton;

@FindBy(xpath="//*[@id='contentContainer']/div[4]/ol/li[1]/div[2]/a/div/div[2]/div[1]/aside/ul/li/div/span")
private WebElement clickbook;
public void setPlaceToSearc(String place)
{
	try
	{
		searchItem.sendKeys(place);
		Thread.sleep(2000);
		selectplace.click();
		Thread.sleep(1000);
		searchbutton.click();
		closebutton.click();
		
			
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
	public void selectByRatings(String ratings)
	{
		try
		{
			getSelectByVisibleText(selectItem,ratings);
			Thread.sleep(1000);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getListOfHotels() {
		
		try
		{
			
			getCount(hotelList);
//			int count=hotelList.size();
//			System.out.println(count);
//			for(int i=0;i<count;i++)
//			{
//				WebElement el=hotelList.get(i);
//				Thread.sleep(2000);
//				String text=el.getText();
//				
//				
//				
//			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
			public void selectingAccomdation()
			{
				try
				{
			dealButton.click();
			switchBrowser();
			Thread.sleep(1000);
			clickbook.click();
			Thread.sleep(2000);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
		
			
		}
			
			public void closeBrowser()
			{
				try
				{
					closeBrowserOpened();
				}
			
				catch (Exception e) {
					e.printStackTrace();
				}
		}
}

