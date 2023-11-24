package com.pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.utilities.BusinessUtilities;
import com.utilities.PageActions;


public class PageFactoryLoginPage extends PageActions {

	public PageFactoryLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	BusinessUtilities businessUtilities = new BusinessUtilities();

	@FindBy(xpath = "//button[@id='username_back_btn']")
	public WebElement login_Icn_Int_UserNameClose;

	@FindBy(xpath = "//button[@data-testid='acountCircle']")
	public WebElement logoutMenu;

	@FindBy(xpath = "//li[@data-testid='plaLogout']")
	public WebElement logoutButton;

	@FindBy(xpath = "//div[@id='signout-page']")
	public WebElement logoutScreenID;

	public WebElement getlogin_Icn_Int_UserNameClose() {
		return login_Icn_Int_UserNameClose;
	}

	@FindBy(xpath = "//input[@id='userid']")
	public WebElement login_TBox_Int_UserName;

	public WebElement getlogin_TBox_Int_UserName() {
		return login_TBox_Int_UserName;
	}

	@FindBy(xpath = "//input[@id='password']")
	public WebElement login_TBox_Int_Password;

	@FindBy(xpath = "//form[@id='loginform']")
	public WebElement loginForm;

	@FindBy(xpath = "//div[@id='faqitemlist']")
	public WebElement faqItemList;

	public WebElement getlogin_TBox_Int_Password() {
		return login_TBox_Int_Password;
	}

	@FindBy(xpath = "//h2[text()='Welcome']")
	public WebElement login_Txt_Welcome;

	@FindBy(xpath = "//h2[normalize-space()='Welcome']")
	public WebElement hdrwelcome;

	@FindBy(xpath = "//p[.='You were successfully logged off.']")
	public WebElement txtYouWereSuccessfullyLoggedOff;

	@FindBy(xpath = "//h2[.='Logged off']")
	public WebElement txtLoggedOff;

	@FindBy(xpath = "//span[@class='MuiSkeleton-root MuiSkeleton-text MuiSkeleton-wave']")
	public WebElement sekeltonLoading;

	public WebElement getlogin_Txt_Welcome() {
		return login_Txt_Welcome;
	}

	public WebElement getlogin_Txt_sekeltonLoading() {
		return sekeltonLoading;
	}

	public WebElement getTxtYouWereSuccessfullyLoggedOff() {
		return txtYouWereSuccessfullyLoggedOff;
	}

	public WebElement getTxtLoggedOff() {
		return txtLoggedOff;
	}

	public WebElement getLogoutMenu() {
		return logoutMenu;
	}

	public WebElement getloginForm() {
		return loginForm;
	}

