package com.utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.google.common.collect.Comparators;

public class BusinessUtilities extends PageActions {
	public static Logger LOGGER = Logger.getLogger(BusinessUtilities.class);

	/**
	 * Method for click on Bar graph sector/Pie Sector
	 * 
	 * @param ElementToClick
	 * @throws InterruptedException
	 * @throws IOException
	 * @author PRAMKUL
	 */
	public void graphClick(WebElement ElementToClick) throws InterruptedException, IOException {
		Actions Action = new Actions(driver);
		try {
			ElementToClick.isDisplayed();
			Action.moveToElement(ElementToClick).build().perform();
			LOGGER.debug(" Cursor focussed on the graph sector");
			pageActions.normalwait();
			ElementToClick.click();
			pageActions.normalwait();
		} catch (Exception e) {
			extentTest.log(Status.FAIL, e.getMessage());
		}

	}

	/**
	 * Method for get the column Index of provided column
	 * 
	 * @author PRAMKUL
	 * @param columnName
	 * @return
	 */
	public int getColumnIndex(String columnName) {
		int Column_index = 0;
		List<WebElement> list_columns = pfHomePage.getallScreens_Tbl1_ColumnHeader();
		for (int i = 0; i < list_columns.size(); i++) {
			String GetName = list_columns.get(i).getText();
			if (columnName.trim().equalsIgnoreCase(GetName.trim())) {
				Column_index = i;
				break;
			}
		}
		Column_index = Column_index + 1;
		return Column_index;
	}

	/**
	 * Method for read column data of Current page in web-table
	 * 
	 * @author PRAMKUL
	 * @param ColumnName
	 * @return
	 */
	public String[] readColumnDataOfCurrentPageInTable(String ColumnName) {

		int index = getColumnIndex(ColumnName);
		int total_rows = pfHomePage.getTable_NoOfrows().size();
		String[] Rows_data = new String[total_rows];
		String getColumnObject = pfOverviewPage.getTbl1_Txt_SpecificColumnData();
		pageActions.normalwait();
		List<WebElement> AllColumnData = identifyDynamicElementsList(getColumnObject, Integer.toString(index));
		pageActions.normalwait();
		for (int i = 0; i < AllColumnData.size(); i++) {
			String rowData = AllColumnData.get(i).getText();
			if (rowData.isEmpty()) {
				continue;
			} else {
				Rows_data[i] = rowData;
			}
		}
		return Rows_data;
	}

	/**
	 * Method for read column data in web table, it will read all pages data
	 * using pagination
	 * 
	 * @author PRAMKUL
	 * @param ColumnName
	 * @return
	 * @throws Exception
	 */
	public List<String> readEntireColumnDataInTable(String ColumnName) throws Exception {

		int index = getColumnIndex(ColumnName);
		int count = 1;
		int totalPages = Integer.parseInt(pfHomePage.getallScreensTbl1_Txt_PageCount().getText());
		List<String> entireColData = new ArrayList<String>();
		String getColumnObject = pfOverviewPage.getTbl1_Txt_SpecificColumnData();
		pageActions.normalwait();
		for (int i = 1; i <= totalPages; i++) {

			List<WebElement> CurrentPageColData = identifyDynamicElementsList(getColumnObject, String.valueOf(index));// driver.findElements(By.xpath(getColumnObject));
			String[] arr = convertWebListToStringArr(CurrentPageColData);
			entireColData.addAll(convertWebListToStringList(CurrentPageColData));
			clickNextButtonInTable();
		}
		pfOverviewPage.getOverviewTbl1_Txt_CurrentPageNumber().clear();
		pfOverviewPage.getOverviewTbl1_Txt_CurrentPageNumber().sendKeys("1");
		return entireColData;
	}

	/**
	 * Method for get the total no.of records in table
	 * 
	 * @author GRANDIS
	 * 
	 * @param ColumnName
	 * @return
	 */
	public int getTotalNoOfRecordsinTable(String ColumnName) {
		int index = getColumnIndex(ColumnName);
		int totalRows = pfHomePage.getTable_NoOfrows().size();
		int totalPages = Integer.parseInt(pfHomePage.getallScreensTbl1_Txt_PageCount().getText());
		int count = 0;
		String getColumnObject = pfOverviewPage.getTbl1_Txt_SpecificColumnData();
		for (int i = 1; i <= totalPages; i++) {
			List<WebElement> AllColumnData = identifyDynamicElementsList(getColumnObject, String.valueOf(index));
			count = count + AllColumnData.size();
		}
		return count;

	}

