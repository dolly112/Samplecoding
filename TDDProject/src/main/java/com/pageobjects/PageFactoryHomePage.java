package com.pageobjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.utilities.BaseInitializer;
import com.utilities.BusinessUtilities;
import com.utilities.PageActions;

/**
 * This is for creates page-wise Object Repository, it contains Below: 1)
 * Multiple language objects 2) Dynamic objects/parameterized xpath, which needs
 * to be declare as string
 * 
 * @author GRANDIS
 *
 */
public class PageFactoryHomePage extends BaseInitializer {

	/**
	 * Object definition should start with ScreenName,objectType and Objectname
	 * -----------Ex: dashboard_Btn_Apply-----------
	 * 
	 * Dpdw: Dropdown TBox :TextBOX Li: Link Rdbtn: RadioButton Chbox:CheckBox
	 * Multslt:Mulitselect Img:Image Icn:Icon Btn:Button
	 *
	 */
	public PageFactoryHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	BusinessUtilities businessUtilities = new BusinessUtilities();
	PageActions pageActions = new PageActions();

	@FindBy(xpath = "//tbody/tr[1]/th[1]/span[@class='MuiSkeleton-root MuiSkeleton-text MuiSkeleton-wave']")
	public WebElement allScreens_pageProgressBar;

	@FindBy(xpath = "//*[@data-testid='manageMapRoleBtn']")
	public WebElement manageMapRoleBtn;

	@FindBy(xpath = "//span[@class='MuiSkeleton-root MuiSkeleton-text MuiSkeleton-wave'][1]")
	public WebElement Allscreens_spinner_progressBar;

	@FindBy(xpath = "(//div[@role='row'])[1]//div[@role='columnheader']")
	public List<WebElement> allScreens_Tbl1_ColumnHeader;

	@FindBy(xpath = "(//div[@role='grid'])[1]//div[@class='rt-resizable-header-content']")
	public List<WebElement> allScreens_Tbl2_ColumnHeader;

	@FindBy(xpath = "(//button[@class='-btn'])[2]")
	public WebElement allScreensTbl1_Btn_Next;

	@FindBy(xpath = "(//span[@class='-totalPages'])[1]")
	public WebElement allScreensTbl1_Txt_PageCount;

	@FindBy(xpath = "//div[@role='rowgroup']")
	public List<WebElement> Table_NoOfrows;

	@FindBy(xpath = "(//div[contains(@class,'LanguageSelect')])[1]")
	public WebElement allScreens_Dpdw_Lang;

	@FindBy(xpath = "(//div[contains(@class,'Dropdown_label') and contains(text(),'EN')])[1]")
	public WebElement LanguageEN;

	@FindBy(xpath = "(//div[contains(@class,'Dropdown_label') and contains(text(),'DE')])[1]")
	public WebElement LanguageDE;

	@FindBy(xpath = "(//input[contains(@class,'Dropdown_previewInput')])[1]")
	public WebElement allScreen_Dpdw_selectedLanguage;

	@FindBy(xpath = "//li[@class='MuiBreadcrumbs-li']//*[name()='svg']")
	public WebElement homeIcon;

	@FindBy(xpath = "//h5[text()='PLA - User Management']")
	public WebElement txtPLAUserManagement;

	@FindBy(xpath = "//sub")
	public WebElement txtVersion;

	@FindBy(xpath = "//p[text()='Home']")
	public WebElement btnHome;

	@FindBy(xpath = "//div[@data-testid='languageDropdown']")
	public WebElement txtEnglish;

	@FindBy(xpath = "//ul[@role='menu']/li")
	public List<WebElement> txtUserProfileOptions;

	@FindBy(xpath = "//button[@data-testid='manageRolesBtn']")
	public WebElement manageRolesButton;

	@FindBy(xpath = "//li[@role='option']")
	public List<WebElement> ddLanguagesOption;

	@FindBy(xpath = "//div[contains(text(),'Show All')]")
	public WebElement ENAllScreen_Dpdwn_ShowAlloption;

	@FindBy(xpath = "//div[contains(text(),'Alles')]")
	public WebElement DEAlllScreen_Dpdwn_ShowAlloption;

	@FindBy(xpath = "//span[text()='Logout']")
	public WebElement ENdashboard_Optn_Logout;

	@FindBy(xpath = "//span[text()='Ausloggen']")
	public WebElement DEdashboard_Optn_Logout;

	@FindBy(xpath = "//*[@data-testid='home']")
	public WebElement homeBtn;

