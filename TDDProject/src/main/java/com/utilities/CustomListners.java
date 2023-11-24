
package com.utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.daimler.plaUM.testscripts.SampleTestScripts;

/**
 * @author GRANDIS
 * This CustomListners is used to perform certain action when tests starts,pass and fail etc...
 * 
 * This listener should add to the classes under package "TestScripts"
 *
 */

public class CustomListners extends BaseInitializerOriginal implements ITestListener {
	
	public static Logger LOGGER = Logger.getLogger(CustomListners.class);

	/**
	 * when test start execution below method get executed
	 * @author GRANDIS
	 * @param : result
	 *  
	 * */
	
	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info(result.getMethod().getMethodName() + " Execution is Started");
		extentTest = extentReport.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, result.getMethod().getMethodName() + " Execution Started ");
	}

	/**
	 * @author GRANDIS
	 * @param : result
	 * @category : when test execution completed without any exception below method get executed
	 * */
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
		try {
			logWithScreenshot(result.getMethod().getMethodName() + "TestDone");
			LOGGER.info(result.getMethod().getMethodName() + "Test Case execution Completed");
			extentTest.log(Status.PASS, "Test case Execution completed");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @author GRANDIS
	 * @param : result
	 * @category : when test execution failed with any exception below method get executed
	 * */
	@Override 
	public void onTestFailure(ITestResult result)
	{ 
	try
		{
		LOGGER.info(result.getMethod().getMethodName() + "Test Case Failed");
	  reportWithScreenshotOnFail(result.getMethod().getMethodName());
	  extentTest.log(Status.FAIL,result.getThrowable());
	  } 
	catch (IOException e)
	{
		e.printStackTrace(); 
		}
	}


	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { // TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		context.getAllTestMethods();

	}

	@Override public void onFinish(ITestContext context) 
	{
  
  }

}