	/**
	 * Method for identify dynamic Element, i.e useful for parameterized xpath,
	 * parameter will be replaced with subsitute value
	 * 
	 * @author GRANDIS
	 * @param ObjectIdentificationValue
	 * @param substitutionValue
	 * @return WebElement
	 */
	public WebElement identifyDynamicElements(String ObjectIdentificationValue, String substitutionValue) {
		return driver.findElement(By.xpath(ObjectIdentificationValue.replace("parameter", substitutionValue.trim())));
	}

	/**
	 * Method for identify dynamic list of Elements , i.e useful for
	 * parameterized xpath, parameter will be replaced with subsitute value
	 * 
	 * @author GRANDIS
	 * @param ObjectIdentificationValue
	 * @param substitutionValue
	 * @return WebElement
	 */

	public List<WebElement> identifyDynamicElementsList(String ObjectIdentificationValue, String substitutionValue) {

		return driver.findElements(By.xpath(ObjectIdentificationValue.replace("parameter", substitutionValue.trim())));
	}

	/**
	 * @author GRANDIS Method for enter the data into specific text field in
	 *         table
	 * @param ObjectToIdentify
	 * @param ColIndex
	 * @param EnterValue
	 */
	public void enterDataInSpecificColumn(String ObjectToIdentify, int ColIndex, String EnterValue) {
		try {
			WebElement freeTextfiled = identifyDynamicElements(ObjectToIdentify, String.valueOf(ColIndex));
			freeTextfiled.sendKeys(EnterValue);
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed due to " + e.toString());
		}
	}

	/**
	 * @author GRANDIS Method for read row1 data in specific column
	 * @param ObjectToIdentify
	 * @param ColIndex
	 * @return
	 */
	public String read1stRowDataInSpecificColumn(String ObjectToIdentify, int ColIndex) {
		String rowOneData = null;
		try {
			WebElement rowOneElement = identifyDynamicElements(ObjectToIdentify, String.valueOf(ColIndex));
			rowOneData = rowOneElement.getText();
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed due to " + e.toString());
		}
		return rowOneData;
	}

	/**
	 * Method for select value in specified dropdown in the table
	 * 
	 * @author PRIYANV
	 * @param columnName
	 * @param SelectValue
	 * @throws InterruptedException
	 */

	public void selectValueInSpecificColumn(String columnName, String SelectValue) throws InterruptedException {

		int colIndex = getIndexofColumnfilterInTbl1(columnName, "Dpdw");
		try {
			clickOnElement(identifyDynamicElements(pfHomePage.getAllScreen_Dpdwn_MultiselectIcon(),
					Integer.toString(colIndex)));

			if (pfHomePage.getAlllScreen_Dpdwn_ShowAlloption().isSelected()) {
				LOGGER.debug("ShowAll Option is already selected");
			} else {
				pageActions.clickOnElement(pfHomePage.getAlllScreen_Dpdwn_ShowAlloption());
			}

			// verifyIsScrollBarPresent();
			clickOnElement(identifyDynamicElements(pfHomePage.getAllScreen_Dpdwn_SelectFilter(), SelectValue));
			clickOnElement(identifyDynamicElements(pfHomePage.getAllScreen_Dpdwn_MultiselectIcon(),
					Integer.toString(colIndex)));
			normalwait();

		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed due to " + e.toString());
		}

	}

	/**
	 * Method for navigate to last page in Table using "Pagination"
	 * 
	 * @author GRANDIS
	 * @return
	 * @throws Exception
	 */