	@FindBy(xpath = "//*[@id='root']/div/header/div/div/div[2]/div[2]/div/ul/li[2]")
	public WebElement selectLogout1;

	@FindBy(xpath = "//button[@data-testid='acountCircle']")
	public WebElement userDropdown1;

	@FindBy(xpath = "//*[text()='Manage Costcenters']")
	public WebElement manageCostcentersBtn;

	@FindBy(xpath = "//h6")
	public WebElement hdrName;

	@FindBy(xpath = "//*[@data-testid='manageUserBtn']")
	public WebElement manageUserBtn;

	@FindBy(xpath = "//*[@id='manageRequestAccessV2Btn']")
	public WebElement requestAccessButton;

	@FindBy(xpath = "//button//p")
	WebElement txtYouDoNotHavePermission;

	@FindBy(xpath = "//button[@type='button']//h2")
	List<WebElement> txtsAccessDenied;

	@FindBy(xpath = "//button[@data-testid='manageMapRoleBtn']")
	public WebElement MapRoleBtn;

	@FindBy(xpath = "//*[@data-testid='manageDatabaseBtn']")
	public WebElement manageDatabaseButton;

	public WebElement getallScreens_pageProgressBar() {
		return allScreens_pageProgressBar;
	}

	public WebElement getAllscreens_spinner_progressBar() {
		return Allscreens_spinner_progressBar;

	}

	public List<WebElement> getallScreens_Tbl1_ColumnHeader() {
		return allScreens_Tbl1_ColumnHeader;
	}

	public List<WebElement> getallScreens_Tbl2_ColumnHeader() {
		return allScreens_Tbl2_ColumnHeader;
	}

	public WebElement getallScreensTbl1_Btn_Next() {
		return allScreensTbl1_Btn_Next;
	}

	public WebElement getallScreensTbl1_Txt_PageCount() {
		return allScreensTbl1_Txt_PageCount;
	}

	public List<WebElement> getTable_NoOfrows() {
		return Table_NoOfrows;
	}

	public WebElement getallScreens_Dpdw_Lang() {
		return allScreens_Dpdw_Lang;
	}

	public WebElement getLanguageEN() {
		return LanguageEN;
	}

	public WebElement getLanguageDE() {
		return LanguageDE;
	}

	public WebElement getallScreen_Dpdw_selectedLanguage() {
		return allScreen_Dpdw_selectedLanguage;
	}

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public WebElement gethdrPLAUserManagement() {
		return txtPLAUserManagement;
	}

	public WebElement getTxtVersion() {
		return txtVersion;
	}

	public List<WebElement> getMyAccountOptions() {
		return txtUserProfileOptions;
	}

	public WebElement getTxtEnglish() {
		return txtEnglish;
	}

	public List<WebElement> getddLanguagesOption() {
		return ddLanguagesOption;
	}

	public WebElement getHdrName() {
		return hdrName;
	}

	public String AllScreen_Dpdwn_MultiselectIcon = "(//div[contains(@class,'Multiselect')])[parameter]";

	public String getAllScreen_Dpdwn_MultiselectIcon() {
		return AllScreen_Dpdwn_MultiselectIcon;
	}

	public WebElement getAlllScreen_Dpdwn_ShowAlloption() {
		if (reqLanguage.contains("EN"))
			return ENAllScreen_Dpdwn_ShowAlloption;
		else
			return DEAlllScreen_Dpdwn_ShowAlloption;

	}

	public String AllScreen_Dpdwn_SelectFilter = "//div[contains(@class,'switchUi_Checkbox__container')]//div[contains(text(),'parameter')]";

	public String getAllScreen_Dpdwn_SelectFilter() {
		return AllScreen_Dpdwn_SelectFilter;
	}

	public WebElement getdashboard_Optn_Logout() {
		if (reqLanguage.contains("EN"))
			return ENdashboard_Optn_Logout;
		else
			return DEdashboard_Optn_Logout;

	}

