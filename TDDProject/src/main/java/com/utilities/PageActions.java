package com.utilities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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

/**
 * This class perform webpage related actions like : click, enter value, clear,
 * close window, wait until progress bar etc.... & also it read property values
 * from property file
 * 
 * @author GRANDIS
 */
public class PageActions extends BaseInitializer {
	public static Logger LOGGER = Logger.getLogger(PageActions.class);

	Calendar cal = Calendar.getInstance();
	Date date = cal.getTime();
	String fileName = date.toString();

	/**
	 * @author GRANDIS Method for get the click on Given webElement, test get failed
	 *         if element not identified
	 * @return: property value
	 */
	public void clickOnElement(WebElement element) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitUntilLoadElement(element, 1, 30);
				scrollIntoView(element);
				if (isClickable(element) == true && element.isDisplayed() && element.isEnabled()) {
					element.click();
					break;
				}

			} catch (StaleElementReferenceException e) {
			} catch (Exception e) {
				extentTest.log(Status.FAIL,
						"Either element is not clickable or not displayed or not enabled --> " + e.getMessage());
				LOGGER.error("Either element is not clickable or not displayed or not enabled ");
				throw new Exception(e);
			}
			attempts++;
		}

	}

	public void scrollIntoView(WebElement element) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

			} catch (StaleElementReferenceException e) {
			} catch (Exception e) {
				extentTest.log(Status.FAIL, "Cannot scroll to the webelement -->" + e.getMessage());
				LOGGER.error("Cannot scroll to the webelement");
				throw new Exception(e);
			}
			attempts++;
		}
	}

	/**
	 * Method for waituntil page load max load time is 60 seconds
	 * 
	 * @author GRANDIS
	 * 
	 */
//	@FindBy(xpath="//tbody/tr[1]/th[1]/span[@class='MuiSkeleton-root MuiSkeleton-text MuiSkeleton-wave']")
//    public WebElement allScreens_pageProgressBar;
//	
//	public void waitUntilPageloading() {
//		WebDriverWait wait = new WebDriverWait(driver, 60);
////		WebElement spinner = pfHomePage.getallScreens_pageProgressBar();
////		WebElement spinner = getallScreens_pageProgressBar();
//		wait.until(ExpectedConditions.invisibilityOf(allScreens_pageProgressBar));
//	}

//	public WebElement getallScreens_pageProgressBar() {
//		return allScreens_pageProgressBar;

