package com.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Excel 
{
	
	public static int getRowCount(String strPath,String strSheet)
	{
		int row=0;
		try{
			
			row=WorkbookFactory.create(new FileInputStream(strPath)).getSheet(strSheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return row;
	}
	
	public static String getCellValue(String strPath,String strSheet,int r,int c)
	{
		String value="";
		try{
			
			value=WorkbookFactory.create(new FileInputStream(strPath)).getSheet(strSheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;

}
}