	public void logout() {
		userDropdown1.click();
		selectLogout1.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void navigateToHomePage() throws Exception {
		pageActions.waitUntilLoadingSymbolAppearsPolling(homeBtn, 1, 120);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(60));
		if (homeBtn.isDisplayed()) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(homeBtn));
				homeBtn.click();
				extentTest.log(Status.PASS, "Navigated to UM Home page successfully");

			} catch (Exception e) {
				e.printStackTrace();
				wait.until(ExpectedConditions.elementToBeClickable(homeBtn));
				homeBtn.click();
				extentTest.log(Status.PASS, "Navigated to UM Home page successfully");
			}

		} else
			extentTest.log(Status.FAIL, "Home Screen is NOT  displayed");
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public void clickOnManageRoles() {
		if (businessUtilities.isDisplayed(manageRolesButton)) {
			try {
				manageRolesButton.click();
				extentTest.log(Status.PASS, "Manage Map Role button is clicked successfully on Home page");

			} catch (Exception e) {
				e.printStackTrace();
				extentTest.log(Status.FAIL, "Manage Map Role button is NOT clicked");
			}

		}
	}

	public void clickMapRoleButton() {
		if (businessUtilities.isDisplayed(manageMapRoleBtn)) {
			try {
				manageMapRoleBtn.click();
				extentTest.log(Status.PASS, "Manage Map Role button is clicked successfully on Home page");

			} catch (Exception e) {
				e.printStackTrace();

			}

		} else
			extentTest.log(Status.FAIL, "Manage Map Role is NOT clicked on Home Page");
	}

	public WebElement getManageCostcentersBtn() {
		return manageCostcentersBtn;
	}

	public void clickManageCostcentersButton() {
		if (manageCostcentersBtn.isDisplayed()) {
			try {
				manageCostcentersBtn.click();
				extentTest.log(Status.PASS, "Manage Costcenters button is clicked successfully on Home page");

			} catch (Exception e) {
				e.printStackTrace();
				extentTest.log(Status.FAIL, "Manage Costcenters button is NOT clicked");
			}

		} else
			extentTest.log(Status.FAIL, "Manage Costcenters button is NOT clicked on Home Page");
	}

	public WebElement getmanageUserBtn() {
		return manageUserBtn;
	}

	public void clickManageUsersButton() {
		if (businessUtilities.isDisplayed(manageUserBtn)) {
			try {
				manageUserBtn.click();
				extentTest.log(Status.PASS, "Manage User Button is clicked successfully on Home page");

			} catch (Exception e) {
				e.printStackTrace();
				if (businessUtilities.isDisplayed(manageUserBtn)) {
					manageUserBtn.click();
				} else
					extentTest.log(Status.FAIL, "Manage User Button is NOT clicked");
			}

		} else
			extentTest.log(Status.FAIL, "Manage User Button is NOT clicked on Home Page");
	}

	public WebElement getMapRoleBtn() {
		return MapRoleBtn;
	}

	public void clickMapRolesButton() {
		if (MapRoleBtn.isDisplayed()) {
			try {
				MapRoleBtn.click();
				extentTest.log(Status.PASS, "Map Role button is clicked successfully on Home page");

			} catch (Exception e) {
				e.printStackTrace();
				extentTest.log(Status.FAIL, "Map Role button is NOT clicked");
			}

		} else
			extentTest.log(Status.FAIL, "Map Role button is NOT clicked on Home Page");
	}

	public boolean navigateToManageDatabasePage() {

		if (businessUtilities.isDisplayed(manageDatabaseButton)) {
//				manageDatabaseButton.click();
			businessUtilities.ClickElement(manageDatabaseButton);
			extentTest.log(Status.PASS, "Navigation to Manage Database page is successful");

			return true;
		} else {
			extentTest.log(Status.FAIL, "Navigation to Manage Database page is successful");
			return false;
		}
	}

	public WebElement getrequestAccessButton() {
		return requestAccessButton;
	}

	public boolean navigateToRequestAccessPage() {

		if (requestAccessButton.isDisplayed()) {
			requestAccessButton.click();
			extentTest.log(Status.PASS, "Navigation to Request Access page is successful");

			return true;
		} else {
			extentTest.log(Status.FAIL, "Navigation to Request Access page is successful");
			return false;
		}
	}

	/**
	 * @author ROSMOLS
	 */

	public List<WebElement> verifyAccessDeniedErrorMessage() {
		return txtsAccessDenied;
	}

	public WebElement gettxtYouDoNotHavePermission() {
		return txtYouDoNotHavePermission;
	}

	public WebElement getbtnHome() {
		return btnHome;
	}

	public void clickOnBackToHomeScreen() {
		if (businessUtilities.isDisplayed(btnHome)) {
			try {
				pageActions.clickOnElement(btnHome);
				extentTest.log(Status.PASS, "Home button is clicked successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			try {
				pageActions.clickOnElement(btnHome);
				extentTest.log(Status.PASS, "Home button is clicked successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
