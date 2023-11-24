package com.customreport;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import com.utilities.BaseInitializerOriginal;



/**
 * The CustomReportListener Class is used for generating the customized  Test Report by using the  customreportTemplate.html File as the HTML template for the Report content.
 * This report contains the details of the total test, passed ,failed and skipped, total time taken for execution.
 * Note: This report does not gives the  Failed reason and screenshots (For detailed report Extent Reports can be reffered.) 
 * 
 *  This listener should be specify in all the Classes under "TestScripts" package
 *  @author PRIYANV
 *  
 */

public class CustomReportListener extends BaseInitializerOriginal implements IReporter {
	public static Logger LOGGER = Logger.getLogger(CustomReportListener.class);
	Integer iPassed = 0, iFailed = 0, iSkipped = 0, iTotal = 0;
	long totalSec = 0;
	String suiteName = "";
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String style = "font-size: 11px; padding-right: 5px; padding-left: 5px; height: 20px; border-bottom: 1px solid #eee;";
	String html = "";
	
	/**
	 * method for generate the customized test report
	 * @author PRIYANV
	 * @param 
	 */
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputemailIdDirectory) {
		LOGGER.info("Generating the Custom Report");
		for(ISuite suite: suites){
			suiteName = suite.getName();
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for(ISuiteResult sr: suiteResults.values()){
				ITestContext tc = sr.getTestContext();
				iPassed = tc.getPassedTests().getAllResults().size();
				iFailed = tc.getFailedTests().getAllResults().size();
				iSkipped = tc.getSkippedTests().getAllResults().size();
				iTotal = iPassed + iFailed + iSkipped;
				IResultMap failedTest = tc.getFailedTests();
				IResultMap passedTest = tc.getPassedTests();
				IResultMap skippedTest = tc.getSkippedTests();
				Set<ITestResult> failedRes = failedTest.getAllResults();
				for(ITestResult fr : failedRes){
					String testResName = fr.getName();
					LOGGER.debug("Test Res Name " + testResName);
					LOGGER.debug("Start Time " + sdfDate.format(new Date(fr.getStartMillis())));
					LOGGER.debug("End Time " + sdfDate.format(new Date(fr.getEndMillis())));
					LOGGER.debug("Elapsed time in seconds " + getElapsedTime(fr.getStartMillis(),fr.getEndMillis()));
					totalSec = totalSec + (fr.getEndMillis() - fr.getStartMillis());
					 html = html + "<tr>";
					 html = html + "<td style='" + style + "'>" + testResName + "</td>";
					 html = html + "<td style='color: #" + "D41743" + ";" + style + "'>" + "FAILED" + "</td>";
					 html = html + "<td style='" + style + "'>" + sdfDate.format(new Date(fr.getStartMillis())) + "</td>";
					 html = html + "<td style='" + style + "'>" + sdfDate.format(new Date(fr.getEndMillis())) + "</td>";
					 html = html + "<td style='" + style + "'>" + getElapsedTime(fr.getStartMillis(),
								fr.getEndMillis()) + "</td>";
					 html = html + "</tr>";
				}
				
				Set<ITestResult> passedRes = passedTest.getAllResults();
				for(ITestResult fr : passedRes){
					String testName = fr.getTestName();
					String testResName = fr.getName();
					LOGGER.debug("############################################################");
					LOGGER.debug("Test Res Name " + testResName);
					LOGGER.debug("Start Time " + sdfDate.format(new Date(fr.getStartMillis())));
					LOGGER.debug("End Time " + sdfDate.format(new Date(fr.getEndMillis())));
					LOGGER.debug("Elapsed time in seconds " + getElapsedTime(fr.getStartMillis(),fr.getEndMillis()));
					LOGGER.debug("############################################################");
					totalSec = totalSec + (fr.getEndMillis() - fr.getStartMillis());
					
					 html = html + "<td style='" + style + "'>" + testResName + "</td>";
					 html = html + "<td style='color: #" + "46D44B" + ";" + style + "'>" + "PASSED" + "</td>";
					 html = html + "<td style='" + style + "'>" + sdfDate.format(new Date(fr.getStartMillis())) + "</td>";
					 html = html + "<td style='" + style + "'>" + sdfDate.format(new Date(fr.getEndMillis())) + "</td>";
					 html = html + "<td style='" + style + "'>" + getElapsedTime(fr.getStartMillis(),fr.getEndMillis()) + "</td>";
					 html = html + "</tr>";
				}
				
				Set<ITestResult> skippedRes = skippedTest.getAllResults();
				for(ITestResult fr : skippedRes){
					String testName = fr.getTestName();
					String testResName = fr.getName();
					LOGGER.debug("############################################################");
					LOGGER.debug("Test Res Name " + testResName);
					LOGGER.debug("Start Time " + sdfDate.format(new Date(fr.getStartMillis())));
					LOGGER.debug("End Time " + sdfDate.format(new Date(fr.getEndMillis())));
					LOGGER.debug("Elapsed time in seconds " + getElapsedTime(fr.getStartMillis(),fr.getEndMillis()));
					LOGGER.debug("############################################################");
					totalSec = totalSec + (fr.getEndMillis() - fr.getStartMillis());
					html = html + "<td style='" + style + "'>" + testResName + "</td>";
					 html = html + "<td style='color: #" + "#0000FF" + ";" + style + "'>" + "SKIPPED" + "</td>";
					 html = html + "<td style='" + style + "'>" + sdfDate.format(new Date(fr.getStartMillis())) + "</td>";
					 html = html + "<td style='" + style + "'>" + sdfDate.format(new Date(fr.getEndMillis())) + "</td>";
					 html = html + "<td style='" + style + "'>" + getElapsedTime(fr.getStartMillis(),
								fr.getEndMillis()) + "</td>";
					 html = html + "</tr>";
				}
				
			}
		}
		try {
			createCustomReport();
			if(executionIn.contains("remote")) {
			sendReportAfterSuiteExecution(dynamicReportname("Yes"), sendEmailFrom,sendEmailTo);
			LOGGER.info("********* Custom Report Send as attachments******");
		}	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for calculating  the elapsedTime of execution
	 * @author PRIYANV
	 * @param startTimeMs 
	 * @param endTimeMs
	 * @return elapsedTime(H:M:S:s)
	 */
	public String getElapsedTime(long startTimeMs, long endTimeMs){
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = sdfDate.parse(sdfDate.format(new Date(startTimeMs)));
			endTime = sdfDate.parse(sdfDate.format(new Date(endTimeMs)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		long diffInMilli = Math.abs(endTime.getTime() - startTime.getTime());
		long sec = diffInMilli / 1000 % 60;
		long mins = diffInMilli / (60 * 1000) % 60;
		long hrs = diffInMilli / (60 * 60 * 1000);
		return hrs + "h " + mins + "m " + sec +"s";
	}
	
	/**
	 	* Method for creating the customized Test Report html
	 	* @author PRIYANV
		* @throws UnknownHostException
	 */
	public void createCustomReport() throws UnknownHostException{
		long sec = totalSec / 1000 % 60;
		long mins = totalSec / (60 * 1000) % 60;
		long hrs = totalSec / (60 * 60 * 1000);
		File  htmlTemplateFile = new File(System.getProperty("user.dir") + "//custom_report//CustomReportTemplate.html");
		String htmlString = "";
		try {
			htmlString = FileUtils.readFileToString(htmlTemplateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		htmlString = htmlString.replace("$os_version", System.getProperty("os.version"));
		htmlString = htmlString.replace("$os_arch", System.getProperty("os.arch"));
		htmlString = htmlString.replace("$hostName", InetAddress.getLocalHost().getHostName());
		htmlString = htmlString.replace("$browser", BaseInitializerOriginal.Browser);
		htmlString = htmlString.replace("$execution_env",BaseInitializerOriginal.Environment.toUpperCase());
		htmlString = htmlString.replace("$duration", hrs + "h " + mins + "m " + sec +"s");
		htmlString = htmlString.replace("$testSuiteName", suiteName);
		htmlString = htmlString.replace("$iPassed", iPassed.toString());
		htmlString = htmlString.replace("$iFailed", iFailed.toString());
		htmlString = htmlString.replace("$iSkipped", iSkipped.toString());
		htmlString = htmlString.replace("$iTotal", iTotal.toString());
		htmlString = htmlString.replace("$html ", html);
		File newHtmlFile = new File(dynamicReportname("Yes"));
		try {
			FileUtils.writeStringToFile(newHtmlFile, htmlString);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	


}
