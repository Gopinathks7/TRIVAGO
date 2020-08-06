package com.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class Property 
{

	
	public static String getPropertyValue(String strFilePath,String strKey)
	{
		String value="";
		Properties ppt=new Properties();
		try{
			ppt.load(new FileInputStream(strFilePath));
			value=ppt.getProperty(strKey);
		}
		catch(Exception e){}
		return value;
}
	
}