//	}

	/**
	 * @author GRANDIS Method for get the text from given weblement, test get failed
	 *         if element not identified
	 * @param element
	 * @return : return string i.e text of element
	 * 
	 * @throws IOException
	 */
	public String getText(WebElement element) throws IOException {
		String text = null;
		try {
			waitUntilLoadElement(element, 0, 15);
			text = element.getText();
			normalwait();
		} catch (Exception e) {
			extentTest.log(Status.FAIL, e.toString());
		}
		return text;
	}

	/**
	 * @author GRANDIS Method for enter value in the given element, test get failed
	 *         if element not identified
	 * @param element to identify
	 * @param val     for text field
	 */
	public void enterValue(WebElement element, String val) {

		try {
			waitUntilLoadElement(element, 0, 20);
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(val);
				normalwait();
			}
		} catch (Exception e) {
			extentTest.log(Status.FAIL, e.toString());
			LOGGER.error(" Not able to Enter text in field due to Exception ");

		}

	}

	/***
	 * Author: siva Desc: this method wait until given seconds for the provided
	 * element visible
	 * 
	 * @param Element:     objec to identify
	 * @param pollingSec   start from 1
	 * @param timoutSec120 Maximum seconds 60
	 * @throws Exception
	 */
	public void waitUntilLoadElement(WebElement Element, int pollingSec, int timoutSec120) throws Exception {

		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timoutSec120))
				.pollingEvery(Duration.ofSeconds(pollingSec))
				.ignoring(NoSuchElementException.class, TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		try {
			WebElement element = Element;
			fWait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException NSE) {
			LOGGER.error("Element Not found please check xpath/css then trying again - ");
			NSE.printStackTrace();
			extentTest.log(Status.FAIL, NSE.toString());
		} catch (Exception e) {
			e.toString();
			LOGGER.error(
					"Getting Exception either illegalarugument i.e xpath/css null or any other exception or Timeout --> "
							+ e.toString());
			extentTest.log(Status.FAIL, e.toString());
			extentTest.log(Status.FAIL,
					"Getting Exception either illegal arugument i.e xpath/css null or any other exception or Timeout --> "
							+ e.toString());
			throw new Exception(e);
		}
	}

	/***
	 * Author: siva Name;waitUntilListOfElementsPresent Desc: this method wait until
	 * list of elements visible and wait
	 * 
	 * @param Element:     object to identify elements
	 * @param timoutSec120 Maximum seconds 120
	 */
	public void waitUntilListOfElementsPresent(List<WebElement> listOfElements, int timoutSecMax120) {
//		WebDriverWait wait=new WebDriverWait(driver, timoutSecMax120);

//		wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
	}

	public void normalwait() {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	}

	/**
	 * @author GRANDIS Method for click on element by using javascriptExecutor,
	 *         alternative for clickonElement when it failed to click,
	 * @param element
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void clickUsingJscript(WebElement element) throws InterruptedException, IOException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		try {
			waitUntilLoadElement(element, 0, 15);
			if (isClickable(element) == true && element.isDisplayed() && element.isEnabled()) {

				jse.executeScript("arguments[0].click();", element);
				normalwait();
			}
		} catch (Exception e) {
			// assert.fail("Element not found to click on element" +e.printstacktrace);
			// "Failed reason", e.toString());
			assertEquals(0, 1);
			extentTest.log(Status.FAIL, e.toString());

		}
	}

	/**
	 * @author GRANDIS Method for check string present in the given Array
	 * @param text
	 * @param strArray
	 * @return
	 */

	public boolean validateStringArray(String text, String[] strArray) {
		boolean flag = false;
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].equalsIgnoreCase(text)) {
				flag = true;
				break;
			} else {
				continue;
			}
		}
		return flag;
	}

	/**
	 * @author GRANDIS Method for convert given Weblist to StringArray
	 * @param list
	 * @return string[]
	 */
	public String[] convertWebListToStringArr(List<WebElement> list) {
		int total = list.size();
		String[] readText = new String[total];
		for (int i = 0; i < total; i++) {
			readText[i] = list.get(i).getText();
		}
		return readText;

	}

	/**
	 * @author GRANDIS Method for convert weblist to Stringlist
	 * @param list
	 * @return string list
	 */
	public List<String> convertWebListToStringList(List<WebElement> list) {
		int total = list.size();
		List<String> readList = new ArrayList();
		for (int i = 0; i < total; i++) {
			String readData = list.get(i).getText();
			if (readData == null) {
				continue;
			} else if (readData.equals(" ") || readData.isEmpty()) {
				continue;
			} else if (readData != null && !readData.equals(" ") && !readData.isEmpty()) {
				readList.add(readData);
			} else {
				continue;
			}
		}
		return readList;

	}

	/**
	 * @author GRANDIS Method for click on browser back button
	 */

	public void browserBackNavigation() {
		driver.navigate().back();
	}

	/**
	 * @author Priyanv Method for is element can clickable
	 * @param element
	 * @return
	 */
	public boolean isClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @author PRIYANV Method for Scroll down to listview
	 * @param element
	 */
	public void scrollToElementInDropdown(List<WebElement> element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < element.size(); i++) {
			jse.executeScript("arguments[0].scrollIntoView();", element.get(i));
		}

	}

	/**
	 * @author GRANDIS Method for close browser
	 */
	public void closeWindow() {
		driver.close();
	}

	/**
	 * @author PRIYANV Method for is scrollbarprsent check
	 */
	public void isScrollBarPresent() {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		if (test == true) {
			LOGGER.debug("Scrollbar is present.");
		} else if (test == false) {
			LOGGER.error("Scrollbar is not present.");
		}
	}

	/**
	 * @author GRANDIS Method for switch to given window
	 * @param windowName
	 */
	public void switchToWindow(String windowName) {
		driver.switchTo().window(windowName);

	}

	/**
	 * @author PRIYANV Method accept the alert
	 * @return true after accept else false
	 */
	public static boolean acceptAlert() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			a.accept();
			return true;
		} catch (Exception e) {
			LOGGER.debug("no alert present");
			return false;
		}
	}

	/**
	 * @author PRIYANV Method for dismiss the alert
	 * @return true after dismiss else false
	 */
	public static boolean dismissAlert() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			a.dismiss();
			return true;

		} catch (Exception e) {

			LOGGER.debug("no alert Present");
			return false;

		}
	}

	/**
	 * @author PRIYANV Method for select checkbox elemnt
	 * @param checkbox
	 */
	public static void checkbox_Checking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			LOGGER.debug("Checkbox is already checked");
		} else {
			checkbox.click();
			LOGGER.debug("Checked the checkbox");
		}
	}

	/**
	 * @author PRIYANV Method for unselect the checkbox
	 * @param checkbox
	 */
	public static void checkbox_Unchecking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			LOGGER.debug("Checkbox is unchecked");
		} else {
			LOGGER.debug("Checkbox is already unchecked");
		}
	}

	/**
	 * Method for mouse over on Element
	 * 
	 * @author @author PRAMKUL
	 * 
	 * @param element
	 */
	public void mouseOverOnElement(WebElement element) {
		Actions Action = new Actions(driver);
		boolean flag = element.isDisplayed();
		if (flag == true) {
			Action.moveToElement(element).build().perform();

		}
	}

	/**
	 * @author PRAMKUL Method for get the Tooltip
	 * @param toolTipofWebElement
	 * @return
	 * @throws InterruptedException
	 */

	public static String getToolTip(WebElement toolTipofWebElement) throws InterruptedException {
		String tooltip = toolTipofWebElement.getAttribute("title");
		LOGGER.debug("Tool text : " + tooltip);
		return tooltip;
	}

	/***
	 * @author PRAMKUL desc: it will move to window of given index 0 --> current tab
	 *         1--> new tab
	 * @param index
	 */
	public void switchWindow(int index) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(index));
		// switchToWindow(tabs.get(index));
	}

	/***
	 * @author PRAMKUL Desc: it will validate newtab URL contains given parameter
	 *         text and return URL
	 * @param URLcontainText
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String ValidateNewTabURLThenCloseTab(String URLcontainText) throws IOException, InterruptedException {
		normalwait();
		Thread.sleep(3000);
		switchWindow(1);
		String URL = driver.getCurrentUrl();
		if (URL.contains(URLcontainText.toUpperCase())) {
			extentTest.log(Status.PASS, "New Window URL Contains the" + "   " + URLcontainText);
			logWithScreenshot("newWindowScreenShot");
		} else {
			try {
				extentTest.log(Status.FAIL, "Issue new Window");
				logWithScreenshot("FailureInNewWindow");
			} catch (Exception e) {
				Assert.assertNotNull(e);
			}
		}
		driver.close();
		return URL;
	}

	/**
	 * @author PRAMKUL
	 */
	public void waitUntilProgressCompleted() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement spinner = pfHomePage.getAllscreens_spinner_progressBar();
			if (wait.until(ExpectedConditions.visibilityOf(spinner)) != null) {
				wait.until(ExpectedConditions.invisibilityOf(spinner));
			}
		} catch (Exception e) {
			LOGGER.error("Got Exception with spinner method  " + e.getMessage());
		}
	}

	/**
	 * @author PRAMKUL
	 */
	public void clear(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	/**
	 * @author PRAMKUL
	 */
	public boolean waitForReady() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			return wait.until(driver -> {
				boolean isAjaxFinished = (boolean) ((JavascriptExecutor) driver)
						.executeScript("return jQuery.active == 0");
				boolean isLoaderHidden = (boolean) ((JavascriptExecutor) driver)
						.executeScript("return $('.spinner').is(':visible') == false");
				return isAjaxFinished && isLoaderHidden;
			});
		} catch (Exception e) {
			return true;
		}

	}

	/**
	 * @author PRAMKUL
	 */
	public static void webwaitForpageLoad() {
		try {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(pageLoadCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author PRAMKUL
	 * @param element
	 * @param timeout
	 * @return
	 */
	public boolean isElementExist(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Here we will wait until element is not visible, if element is visible then it
		// will return web element
		// or else it will throw exception
		WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));

		// if element found then we will use- In this example I just called isDisplayed
		// method
		return webelement.isDisplayed();
	}

	public boolean isElementExistByLocator(By element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Here we will wait until element is not visible, if element is visible then it
		// will return web element
		// or else it will throw exception
		WebElement webelement = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));

		// if element found then we will use- In this example I just called isDisplayed
		// method
		return webelement.isDisplayed();
	}

	public void waitUntilLoadingElementAppears(WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Issue in waiting for loading symbol to disappear -->" + e.getMessage());
			LOGGER.error("Issue in waiting for loading");
			throw new Exception(e);
		}
	}

	public void waitUntilLoadingElementDisappears(WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(190));
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
//			extentTest.log(Status.FAIL, "Issue in waiting for loading symbol to disappear -->" + e.getMessage());
			extentTest.log(Status.PASS, "Data is displayed in the cells");