	public boolean navigateToLastpageOfTable() throws Exception {
		boolean flag = false;
		WebElement Table_next = pfHomePage.getallScreensTbl1_Btn_Next();
		int NoOfPages = Integer.parseInt(pfHomePage.getallScreensTbl1_Txt_PageCount().getText());
		ArrayList<String[]> List = new ArrayList<String[]>();
		extentTest.log(Status.PASS, "Start Reading the column data row by row");
		for (int i = 0; i < NoOfPages; i++) {
			if (Table_next.isEnabled()) {
				pageActions.clickOnElement(Table_next);
			} else {
				LOGGER.debug("Navigated till the Last page (or) Next Button is disabled in the Tabular View");
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Method for
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean clickNextButtonInTable() throws Exception {
		boolean flag = false;
		WebElement tableNext = pfHomePage.getallScreensTbl1_Btn_Next();
		if (tableNext.isEnabled()) {
			pageActions.clickOnElement(tableNext);
		} else {
			LOGGER.debug("Navigated till the Last page (or) Next Button is disabled in the Tabular View");
			flag = true;
		}
		return flag;
	}

	/**
	 * Method for show the column in the WebTable
	 * 
	 * @author PRIYANV
	 * @param columnName
	 * @throws Exception
	 */
	public void showColumn(String columnName) throws Exception {
		try {
			if (pfOverviewPage.getOverviewTbl1_Icns_ShowHide().size() == 2) {
				clickOnElement(
						identifyDynamicElements(pfOverviewPage.getOverviewTbl1_Icn_ShowHide(), String.valueOf(2)));
			} else {
				clickOnElement(
						identifyDynamicElements(pfOverviewPage.getOverviewTbl1_Icn_ShowHide(), String.valueOf(1)));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		List<String> columnList = convertWebListToStringList(
				pfOverviewPage.getOverview_options_CoulumnSelectionItems());
		if (!(columnList.contains(columnName))) {
			extentTest.log(Status.FAIL, "The provided column does not exist for the selection");
		}
		WebElement showHideSpecificColumn = identifyDynamicElements(pfOverviewPage.getTbl1_Chbox_SpecifiCheckbox(),
				columnName);
		WebElement checkboxValidation = identifyDynamicElements(pfOverviewPage.getTbl1_Chbox_validation(), columnName);
		String getClassName = checkboxValidation.getAttribute("className");

		if (getClassName.contains("selected") && columnVisibleStatus(columnName)) {
			LOGGER.debug("Given column already selected and visible in table Grid");
			LOGGER.debug("Column already shown");
		} else {
			showHideSpecificColumn.click();
			LOGGER.debug("shown");
		}

	}

	/**
	 * Method for Show/hide the column in Table
	 * 
	 * @author GRANDIS
	 * @param columnName
	 *            : provide the column to show/hide
	 * @param isShown
	 *            :" If you want to show provide "isShown" as True else False
	 * @throws Exception
	 */
	public void showHideColumn(String columnName, boolean isShown) throws Exception {
		try {
			clickUsingJscript(pfOverviewPage.getOverviewTbl1_Icn_ShowHideOld());
		} catch (Exception e) {
			WebElement ele = driver
					.findElement(By.xpath("(//*[name()='i'][contains(@class,'Widget_settingsIcon')])[1]"));
			clickUsingJscript(ele);
		}

		WebElement showHideSpecificColumn = identifyDynamicElements(pfOverviewPage.getTbl1_Chbox_SpecifiCheckbox(),
				columnName);
		WebElement checkboxValidation = identifyDynamicElements(pfOverviewPage.getTbl1_Chbox_validation(), columnName);
		String getClassName = checkboxValidation.getAttribute("className");
		if (isShown == true) {
			if (getClassName.contains("selected") && columnVisibleStatus(columnName)) {
				LOGGER.debug("Given column already selected and visible in table Grid");
			} else {
				showHideSpecificColumn.click();
				LOGGER.debug("Column shown");
			}
		} else if (isShown == false)// &&
		{
			if (getClassName.contains("selected")) {
				showHideSpecificColumn.click();
				normalwait();
				normalwait();
				normalwait();
				LOGGER.debug("Column is hidden");
			} else if (columnVisibleStatus(columnName) == false) {
				LOGGER.debug("Given column already Hidden and not visible in table Grid");
			}
		}
	}

	/**
	 * Method for get the column visible status in table
	 * 
	 * @author GRANDIS
	 * 
	 * @return true on column visible else False
	 */
	public boolean columnVisibleStatus(String columnName) {
		boolean flag = false;
		List<WebElement> getAllcolumnList = pfOverviewPage.getAllScreen_Tbl1_ColumnHeaders();// driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
		String[] allColumnNames = convertWebListToStringArr(getAllcolumnList);
		boolean flag1 = validateStringArray(columnName, allColumnNames);
		if (flag1 == true) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	/***
	 * This is method for get index of Filter i.e FreeText/Dropdown for given
	 * colu Map(columnName, index) we can use to get the
	 * 
	 * @author GRANDIS
	 * @return Index of filter
	 * @throws InterruptedException
	 */

	public int getIndexofColumnfilterInTbl1(String columnName, String filterTypeTxtDpdw) throws InterruptedException {
		HashMap<String, Integer> colNameIndex = new HashMap<String, Integer>();
		List<String> list_columnNames = convertWebListToStringList(pfOverviewPage.getAllScreen_Tbl1_ColumnHeaders());
		int colNameIndexinList = 0;
		int inputIndex = 1;
		int dpdwIndex = 1;
		for (int i = 0; i < list_columnNames.size(); i++) {
			String filter = identifyDynamicElements(pfOverviewPage.getfilterTypeTag_tag_OverviewTbl1(),
					String.valueOf(i + 1)).getTagName();
			if (filter.contains("input")) {
				colNameIndex.put(list_columnNames.get(colNameIndexinList), inputIndex);
				inputIndex++;
				colNameIndexinList++;
			} else if (filter.contains("div")) {
				colNameIndex.put(list_columnNames.get(colNameIndexinList), dpdwIndex);
				dpdwIndex++;
				colNameIndexinList++;
			}

		}
		return colNameIndex.get(columnName);
	}

	/**
	 * Method to check given data available in specified column
	 * 
	 * @param stringTOvalidate
	 * @param ColumnName
	 * @return
	 * @throws Exception
	 */
	public boolean validateDataInColumn(String stringTOvalidate, String ColumnName) throws Exception {
		boolean flag = true;
		List<String> colData = readEntireColumnDataInTable(ColumnName);
		for (int i = 0; i < colData.size(); i++) {
			if (colData.get(i).contains(stringTOvalidate)) {
				continue;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * Method for Reverse the given string.
	 * 
	 * @author Priyavkanv
	 * @param text
	 * @return
	 */
	public String reverseString(String text) {
		String[] words = text.split(" ");

		String rev = "";
		for (int i = words.length - 1; i >= 0; i--) {
			rev += words[i] + " ";
		}

		StringBuilder revb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			revb.append(words[i]);
			revb.append(" ");
		}
		return rev;
	}

	/***
	 * Method for click on link in the page/web-table, which work for tag
	 * Span/anchor
	 * 
	 * @author GRANDIS
	 * 
	 * 
	 * @throws Exception
	 */
	public void clickOnHyperLink(String linkTextToClick) throws Exception {
		WebElement hyperLinkToBeClick = identifyDynamicElements(pfOverviewPage.getoverview_link_AnySpecificHyperlink(),
				linkTextToClick);
		waitUntilLoadElement(hyperLinkToBeClick, 1, 60);
		clickOnElement(hyperLinkToBeClick);

	}

	/***
	 * 
	 * This method will validate the text present in the Current URL
	 * 
	 * @author GRANDIS
	 * @throws IOException
	 * @throws Exception
	 */
	public boolean validateURL(String text) throws IOException {
		String url = driver.getCurrentUrl();
		if (url.contains(text)) {
			extentTest.log(Status.INFO, "New Window URL contains given Text ");
			logWithScreenshot("ApplicationOpenedSuccessfully");
			return true;
		} else {
			extentTest.log(Status.FAIL, "New window URL doesnot contains given text");
			return false;
		}
	}

	/**
	 * Method for compare the given 2 Sting list, if not matched it will fail
	 * Test
	 * 
	 * @author GRANDIS
	 * @param expectedList:
	 *            provided String list 1 to compare with list2
	 * @param actualList
	 *            : it will compare wiht list 1
	 * @param provideMsgifFails
	 *            : if compare failed it will print the Given Message in
	 *            console/report
	 * @return: if both matched return true else False
	 */
	public boolean compareStringList(List<String> expectedList, List<String> actualList, String provideMsgifFails) {
		expectedList.sort(null);
		actualList.sort(null);
		if (expectedList.equals(actualList) && expectedList.size() == actualList.size()) {
			Assert.assertEquals(expectedList, actualList, provideMsgifFails);
			return true;
		} else {
			extentTest.log(Status.FAIL, provideMsgifFails);
			return false;
		}
	}

	/**
	 * Method for clear the entered text in text field inside Table
	 * 
	 * @author GRANDIS
	 * @param columnName:
	 *            provide the column to clear the entered data
	 * 
	 */
	public void clearEnteredDataInTbl_SpecificColumn(String columnName) {
		try {
			int colIndex = getIndexofColumnfilterInTbl1(columnName, "Txt");
			// getColumnIndex(columnName);
			WebElement freeTextfiled = identifyDynamicElements(pfOverviewPage.getTbl1_TBox_InputColumn(),
					String.valueOf(colIndex));
			clear(freeTextfiled);
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed due to " + e.toString());
		}
	}

	/**
	 * Method to check given string is Integer value or not
	 * 
	 * @param s
	 * @return
	 */
	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	/**
	 * method for parameterized objects Ex: In a Table row 1, column 1
	 * WebElement, have to pass 2 parameters either Index/value
	 * 
	 * @param ObjectIdentificationValue
	 * @param substitutionValue1
	 * @param substitueValue2
	 * @return
	 */

	public WebElement identifyDynamicElementWith2params(String ObjectIdentificationValue, String substitutionValue1,
			String substitueValue2) {
		return driver.findElement(By.xpath(ObjectIdentificationValue.replace("parameter1", substitutionValue1.trim())
				.replace("parameter2", substitueValue2)));
	}

	/**
	 * @author PRAMKUL
	 * @param Locator
	 * @return
	 */
	public List<WebElement> getListOfElement(By Locator) {
		List<WebElement> ValueInColumn = null;
		try {

			Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);
			ValueInColumn = waitForElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ValueInColumn;

	}

	/**
	 * @author PRAMKUL
	 * @param Locator
	 * @return
	 */
	public List<String> convertListWebElementsIntoListOfString(List<WebElement> ListOfElements) {
		return ListOfElements.stream().peek(a1->System.out.println(a1)).filter(x -> !x.equals("")).map(WebElement::getText)
				.peek(a->System.out.println(a)).collect(Collectors.toList());
	}

	public List<WebElement> validateDataTable(String ColumnName, By TableHeaderLocator, String TableContentLocator) {
		List<WebElement> ListOfElementsFromColumn = null;
		try {
			// With String(Column Name) as primary position of header in table
			// is identified
			int PositionOfColumn = getColumnFromHeader(ColumnName, TableHeaderLocator);
			// Double check on header
			if (PositionOfColumn != -1) {
				By SearchResult_TableContent = By
						.xpath(TableContentLocator.replace("index", String.valueOf(PositionOfColumn)));
				ListOfElementsFromColumn = getListOfElement(SearchResult_TableContent);
			} else {
				extentTest.log(Status.FAIL, "Table header identification failed");

			}
		} catch (Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Table header identification failed");
		}
		return ListOfElementsFromColumn;
	}

	/**
	 * @author PRAMKUL
	 * @param Locator
	 * @return
	 */
	public HashMap<String, List<String>> validateSearchResult(String TableHeaderLocater, String TableContentLocator,
			By PageHeader) {
		List<WebElement> ListOfElementsFromColumn = null;
		HashMap<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		// Counter created to decide on value of td based on table header
		// identified
		// Value set is 2, since first column is always checkbox
		AtomicInteger ElementCounter = new AtomicInteger(1);
		try {
			// logger.info(Thread.currentThread().getStackTrace()[1].getMethodName()
			// + " is executed ");
			// Locator fetched to validate the header of page. Landing of page
			// verification
			// By SearchHeader =
			// Action_Instance.getLocator(ReadProperty.getInstance().getProperty("SearchResult_Header"));
			// Converting string locator(Header of table) passed into by
			By HeaderOfTable = By.xpath(TableHeaderLocater);

			// WaitForPage to load until header is displayed
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PageHeader));

			// With String(Column Name) as primary position of header in table
			// is identified
			List<WebElement> TableHeaders = getListOfElement(HeaderOfTable);
			// logger.info("Total no of headers present in table
			// "+TableHeaders.size());
			// Double check on header
			if (TableHeaders.size() > 0) {
				// With column unidentified and int returned is -1, this block
				// wil not get executed
				// logger.info("Table header identification successful ");
				// With position of Column identified, td value of table content
				// locator is updated. Table content passed as a string is
				// converted to by

				TableHeaders.stream().forEach(e -> {
					By SearchResult_TableContent = By.xpath(
							TableContentLocator.replace("body", String.valueOf(ElementCounter.getAndIncrement())));
					// logger.info("Locator value for Search result table
					// content locator updated " +SearchResult_TableContent );
					if (e.getText().length() != 0) {
						map.put(e.getText(), convertListWebElementsIntoListOfString(getListOfElement(SearchResult_TableContent)));
					}

				});

			} else {
				extentTest.log(Status.FAIL, "Table header identification failed");

			}
			// fetch the values from header
			// This size validation block do not mean anything. Can be replaced
			// or enhanced with logic inside true block

		} catch (Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Table header identification failed");

		}
		return map;
	}

	/**
	 * @author PRAMKUL
	 * @param Locator
	 * @return
	 */
	public int getColumnFromHeader(String HeaderToLocate, By PathToTableHeader) {
		AtomicInteger counter = new AtomicInteger(1);
		int PostionOfColumn = 0;
		try {
			Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);

			/*********************
			 * LOCATE THE COLUMN POSITION
			 **********************/
			List<WebElement> TableHeader = waitForElement
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PathToTableHeader));
			// Debug: Printing each header

			for (WebElement EachHeader : TableHeader) {
				if (!(EachHeader.getText().isEmpty()) && (EachHeader.getText()).equalsIgnoreCase(HeaderToLocate)) {
					PostionOfColumn = counter.get();
					break;
				}
				counter.incrementAndGet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PostionOfColumn != 0 ? counter.get() : -1;
	}
	public void ClickElement(WebElement webelement) {
		Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(20000))
				.pollingEvery(Duration.ofMillis(1000)).pollingEvery(Duration.ofMillis(1000))
				.ignoring(StaleElementReferenceException.class);
		try {
			waitForElement.until(ExpectedConditions.visibilityOf(webelement));

			waitForAjax(driver);
			// Suggested to make it as global wait
			waitForElement.until(ExpectedConditions.elementToBeClickable(webelement)).click();

		} catch (WebDriverException e) {
			// Click Functionality using Action class
			// Approach -1
			Function<Boolean, Boolean> click_using_action_class = (i) -> {
				Boolean executionStatus = null;
				try {
					WebElement element = waitForElement.until(ExpectedConditions.elementToBeClickable(webelement));

					Actions action = new Actions(driver);
					action.moveToElement(element).click().perform();
					executionStatus = false;

				} catch (Exception ActionException) {
					executionStatus = true;
					// returnFalse if exception occurs

				}

				return executionStatus;

			};

			// Approach -2
			// Click Functionality using JS class
			Function<Boolean, Boolean> conv = (i) -> {
				Boolean localStatus = null;
				if (i) {

					try {
						// Implement action using javascript executor
						// return true if exception is fine
						WebElement element = waitForElement.until(ExpectedConditions.elementToBeClickable(webelement));
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						// jse.executeScript("scroll(0, 250)");
						// waitFor();
						jse.executeScript("arguments[0].click();", element);
						localStatus = true;
					} catch (Exception JSExecutor) {
						// return false if exception occured
						localStatus = false;
					}
				}
				return localStatus;
			};

			Boolean clickStatus = conv.andThen(click_using_action_class).apply(true);
		} catch (Exception OuterException) {
			OuterException.printStackTrace();
		}
	}

	public static boolean waitForAjax(WebDriver driver) {
		boolean flag = false;
		try {
			flag = new WebDriverWait(driver, Duration.ofSeconds(40)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					return (Boolean) js.executeScript("return jQuery.active == 0");
				}
			});
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean isDisplayed(By Locator) { 
		try {
			Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(20000)).pollingEvery(Duration.ofMillis(1000))
            		.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
			
			 waitForElement.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isDisplayed(WebElement w) { //rosmols
		try {
			Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(20000)).pollingEvery(Duration.ofMillis(1000))
            		.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
			
			 waitForElement.until(ExpectedConditions.visibilityOf(w));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isClickable(By Locator) 
	{
		try {
			Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(5000)).pollingEvery(Duration.ofMillis(1000))
            		.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
			waitForElement.until(ExpectedConditions.elementToBeClickable(Locator));
			return true;

		}catch(Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	public boolean isSelected(By Locator) 
	{
		try 
		{
			Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(20000)).pollingEvery(Duration.ofMillis(1000))
            		.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
			return waitForElement.until(ExpectedConditions.elementSelectionStateToBe(Locator, true));
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(pageLoadCondition);
    }
	public boolean isSorted(List<String> listOfStrings) {
	    return Comparators.isInOrder(listOfStrings, Comparator.<String> naturalOrder());
	}
	@FindBy(xpath = "//*[@data-testid='home']")
	public WebElement homeBtn;
	
	public void navigateToHomePage()
	{
		if(homeBtn.isDisplayed())
		{
		try 
		{
			homeBtn.click();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
		else
			System.out.println("home button not displayed");
	}


public void waitUntilPageloading(WebElement element) { //rosmols
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.invisibilityOf(element));
}
public void waitUntilPageloading() { //rosmols
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//	wait.until(ExpectedConditions.invisibilityOf(""));
}




public boolean isEnabled(WebElement w) { //rosmols
	try {
		Wait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(20000)).pollingEvery(Duration.ofMillis(1000))
        		.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		
		 waitForElement.until(ExpectedConditions.visibilityOf(w));
		 w.isEnabled();
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
}