	/**
	 * Method for login to application
	 * 
	 * @param loginid
	 * @param Pwd
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void login(String userId, String password) throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(60));
		WebElement clearUserID = getlogin_Icn_Int_UserNameClose();
		try {
			wait.until(ExpectedConditions.visibilityOf(getlogin_TBox_Int_UserName()));
//			Thread.sleep(5000);
			getlogin_TBox_Int_UserName().sendKeys(userId, Keys.ENTER);
//			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(getlogin_TBox_Int_Password()));
//			Thread.sleep(5000);
			getlogin_TBox_Int_Password().sendKeys(password, Keys.ENTER);

			LOGGER.info(" login to the application successfully");

		} catch (NoSuchElementException ignored) {
			wait.until(ExpectedConditions.visibilityOf(getlogin_Icn_Int_UserNameClose()));
			clearUserID.isDisplayed();
			clearUserID.click();
			getlogin_TBox_Int_UserName().sendKeys(userId, Keys.ENTER);
			getlogin_TBox_Int_Password().sendKeys(password, Keys.ENTER);
			LOGGER.info(" login to the application successfully");

		}
	}

	public void loginPLAWeb(String plaUserId, String plaPassWord) throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(60));
		WebElement clearUserID = getlogin_Icn_Int_UserNameClose();
		try {
			wait.until(ExpectedConditions.visibilityOf(getlogin_TBox_Int_UserName()));
			getlogin_TBox_Int_UserName().sendKeys(plaUserId, Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOf(getlogin_TBox_Int_Password()));
			getlogin_TBox_Int_Password().sendKeys(plaPassWord, Keys.ENTER);
			LOGGER.info(" login to the application successfully");

		} catch (NoSuchElementException ignored) {
			wait.until(ExpectedConditions.visibilityOf(getlogin_Icn_Int_UserNameClose()));
			clearUserID.isDisplayed();
			clearUserID.click();
			getlogin_TBox_Int_UserName().sendKeys(plaUserId, Keys.ENTER);
			getlogin_TBox_Int_Password().sendKeys(plaPassWord, Keys.ENTER);
			LOGGER.info(" login to the application successfully");

		}
	}

	public void clickOnLogout() throws Exception {
//		businessUtilities.waitUntilLoadElement(logoutMenu, 1, 60);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(60));
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
		wait.until(ExpectedConditions.visibilityOf(logoutMenu));
		if (logoutMenu.isDisplayed()) {
			try {
				try {
					logoutMenu.click();
				} catch (Exception e) {
					act.moveToElement(logoutMenu).click().perform();
//					logoutMenu.click();	
				}
				extentTest.log(Status.PASS, "User profile is clicked");
//				waitUntilLoadingSymbolAppearsPolling(logoutButton, 1, 60);	
				wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
				try {
					logoutButton.click();
				} catch (Exception e) {
					act.moveToElement(logoutButton).click().perform();
				}
				extentTest.log(Status.PASS, "Logout is clicked successfully");

			} catch (Exception e) {
				e.printStackTrace();
				if (logoutMenu.isDisplayed()) {
					logoutMenu.click();
					extentTest.log(Status.PASS, "User profile is clicked");
					waitUntilLoadingSymbolAppearsPolling(logoutButton, 1, 60);
					logoutButton.click();
					extentTest.log(Status.PASS, "Logout is clicked successfully");

				} else {
					extentTest.log(Status.FAIL, "User profile is not displayed for log out");
				}

			}
		} else {
			extentTest.log(Status.FAIL, "User profile is not displayed for log out");
		}

	}

	public boolean isLogoutScreenDisplayed() {
		if (logoutScreenID.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean isDaimlerFormDisplayed() {
		if (isElementExist(loginForm, 20) && isElementExist(faqItemList, 20))
			return true;
		return false;
	}

	public boolean isDaimlerWelcomeTextDisplayed() {
		if (isElementExist(hdrwelcome, 20))
			return true;
		return false;
	}

	@FindBy(xpath = "//*[@type='submit']")
	WebElement btnlogin;

	public boolean verifyUsernamePasswordField() {
		if (hdrwelcome.isDisplayed())
			login_TBox_Int_UserName.sendKeys("rosmols", Keys.ENTER);
		login_TBox_Int_Password.sendKeys("rosmols");
		btnlogin.click();
		return true;

	}

	public void validateLogoutScreen() {
		if (txtYouWereSuccessfullyLoggedOff.isDisplayed() && txtYouWereSuccessfullyLoggedOff.isDisplayed()) {
			extentTest.log(Status.PASS, "Logged out of the UM application successfully");

		} else {
			extentTest.log(Status.FAIL, "Logged out is not successfull from UM application");
		}
	}

	/**
	 * @throws InterruptedException
	 * 
	 */
	public void clickOnLogoutTrial() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(60));
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
		wait.until(ExpectedConditions.visibilityOf(logoutMenu));
		if (logoutMenu.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
			try {
				logoutMenu.click();
			} catch (Exception e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click()", logoutMenu);
			}
			extentTest.log(Status.PASS, "User profile is clicked");
			Thread.sleep(2000);
			if (!logoutButton.isDisplayed()) {
				logoutMenu.click();
				extentTest.log(Status.PASS, "User profile is clicked");

			}
			wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
			logoutButton.click();
			extentTest.log(Status.PASS, "Logout is clicked successfully");
		} else {
			extentTest.log(Status.FAIL, "User profile is not displayed for log out");
		}

	}

	@FindBy(xpath = "//header/following-sibling::div//button")
	public List<WebElement> btnHomeCount;

	public List<WebElement> getBtnCount() {
		return btnHomeCount;
	}

	public void validateButtonCountForUMLogin() {
		List<WebElement> buttonsList;
		buttonsList = getBtnCount();
		int buttonsCount = buttonsList.size();
		Assert.assertEquals(buttonsCount, 2, "expected count for UM login is 2, but found " + buttonsCount);
		extentTest.log(Status.PASS,
				"The count of buttons verified successfully for UM admin login in UM home page: " + buttonsCount);

	}

}