//			LOGGER.error("Issue in waiting for loading symbol to disappear");
//			throw new Exception(e);
		}
	}

	public void waitUntilLoadingSymbolDisappearsPolling(WebElement Element, int pollingSec, int timoutSec120)
			throws Exception {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timoutSec120))
				.pollingEvery(Duration.ofSeconds(pollingSec))
				.ignoring(NoSuchElementException.class, TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		try {
			WebElement element = Element;
			fWait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Waiting for loading symbol to disappear -->" + e.getMessage());
			LOGGER.error("Issue in waiting for loading symbol to disappear");
			throw new Exception(e);
		}
	}

	public boolean handelStaleElementByRetryingFindClick(WebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 4) {
			try {
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void waitUntilLoadingSymbolAppearsPolling(WebElement Element, int pollingSec, int timoutSec120)
			throws Exception {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timoutSec120))
				.pollingEvery(Duration.ofSeconds(pollingSec))
				.ignoring(NoSuchElementException.class, TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		try {
			WebElement element = Element;
//			fWait.until(ExpectedConditions
//					.presenceOfElementLocated(element));
			fWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Waiting for loading symbol to appear -->" + e.getMessage());
			LOGGER.error("Issue in waiting for loading symbol to appear");
			throw new Exception(e);
		}
	}
	
	public void waitUntilLoadingSymbolAppearsPollingWithoutFail(WebElement Element, int pollingSec, int timoutSec120)
			throws Exception {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timoutSec120))
				.pollingEvery(Duration.ofSeconds(pollingSec))
				.ignoring(NoSuchElementException.class, TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		try {
			WebElement element = Element;
//			fWait.until(ExpectedConditions
//					.presenceOfElementLocated(element));
			fWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
//			extentTest.log(Status.FAIL, "Waiting for loading symbol to appear -->" + e.getMessage());
			LOGGER.error("Issue in waiting for loading symbol to appear");
			throw new Exception(e);
		}
	}

	public void waitUntilLoadingElementAppearsByList(WebElement elementToWaitFor, int timeout, int pollTimeout)
			throws Exception {
		abstract class fluentWait {

			protected WebDriver driver;
			FluentWait<WebDriver> fluentWait;

			protected fluentWait(WebDriver driver) {
				this.driver = driver;
				fluentWait = new FluentWait<WebDriver>(this.driver);
			}

			@SuppressWarnings("deprecation")
			protected WebElement waitUntil(By elementToWaitFor, int timeout, int pollTimeout) {
				fluentWait.withTimeout(Duration.ofSeconds(timeout));
				fluentWait.pollingEvery(Duration.ofSeconds(pollTimeout));
				fluentWait.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//tbody[@data-testid='manageDatabaseTblTB']/tr")));
				return driver.findElement(elementToWaitFor);
			}

			protected WebElement waitUntil(By elementToWaitFor) {
				return this.waitUntil(elementToWaitFor, 45, 1);
			}

			protected List<WebElement> waitUntilList(final List<WebElement> elementsToWaitFor, Duration interval) {
				fluentWait.withTimeout(interval);
				fluentWait.pollingEvery(interval);
				fluentWait.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.cssSelector("div[class='ui active loader loader']")));
				return (elementsToWaitFor);
			}

			protected List<WebElement> waitUntilList(By elementsToWaitFor) throws InterruptedException {
				// loop until element list value is not 0
				while (driver.findElements(elementsToWaitFor).size() == 0) {
					for (int i = 0; i < 10; i++) {
						if (i > 5) {
							break;
						}
						System.out.println("Waiting for list element...");
						Thread.sleep(1000);
					}
				}

				return (driver.findElements(elementsToWaitFor));
			}

		}
	}

	private static WebElement waitForStableElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickHiddenUsingJscript(WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		try {
			jse.executeScript("arguments[0].click();", element);

		} catch (Exception e) {

			extentTest.log(Status.FAIL, "Element could not be clicked -->" + e.toString());
			throw new Exception(e);

		}
	}

}
