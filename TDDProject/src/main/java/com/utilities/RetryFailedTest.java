package com.utilities;

	
	import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.testng.IRetryAnalyzer;
	import org.testng.ITestResult;
/**
 * This class for re-run the failed test for given # of times
 * Note: If the test run multiple times it shows the count in the report
 * @author PRIYANV
 *
 */
	 
	public class RetryFailedTest implements IRetryAnalyzer {
		public static Logger LOGGER = Logger.getLogger(RetryFailedTest.class);

	    private int count = 0;
	 
	    /**
	     * Method for re-run the failed test for given # of times specified in property file
	     * @author PRIYANV
	     * @param ITestReulst : to set the status as Success/Failure
	     * 
	     */
	    @Override
	    public boolean retry(ITestResult iTestResult) {
	    	BaseInitializerOriginal baseObject=new BaseInitializerOriginal();
	    	
	    	int maxTry=Integer.valueOf(baseObject.getProperty("reRunFailedTestCount"));
	        if (!iTestResult.isSuccess()) {    
	        	LOGGER.debug("Test Failed , Re-executing the the failed test");

	        	//Check if test not succeed
	            if (count < maxTry) {    
	            												 //Check if maxTry count is reached
	                count++;            						 //Increase the maxTry count by 1                        
	                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
	                return true;                                 //Tells TestNG to re-run the test
	            }
	        }
	        else {
	        	LOGGER.debug("Test Passed");
	            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
	        }
	        return false;
	    }

}
