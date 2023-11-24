package com.utilities;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.RunConfig.DynamicTestNG;
import com.aventstack.extentreports.ExtentTest;

/**
 * It used for set the flag to skip the test based on configuration in Excel file
 * Ex: It is like to skip the test in TestNG we will give @Test(enabled=false)
 * This listener should add to the classes under package "TestScripts"
 * @author PRIYANV
 * 
 *
 */

public class TestAnnotationTransformerListener  implements IAnnotationTransformer{
	public static Logger LOGGER = Logger.getLogger(TestAnnotationTransformerListener.class);
	List<String> arraylsits = new ArrayList();
	private static ExcelActions excelRW;
	String TestCasename;
	
	
	/**
	 * Method to set the enable attribute of all tests to TRUE/FALSE 
	 * TRUE means --> Test get executed
	 * FALSE means --> Test get skipped
	 * @author PRIYANV
	 * 
	 */
	@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {   
    	LOGGER.debug("Transforming the test based on configuratin in Excel  " );

		String currentPath=System.getProperty("user.dir"); 
		String excelPath=currentPath+"/lib/ConfuigurationFile.xlsx";
//		String suiteName=System.getenv("SuiteName");
		String suiteName = DynamicTestNG.getRunParamProperty("suiteName");
		String sheetName="";
		  try {
			  excelRW=new ExcelActions(excelPath);
		  } 
		  catch (IOException e) {
		  e.printStackTrace();
		  LOGGER.error("Excel Actaion object intialization Failed");
		  }
		  if(suiteName.equalsIgnoreCase("SmokeTest")) {
			  sheetName="SmokeTest";
		  }
		  else {
			  sheetName="RegressionTest"; 
		  }
		  
		  
		 int row=excelRW.getRow(sheetName); 
		 for(int i=0;i<=row;i++)
		  { 
			  String ExecFlag=excelRW.readCell(sheetName,i,2); 
			  if(ExecFlag.equalsIgnoreCase("No"))  { 
					TestCasename = excelRW.readCell(sheetName, i,1); 
					arraylsits.add(TestCasename); 
			  }
		  
		  }
		 if(arraylsits.contains(testMethod.getName())) {
        	LOGGER.info(testMethod.getName() + " Skipped Test " );
            annotation.setEnabled(false);
        } 
		annotation.setRetryAnalyzer(RetryFailedTest.class);
    }

	
		
		
	}


	
	

