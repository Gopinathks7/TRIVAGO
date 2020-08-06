package com.scripts;

import org.testng.annotations.Test;

import com.common.BaseTest;
import com.generic.Excel;
import com.pages.BookingPage;

public class BookTest extends BaseTest
{

	@Test
	public void getBooking()
	{
		String place=Excel.getCellValue(INPUT_PATH, "Sheet1", 1, 0);
		String select=Excel.getCellValue(INPUT_PATH, "Sheet2", 1, 0);
		BookingPage p=new BookingPage(driver);
		p.setPlaceToSearc(place);
		p.selectByRatings(select);
		p.getListOfHotels();
		p.selectingAccomdation();
		p.closeBrowser();
		
	}
}
