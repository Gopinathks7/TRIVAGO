package com.common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.generic.Utility;

public class CustomListener  implements ITestListener
{
	
	public void onTestFailure(ITestResult result) {
		String folder=AutomationConstants.SNAP_PATH;
		Utility.getDesktopScreenshot(folder);
	}
	
	
	public void onTestStart(ITestResult result) {
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
