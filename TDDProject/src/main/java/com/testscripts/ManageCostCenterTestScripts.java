package com.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.utilities.BusinessUtilities;
import com.utilities.PageActions;


/**
 * @author ROSMOLS
 *
 */
@Listeners({ com.utilities.TestAnnotationTransformerListener.class,
		com.customreport.CustomReportListener.class, com.utilities.CustomListners.class })
public class ManageCostCenterTestScripts extends BusinessUtilities {
	/**
	 * @author ROSHNI
	 */
	public static Logger LOGGER = Logger.getLogger(ManageCostCenterTestScripts.class);
	BusinessUtilities businessUtilities = new BusinessUtilities();
	PageActions pageActions = new PageActions();
	
	
	@Test(groups = "SmokeTest") // ,invocationCount=5)
	public void TestCase001_ValidateDashboardPage() throws Exception {
		LOGGER.info(new Exception().getStackTrace()[0].getMethodName() + " Execution Started");
		String testcasename="TestCase001_ValidateDashboardPage";
		String sheetName="ManageCostcenter_EN";
		extentTest.log(Status.INFO, "Navigate Successfully");
		excelValidations.setCostCenterValues(testcasename,sheetName);
		String ccToBeDeleted = excelValidations.getCostCenter().toUpperCase();
//		waitUntilLoadingSymbolAppearsPolling(pfHomePage.getManageCostcentersBtn(), 1, 120);
//		manageCostCenterScreen.clickOnManageCostCenterButton();
//		waitUntilLoadingSymbolAppearsPolling(manageCostCenterScreen.getMngCostcentersFrstRowFrstColumn(), 1, 120);
		
		
	}
}