package com.RunConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.utilities.TestAnnotationTransformerListener;



/**
 * This for create testNG.xml at run time, developed to make the "GroupTest" as
 * run configuration Run configuration parameters passed from this class
 * 
 * @author PRIYANV
 * 
 */
public class DynamicTestNG {
	public static Logger LOGGER = Logger.getLogger(DynamicTestNG.class);
	static Properties Prop = null;
	static FileInputStream io = null;

	@SuppressWarnings("deprecation")
	public void runTestNGTest(Map<String, String> testngParams) {
         ArrayList<String> testcaseName= new ArrayList<String>(); //rosmols
		// Create an instance on TestNG
		TestNG myTestNG = new TestNG();

		// Create a	n instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("Suite");

		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("mytest");

		XmlGroups myGroups = new XmlGroups();

		// Add any parameters that you want to set to the Test.
		myTest.setParameters(testngParams);

		// To Run the Test scripts package

//		 String packages = "com.daimler.plaUM.testscripts"; 
//		 XmlPackage xmlPackage = new XmlPackage(packages);
//		 myTest.setXmlPackages(Collections.singletonList(xmlPackage));
	 

	// Create a list which can contain the classes that you want to run.
	     List<XmlClass> myClasses = new ArrayList<XmlClass>(); //MapRolesTestScripts.java (2 matches)
//		 myClasses.add(new XmlClass("com.daimler.plaUM.testscripts.ManageCostCenterTestScripts"));
//	     myClasses.add(new XmlClass("com.daimler.plaUM.testscripts.ManageDataBaseTestScripts"));
//		 myClasses.add(new XmlClass("com.daimler.plaUM.testscripts.MapRolesTestScripts"));
//	     myClasses.add(new XmlClass("com.daimler.plaUM.testscripts.ManageUsersTestScripts"));
	     
//	     myClasses.add(new XmlClass("com.daimler.plaUM.testscripts.DataBaseCostCenterMappingTestScripts"));
//	     myClasses.add(new XmlClass("com.daimler.plaUM.testscripts.ManageDataBaseTestScriptsSample"));
	     myClasses.add(new XmlClass("com.daimler.plaUM.testscripts.UMPLAWebIntegratedTestScripts"));
		// Assign that to the XmlTest Object created earlier.
		myTest.setXmlClasses(myClasses);

		// Create a list of XmlTests and add the Xmltest you created earlier to it.
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);

		// add the list of tests to your Suite.544r
		mySuite.setTests(myTests);

		// Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);
		System.out.println(testngParams.get("suiteName"));
		if (testngParams.get("suiteName").equalsIgnoreCase("SmokeTest")) {
			mySuite.addIncludedGroup("SmokeTest");
		} else if (testngParams.get("suiteName").equalsIgnoreCase("RegressionTest")) {
			mySuite.addIncludedGroup("RegressionTest");

		} 
		else if (testngParams.get("suiteName").equalsIgnoreCase("RequestAccessTC")) {
			mySuite.addIncludedGroup("RequestAccessTC");

		} 
		
		else {
			mySuite.addIncludedGroup("SmokeTest");
			mySuite.addIncludedGroup("RegressionTest");
		}
		// Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);
		TestListenerAdapter tla = new TestListenerAdapter();

		myTestNG.addListener(tla);
		myTestNG.addListener(new TestAnnotationTransformerListener());
//		myTestNG.setAnnotationTransformer(new TestAnnotationTransformerListener());

		myTestNG.run();
	}

	public static void main(String args[]) {
		LOGGER.info("Read Run Configuration parameters");
     //  BasicConfigurator.configure();
		DynamicTestNG dt = new DynamicTestNG();
		// This Map can hold your testNg Parameters.
		Map<String, String> testngParams = new HashMap<String, String>();
/*		String browser = System.getenv("Browser");
		String environment = System.getenv("Environment");
		String executingIn = System.getenv("ExecutingIn");
		String language = System.getenv("Language");
		String emailTo = System.getenv("emailTo");
		String screenshot = System.getenv("ScreenShot");
		String suiteName = System.getenv("SuiteName");
		String emailFrom = System.getenv("emailFrom"); */
//String browser =System.getProperty("browser")!=null ? System.getProperty("browser") : getRunParamProperty("browser") ;
		String browser = getRunParamProperty("browser");
		System.out.println(browser);
		String environment= getRunParamProperty("environment");
		String executingIn = getRunParamProperty("executingIn");
		String language = getRunParamProperty("language");
		String emailTo = getRunParamProperty("emailTo");
		String screenshot = getRunParamProperty("screenshot");
		String suiteName = getRunParamProperty("suiteName");
		String emailFrom = getRunParamProperty("emailFrom");
		testngParams.put("environment", environment);
		testngParams.put("executingIn", executingIn);
		testngParams.put("emailFrom", emailFrom);
		testngParams.put("emailTo", emailTo);
		testngParams.put("browser", browser);
		testngParams.put("language", language);
		testngParams.put("screenshot", screenshot);
		testngParams.put("suiteName", suiteName);
		LOGGER.info("Run Configuration parameters added To dyamicTestNG");
		dt.runTestNGTest(testngParams);
		

	}
	public static void init() {
		try {
		String ORpath = "RunConfigParameters.properties";
//			String ORpath = "C:/Users/rosmols/Documents/GitHub/UserManagementAutomationTesting/src/main/resources/RunConfigParameters.properties";
			io = new FileInputStream(ORpath);
			Prop = new Properties();
			Prop.load(io);
		} catch (FileNotFoundException e) {
			e.toString();
		} catch (Exception es) {
			LOGGER.error(es.getMessage());
		}

	}

	
	public static String getRunParamProperty(String propertName) {
		init();
		return Prop.getProperty(propertName);
	}

}
