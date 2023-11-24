/*
 * package com.pageobjects;
 * 
 * import java.io.IOException; import java.time.Duration; import
 * java.util.ArrayList; import java.util.Arrays; import java.util.HashMap;
 * import java.util.Iterator; import java.util.List; import java.util.Map;
 * import java.util.NoSuchElementException; import
 * java.util.concurrent.ThreadLocalRandom; import java.util.stream.Collectors;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor;
 * import org.openqa.selenium.Keys; import
 * org.openqa.selenium.StaleElementReferenceException; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedCondition; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.FluentWait; import
 * org.openqa.selenium.support.ui.Wait; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.Assert;
 * 
 * import com.aventstack.extentreports.Status; import
 * com.daimler.plaUM.dataloader.ExcelValidations; import
 * com.daimler.plaUM.utilities.BaseInitializer; import
 * com.daimler.plaUM.utilities.BusinessUtilities; import
 * com.daimler.plaUM.utilities.ManageCostcentersValueStored; import
 * com.daimler.plaUM.utilities.ExcelActions; import
 * com.daimler.plaUM.utilities.PageActions;
 * 
 * public class PageFactoryAddEditCostCenterScreen extends BaseInitializer {
 * 
 * public PageFactoryAddEditCostCenterScreen(WebDriver driver) {
 * PageFactory.initElements(driver, this); }
 * 
 * PageActions pageActions = new PageActions(); BusinessUtilities
 * businessUtilities = new BusinessUtilities();
 * PageFactoryAddEditCostCenterScreen addEditCostCenterScreen;
 * 
 * @FindBy(xpath = "//p[@data-testid='addEditCostcenter']") public WebElement
 * AddEditCostCenterScreen;
 * 
 * @FindBy(xpath = "//input[@placeholder='Costcenter']") public WebElement
 * costCenterTxtFld;
 * 
 * @FindBy(xpath = "//input[@data-testid='subdepartmenttx']") public WebElement
 * subDepartmentTxtFld;
 * 
 * @FindBy(xpath = "//input[@data-testid='departmenttx']") public WebElement
 * departmentTxtFld;
 * 
 * @FindBy(xpath = "//input[@data-testid='planttx']") public WebElement
 * plantTxtFld;
 * 
 * @FindBy(xpath = "//textarea[@data-testid='description_txt_fld']") public
 * WebElement descriptionTxtFld;
 * 
 * @FindBy(xpath = "//button[@data-testid='saveBtn']") public WebElement
 * saveCostCenterBtn;
 * 
 * @FindBy(xpath = "//button[@data-testid='resetBtn']") public WebElement
 * resetCostCenterBtn;
 * 
 * @FindBy(xpath = "//button[@data-testid='deleteBtn']") public WebElement
 * deleteCostCenterBtn;
 * 
 * @FindBy(xpath = "//button[@data-testid='loadBtn']") public WebElement
 * loadCostCenterBtn;
 * 
 * @FindBy(xpath = "//a[@data-testid='manageCostcenters']") public WebElement
 * backToManageCostCenter;
 * 
 * @FindBy(xpath = "//input[@data-testid='modifyUser']") public WebElement
 * modifyUser;
 * 
 * @FindBy(xpath = "//input[@data-testid='modifyDate']") public WebElement
 * modifyDate;
 * 
 * @FindBy(xpath =
 * "//div[@data-testid='subdepartment']//p[text()='value has to be present']")
 * public WebElement subDeptMandatoryFieldMsg;
 * 
 * @FindBy(xpath =
 * "//div[@data-testid='department']//p[text()='value has to be present']")
 * public WebElement deptMandatoryFieldMsg;
 * 
 * @FindBy(xpath =
 * "//div[@data-testid='plant']//p[text()='value has to be present']") public
 * WebElement plantMandatoryFieldMsg;
 * 
 * @FindBy(xpath =
 * "//p[@class='MuiTypography-root makeStyles-textBold-623 MuiTypography-body2' and text()='Costcenter']"
 * ) public WebElement fieldColorValidation;
 * 
 * @FindBy(xpath =
 * "//tbody[@data-testid='mappedDatabasesTB']/tr[1]/td[3]/span[@data-testid='mappedDatabasesCB']//*[name()='svg']//*[local-name()='path']")
 * public WebElement mapDBS;
 * 
 * @FindBy(xpath = "//button[@data-testid='cancelBtn']") public WebElement
 * alertOnCancel;
 * 
 * @FindBy(xpath = "//button[@data-testid='confirmBtn']") public WebElement
 * alertOnYes;
 * 
 * @FindBy(xpath = "//p[@data-testid='confirm']") public WebElement
 * alertTxtConfirm;
 * 
 * @FindBy(xpath = "//*[contains(text(),'Save changes to Costcenter')]") public
 * WebElement alertTxtSaveChanges;
 * 
 * @FindBy(xpath = "//*[@data-testid='cancelBtn']") public WebElement
 * alertTxtNO;
 * 
 * @FindBy(xpath = "//*[@data-testid='confirmBtn']") public WebElement
 * alertTxtYES;
 * 
 * @FindBy(xpath = "//p[@data-testid='alert']") public WebElement alertTxt;
 * 
 * @FindBy(xpath = "//*[contains(text(),'is already in')]") public WebElement
 * alertTxtAlreadyInSystem;
 * 
 * @FindBy(xpath = "//*[@data-testid='exists']") public WebElement
 * costcenterAlreadyExistsConfirmationMsg;
 * 
 * @FindBy(xpath = "//*[text()='YES']") public WebElement alertYES; // mapped db
 * locators
 * 
 * @FindBy(xpath = "//legend[text()='Mapped Databases']") public WebElement
 * hdrMappedDatabases;
 * 
 * List<WebElement> mappedDatabasesColumnNames = driver
 * .findElements(By.xpath("//tbody/tr[@data-testid='mappedDatabases'][1]/td"));
 * 
 * @FindBy(xpath =
 * "//th[@data-testid='database']/span[2] //*[local-name()='svg'and @focusable='false']"
 * ) public WebElement focusFalseDatabase;
 * 
 * @FindBy(xpath =
 * "//th[@data-testid='database' and @aria-sort='ascending'] //span[@id='database-asc']"
 * ) public WebElement btnAscDatabase;
 * 
 * @FindBy(xpath = "//*[@data-testid='database' and @aria-sort='descending']")
 * public WebElement btnDscDatabase;
 * 
 * @FindBy(xpath = ("//*[@data-testid='description'] //*[@focusable='false']"))
 * public WebElement focusFalseDescription;
 * 
 * @FindBy(xpath = "//*[@data-testid='description' and @aria-sort='ascending']")
 * public WebElement btnAscDescription;
 * 
 * @FindBy(xpath =
 * "//*[@data-testid='description' and @aria-sort='descending']") public
 * WebElement btnDscDescription;
 * 
 * @FindBy(xpath = "//*[@placeholder='Database']") public WebElement
 * FilterOptionDatabase;
 * 
 * @FindBy(xpath = "//input[@placeholder='Description']") public WebElement
 * FilterOptionDescription;
 * 
 * @FindBy(xpath = "//tr/td[3] //span[contains(@class,'checked')]") public
 * WebElement dbCheckedMappedDbes;
 * 
 * @FindBy(xpath = "//legend[normalize-space()='Costcenter']") public WebElement
 * hdrCostcenters;
 * 
 * @FindBy(xpath = "//tbody[@data-testid='mappedDatabasesTB']/tr[1]/td[1]")
 * public WebElement addEditCostcenterFrstRowFrstColumn;
 * 
 * @FindBy(xpath = "//span[@id='database-asc']") public WebElement
 * focusTrueDatabaseOnAddEDitScreen;
 * 
 * public WebElement getaddEditCostcenterFrstRowFrstColumn() { return
 * addEditCostcenterFrstRowFrstColumn; }
 * 
 * @FindBy(xpath = "//tbody[@data-testid='mappedCostcentersTB']/tr[1]/td[1]")
 * public WebElement addEditdbFrstRowFrstColumn;
 * 
 * public WebElement getaddEditdbFrstRowFrstColumn() { return
 * addEditdbFrstRowFrstColumn; }
 * 
 * public WebElement getsubDeptMandatoryFieldMsg() { return
 * subDeptMandatoryFieldMsg; }
 * 
 * @FindBy(xpath = "//div[@aria-describedby='client-snackbar']") public
 * WebElement snackbarLoadedSuccessfully;
 * 
 * @FindBy(xpath = "//span[@id='client-snackbar']") public WebElement
 * snackbarcreatedSuccessfully;
 * 
 * @FindBy(xpath = "//p[@data-testid='pseudoFlagLabel']") public WebElement
 * txtPseudoFlag;
 * 
 * @FindBy(xpath = "//span[@data-testid='pseudoFlagSwitch']") public WebElement
 * swtchPseudoFlag;
 * 
 * @FindBy(xpath = "//p[@data-testid='pseudoDbLabel']") public WebElement
 * pseudoDbLabel;
 * 
 * @FindBy(xpath = "//div[@id='select-database']") public WebElement
 * dropdownClick;
 * 
 * @FindBy(xpath = "//div[@id='menu-database']//li") public List<WebElement>
 * PseudoDBList;
 * 
 * @FindBy(xpath = "//div[@id='select-database']") public WebElement
 * selectDBField;
 * 
 * public WebElement getloadCostCenterBtn() { return loadCostCenterBtn; }
 * 
 * public WebElement getAlertTxt() { return alertTxt; }
 * 
 * public WebElement getsnackbarLoadedSuccessfully() { return
 * snackbarLoadedSuccessfully; }
 * 
 * public WebElement getHdrCostcenters() { return hdrCostcenters; }
 * 
 * public WebElement getBackToManageCostCenter() { return
 * backToManageCostCenter; }
 * 
 * public void validateAddEditCostCenterScreen() { if
 * (AddEditCostCenterScreen.isDisplayed()) extentTest.log(Status.PASS,
 * "Manage Add edit cost center screen is displayed"); }
 * 
 * public String EnterCostCenterDetails(String testcaseName, String sheetName)
 * throws InterruptedException {
 * excelValidations.setCostCenterValues(testcaseName, sheetName); String
 * costCenterValue = excelValidations.getCostCenter();
 * businessUtilities.isDisplayed(costCenterTxtFld); Thread.sleep(1000);
 * costCenterTxtFld.sendKeys(excelValidations.getCostCenter(), Keys.ENTER);
 * businessUtilities.isDisplayed(subDepartmentTxtFld);
 * subDepartmentTxtFld.sendKeys(excelValidations.getSubDepartment(),
 * Keys.ENTER); businessUtilities.isDisplayed(departmentTxtFld);
 * departmentTxtFld.sendKeys(excelValidations.getDepartment(), Keys.ENTER);
 * businessUtilities.isDisplayed(plantTxtFld);
 * plantTxtFld.sendKeys(excelValidations.getPlant(), Keys.ENTER); //
 * descriptionTxtFld.sendKeys(excelValidations.getDescription(), //
 * Keys.ENTER);//Due to changes in sprint 119,this is commented //
 * descriptionTxtFld.sendKeys(((excelValidations.getDescription()!=null)?
 * excelValidations.getDescription():"")); // //rosmols
 * businessUtilities.isDisplayed(descriptionTxtFld);
 * descriptionTxtFld.sendKeys(excelValidations.getDescription()); return
 * costCenterValue; }
 * 
 * public String EnterCostCenterDetailsLatest(String testcaseName) throws
 * InterruptedException {
 * excelValidations.setCostCenterValuesUpdated(testcaseName); String
 * costCenterValue = excelValidations.getCostCenter();
 * businessUtilities.isDisplayed(costCenterTxtFld); Thread.sleep(1000);
 * costCenterTxtFld.sendKeys(excelValidations.getCostCenter(), Keys.ENTER);
 * businessUtilities.isDisplayed(subDepartmentTxtFld);
 * subDepartmentTxtFld.sendKeys(excelValidations.getSubDepartment(),
 * Keys.ENTER); businessUtilities.isDisplayed(departmentTxtFld);
 * departmentTxtFld.sendKeys(excelValidations.getDepartment(), Keys.ENTER);
 * businessUtilities.isDisplayed(plantTxtFld);
 * plantTxtFld.sendKeys(excelValidations.getPlant(), Keys.ENTER);
 * businessUtilities.isDisplayed(descriptionTxtFld);
 * descriptionTxtFld.sendKeys(excelValidations.getDescription()); return
 * costCenterValue; }
 * 
 * public void enterSelectedDetailsinCostcenters(String testcaseName, String
 * sheetName) throws InterruptedException { Thread.sleep(2000);
 * costCenterTxtFld.sendKeys(excelValidations.getSearchValues(), Keys.ENTER);
 * Thread.sleep(2000);
 * 
 * }
 * 
 * public void EnterCostCenterDetailsHandlingNullValues(String testcaseName,
 * String sheetName) throws InterruptedException {
 * excelValidations.setCostCenterValues(testcaseName, sheetName);
 * costCenterTxtFld.sendKeys(excelValidations.getCostCenter(), Keys.ENTER);
 * subDepartmentTxtFld.sendKeys( ((excelValidations.getSubDepartment() != null)
 * ? excelValidations.getSubDepartment() : ""), Keys.ENTER);
 * departmentTxtFld.sendKeys(((excelValidations.getDepartment() != null) ?
 * excelValidations.getDepartment() : ""), Keys.ENTER);
 * plantTxtFld.sendKeys(((excelValidations.getPlant() != null) ?
 * excelValidations.getPlant() : ""), Keys.ENTER); descriptionTxtFld
 * .sendKeys(((excelValidations.getDescription() != null) ?
 * excelValidations.getDescription() : ""));
 * 
 * }
 * 
 * public void validateModifyUserAndDate() { if (modifyDate.isDisplayed() &&
 * modifyUser.isDisplayed()) { if (modifyDate.getText().isEmpty() &&
 * modifyUser.getText().isEmpty()) { extentTest.log(Status.PASS,
 * "Modified Date and Modified UserName is empty"); } else
 * extentTest.log(Status.FAIL, "Modified Date and Modified UserName is empty");
 * 
 * }
 * 
 * }
 * 
 * public void enableDatabasefromMappedDatabasesinAddEditCCPage() throws
 * InterruptedException { if (hdrMappedDatabases.isDisplayed()) { Actions
 * builder1 = new Actions(driver); JavascriptExecutor js = (JavascriptExecutor)
 * driver; List<WebElement> dbcountBeforeLoading = driver
 * .findElements(By.xpath("//tbody[@data-testid='mappedDatabasesTB']/tr")); for
 * (int i = 0; i < dbcountBeforeLoading.size(); i++) { WebElement lastElement =
 * driver
 * .findElement(By.xpath("//tbody[@data-testid='mappedDatabasesTB']//tr[last()]"
 * )); JavascriptExecutor js1 = (JavascriptExecutor) driver;
 * js1.executeScript("arguments[0].scrollIntoView();", lastElement);
 * builder1.moveToElement(lastElement).build().perform();
 * 
 * }
 * 
 * List<WebElement> dbcount = driver.findElements(By.xpath("//tr/td[1]")); // 2
 * for (int i = 1; i <= dbcount.size(); i++) {
 * 
 * WebElement columnValue = driver.findElement(By.xpath("//tr[" + i +
 * "]/td[1]")); if (columnValue.getText().equals("ZA2XAP08 DUMMY")) { String
 * dbName1 = columnValue.getText(); WebElement checkbox = driver
 * .findElement(By.xpath("//tr[@data-testid='mappedDatabases'][" + i +
 * "]/td[3]")); WebElement checkspecific =
 * driver.findElement(By.xpath("//tr[@data-testid='mappedDatabases'][" + i +
 * "]/td[3] //span[@data-testid='mappedDatabasesCB']")); String className =
 * checkspecific.getAttribute("class"); if (!className.contains("checked")) {
 * builder1.moveToElement(checkbox).build().perform();
 * builder1.moveToElement(checkbox).click(checkbox); builder1.perform();
 * extentTest.log(Status.PASS, dbName1 + " Database is enabled successfully"); }
 * else extentTest.log(Status.PASS, dbName1 + " Database is already enabled");
 * 
 * } if (columnValue.getText().equals("TK6XEP41")) { String dbName2 =
 * columnValue.getText(); WebElement checkbox = driver
 * .findElement(By.xpath("//tr[@data-testid='mappedDatabases'][" + i +
 * "]/td[3]")); WebElement checkspecific =
 * driver.findElement(By.xpath("//tr[@data-testid='mappedDatabases'][" + i +
 * "]/td[3] //span[@data-testid='mappedDatabasesCB']")); String className =
 * checkspecific.getAttribute("class"); if (!className.contains("checked")) {
 * builder1.moveToElement(checkbox).build().perform();
 * builder1.moveToElement(checkbox).click(checkbox); builder1.perform();
 * extentTest.log(Status.PASS, dbName2 + " Database is enabled successfully"); }
 * 
 * else extentTest.log(Status.PASS, dbName2 + " Database is already enabled"); }
 * } } else {
 * 
 * extentTest.log(Status.FAIL, "Database is NOT enabled");
 * 
 * } }
 * 
 * public void ClickOnSaveButton() { JavascriptExecutor js =
 * (JavascriptExecutor) driver;
 * js.executeScript("arguments[0].scrollIntoView()", saveCostCenterBtn); if
 * (businessUtilities.isDisplayed(saveCostCenterBtn)) { // &&
 * pageActions.isClickable(saveCostCenterBtn) try {
 * businessUtilities.ClickElement(saveCostCenterBtn);
 * extentTest.log(Status.PASS, "Save button is clicked successfully"); } catch
 * (Exception e) { saveCostCenterBtn.click(); extentTest.log(Status.PASS,
 * "Save button is clicked successfully"); }
 * 
 * } else { extentTest.log(Status.FAIL, "Save button is not visible"); } }
 * 
 * public void clickOnBackToManageCostcenter() { if
 * (businessUtilities.isDisplayed(backToManageCostCenter)) { try {
 * pageActions.clickOnElement(backToManageCostCenter);
 * extentTest.log(Status.PASS,
 * "ManageCostCenter button is clicked successfully"); } catch (Exception e) {
 * e.printStackTrace(); } } else try {
 * pageActions.clickOnElement(backToManageCostCenter);
 * extentTest.log(Status.PASS,
 * "ManageCostCenter button is clicked successfully"); } catch (Exception e) {
 * e.printStackTrace(); } }
 * 
 * public void enterCostcenterData(String testcaseName) {
 * excelValidations.setCostCenterData(testcaseName);
 * costCenterTxtFld.sendKeys(excelValidations.getCostCenter(), Keys.ENTER); }
 * 
 * public void setCostCenter(String costCenter) {
 * costCenterTxtFld.sendKeys(costCenter, Keys.ENTER); }
 * 
 * public void setSubDepartment(String subDeparntent) {
 * subDepartmentTxtFld.sendKeys(subDeparntent, Keys.ENTER); }
 * 
 * public void setDepartment(String deparntent) {
 * departmentTxtFld.sendKeys(deparntent, Keys.ENTER); }
 * 
 * public void setPlant(String plant) { plantTxtFld.sendKeys(plant, Keys.ENTER);
 * }
 * 
 * public boolean isPlantValidationMsgDisplayed() { if
 * (plantMandatoryFieldMsg.isDisplayed()) return true; else return false; }
 * 
 * public void fieldColorValidation() {
 * 
 * By costcenter = By.xpath(fieldColorValidation.replaceAll("dummy",
 * "Costcenter")); String plant = fieldColorValidation.replaceAll("dummy",
 * "Sub Department"); String department =
 * fieldColorValidation.replaceAll("dummy", "Department"); String subDepartment
 * = fieldColorValidation.replaceAll("dummy", "Plant"); String description =
 * fieldColorValidation.replaceAll("dummy", "Description");
 * 
 * 
 * if (fieldColorValidation.isDisplayed()) extentTest.log(Status.PASS,
 * "costcenter color is changed and dirty check validation is successful"); else
 * extentTest.log(Status.FAIL,
 * "costcenter color is not changed and dirty check validation is failed");
 * 
 * 
 * if (driver.findElement(By.xpath(plant)).isDisplayed())
 * extentTest.log(Status.PASS,
 * "plant color is changed and dirty check validation is successful"); else
 * extentTest.log(Status.FAIL,
 * "plant color is not changed and dirty check validation is failed");
 * 
 * if (driver.findElement(By.xpath(department)).isDisplayed())
 * extentTest.log(Status.PASS,
 * "department color is changed and dirty check validation is successful" );
 * else extentTest.log(Status.FAIL,
 * "department color is not changed and dirty check validation is failed" );
 * 
 * if (driver.findElement(By.xpath(subDepartment)).isDisplayed())
 * extentTest.log(Status.PASS,
 * "subDepartment color is changed and dirty check validation is successful" );
 * else extentTest.log(Status.FAIL,
 * "subDepartment color is not changed and dirty check validation is failed" );
 * 
 * if (driver.findElement(By.xpath(description)).isDisplayed())
 * extentTest.log(Status.PASS,
 * "description color is changed and dirty check validation is successful" );
 * else extentTest.log(Status.FAIL,
 * "description color is not changed and dirty check validation is failed" );
 * 
 * }
 * 
 * public void clickOnReset() { try {
 * businessUtilities.ClickElement(resetCostCenterBtn);
 * extentTest.log(Status.PASS, "Reset button is clicked successfully"); //
 * resetCostCenterBtn.click(); } catch (Exception e) { e.getStackTrace();
 * extentTest.log(Status.FAIL, "Reset button is not clicked"); } }
 * 
 * public void clickOnDeleteBtn() {
 * businessUtilities.ClickElement(deleteCostCenterBtn); //
 * deleteCostCenterBtn.click(); }
 * 
 * public void resetValuesValidation() { if
 * (costCenterTxtFld.getText().isEmpty() &&
 * subDepartmentTxtFld.getText().isEmpty() &&
 * departmentTxtFld.getText().isEmpty() && plantTxtFld.getText().isEmpty() &&
 * descriptionTxtFld.getText().isEmpty()) extentTest.log(Status.PASS,
 * "reset validation is successful"); else extentTest.log(Status.FAIL,
 * "reset validation is not successful"); }
 * 
 * public void resetValuesValidationOnClickOfNoButton() { if
 * (costCenterTxtFld.getAttribute("value").trim().equals(excelValidations.
 * getCostCenter().trim()) &&
 * subDepartmentTxtFld.getAttribute("value").trim().equals(excelValidations.
 * getSubDepartment().trim()) &&
 * departmentTxtFld.getAttribute("value").trim().equals(excelValidations.
 * getDepartment().trim()) &&
 * plantTxtFld.getAttribute("value").trim().equals(excelValidations.getPlant().
 * trim()) &&
 * descriptionTxtFld.getAttribute("value").trim().equals(excelValidations.
 * getDescription().trim())) extentTest.log(Status.PASS,
 * "All fields are not cleared"); else extentTest.log(Status.FAIL,
 * "Values are not cleared"); }
 * 
 * public void validateCostCenterInputField(String testData, By webElement) {
 * costCenterTxtFld.sendKeys(testData, Keys.ENTER); if
 * (pageActions.isElementExistByLocator(webElement, 20))
 * extentTest.log(Status.PASS, testData + " validate message is displayed");
 * else extentTest.log(Status.FAIL, testData +
 * " validate message is not displayed");
 * 
 * }
 * 
 * String[] costCenterList = null; String[] subDepartmentList = null; String[]
 * departmentList = null; String[] plantList = null;
 * 
 * public void setData(String testCaseName, String sheetName) {
 * excelValidations.setCostCenterValues(testCaseName, sheetName); costCenterList
 * = excelValidations.getCostCenter().split(";"); subDepartmentList =
 * excelValidations.getSubDepartment().split(";"); departmentList =
 * excelValidations.getDepartment().split(";"); plantList =
 * excelValidations.getPlant().split(";"); }
 * 
 * public void setTextFields(int i) { setCostCenter(costCenterList[i]);
 * setDepartment(departmentList[i]); setSubDepartment(subDepartmentList[i]);
 * setPlant(plantList[i]); }
 * 
 * public void setDatahandleSingleAndMultipleData(String testCaseName, String
 * sheetName) { excelValidations.setCostCenterValues(testCaseName, sheetName);
 * costCenterList = excelValidations.getCostCenter().split(";"); costCenterList
 * = excelValidations.getCostCenter().split(";"); subDepartmentList =
 * excelValidations.getSubDepartment().split(";"); departmentList =
 * excelValidations.getDepartment().split(";"); plantList =
 * excelValidations.getPlant().split(";"); subDepartmentTxtFld.sendKeys(
 * ((excelValidations.getSubDepartment() != null) ?
 * excelValidations.getSubDepartment() : ""), Keys.ENTER); }
 * 
 * String tableHeader =
 * "//table/thead[@data-testid='manageCostcenterTblTH']/tr/th";
 * 
 * String tableBody =
 * "//tbody[@data-testid='manageCostcenterTblTB']/tr/td[index]";
 * 
 * public void validateSavedCostCenter() throws InterruptedException { if
 * (businessUtilities .convertListWebElementsIntoListOfString(
 * businessUtilities.validateDataTable("Costcenter", By.xpath(tableHeader),
 * tableBody)) .equals(Arrays.asList(costCenterList))) {
 * extentTest.log(Status.PASS, ":Costcenter is saved successfully"); } else {
 * extentTest.log(Status.FAIL, ":Costcenter is not saved successfully"); } if
 * (businessUtilities .convertListWebElementsIntoListOfString(
 * businessUtilities.validateDataTable("Sub Department", By.xpath(tableHeader),
 * tableBody)) .equals(Arrays.asList(subDepartmentList))) {
 * extentTest.log(Status.PASS, ":Sub Department is saved successfully"); } else
 * { extentTest.log(Status.FAIL, ":Sub Department is not saved successfully"); }
 * if (businessUtilities .convertListWebElementsIntoListOfString(
 * businessUtilities.validateDataTable("Department", By.xpath(tableHeader),
 * tableBody)) .equals(Arrays.asList(departmentList))) {
 * extentTest.log(Status.PASS, ":Department is saved successfully"); } else {
 * extentTest.log(Status.FAIL, ":Department is not saved successfully"); } }
 * 
 * public void clickOnSVGUIcon() throws InterruptedException { int rowNum = 0;
 * List<WebElement> rows =
 * driver.findElements(By.xpath("//tbody[@data-testid='mappedDatabasesTB']/tr"))
 * ; int i = 1; for (WebElement row : rows) { List<WebElement> cells =
 * row.findElements(By.tagName("td")); if
 * (cells.get(0).getText().equals(excelValidations.getDatabase().trim())) {
 * rowNum = i; break; } i++; } String checkBoxXpath =
 * "//tbody[@data-testid='mappedDatabasesTB']/tr[index]/td[3]/span[@data-testid='mappedDatabasesCB']//*[name()='svg']//*[local-name()='path']";
 * WebElement svgObject =
 * driver.findElement(By.xpath(checkBoxXpath.replace("index",
 * String.valueOf(rowNum)))); Actions builder = new Actions(driver);
 * builder.click(svgObject).build().perform(); Thread.sleep(5000);
 * 
 * }
 * 
 * String checkedData =
 * "//tbody[@data-testid='mappedDatabasesTB']/tr[index]/td[3]/span[@data-testid='mappedDatabasesCB']";
 * 
 * public void validateCheckedData() {
 * 
 * By checkedData= By.xpath(
 * "//tbody[@data-testid='mappedDatabasesTB']/tr[]/td[3]/span[@data-testid='mappedDatabasesCB']"
 * ); WebElement svgObject = driver.findElement(checkedData); String
 * styleChecked= svgObject.getAttribute("class");
 * System.out.println("############################## "+styleChecked);
 * 
 * int rowNum = 0; List<WebElement> rows = driver.findElements(By.xpath(
 * "//tbody[@data-testid='editatabletableTB']/tr")); int i = 1; for (WebElement
 * row : rows) {
 * 
 * List<WebElement> cells = row.findElements(By.tagName("td")); if
 * (cells.get(0).getText().equals(excelValidations.getManageRoleName(). trim()))
 * { rowNum = i; break; } i++; } String deleteXpath =
 * "//tbody[@data-testid='editatabletableTB']/tr[index]/td[5]//*[name()='svg'][@data-testid='deleteRecordIcn']//*[local-name()='path']";
 * WebElement svgObject =
 * driver.findElement(By.xpath(deleteXpath.replace("rowNum",
 * String.valueOf(rowNum))));
 * 
 * 
 * int PostionOfColumn = 0; try { Wait<WebDriver> waitForElement = new
 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60000))
 * .pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
 * .ignoring(StaleElementReferenceException.class);
 * 
 *//*********************
	 * LOCATE THE COLUMN POSITION
	 **********************/
/*
 * List<WebElement> rows = waitForElement.until(ExpectedConditions
 * .visibilityOfAllElementsLocatedBy(By.xpath(
 * "//tbody[@data-testid='mappedDatabasesTB']/tr")));
 * 
 * int rowNum = 0; int i = 1; for (WebElement row : rows) {
 * 
 * List<WebElement> cells = row.findElements(By.tagName("td")); if
 * (cells.get(0).getText().equals(excelValidations.getDatabase().trim())) {
 * rowNum = i; break; } i++; } String mappedDBXpath =
 * checkedData.replace("index", String.valueOf(rowNum));
 * 
 * List<WebElement> checkedBoxes = waitForElement
 * .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
 * mappedDBXpath))); boolean flag = false; for (WebElement row : checkedBoxes) {
 * if (row.getAttribute("class").contains("Mui-checked ")) { flag = true; } } if
 * (flag) { extentTest.log(Status.PASS, "Correct Costcenter is mapped to DB"); }
 * else { extentTest.log(Status.FAIL, "Incorrect CostCenter Database mapping");
 * } } catch (Exception ex) { ex.printStackTrace(); }
 * 
 * }
 * 
 * public void clickOnAlertCancel() { if ((alertOnCancel.isDisplayed()) &&
 * pageActions.isClickable(alertOnCancel)) { try {
 * pageActions.clickOnElement(alertOnCancel); extentTest.log(Status.PASS,
 * "Cancel button on the Alert pop-up is clicked successfully"); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * } else alertOnCancel.click();
 * 
 * }
 * 
 * @FindBy(xpath = "//*[contains(text(),'Cancel')]") public WebElement
 * alertOnCancelButton;
 * 
 * public void clickOnAlertCancelPopup() { if
 * ((alertOnCancelButton.isDisplayed()) &&
 * pageActions.isClickable(alertOnCancelButton)) { try {
 * pageActions.clickOnElement(alertOnCancelButton); extentTest.log(Status.PASS,
 * "Cancel button on the Alert pop-up is clicked successfully"); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * } else alertOnCancelButton.click();
 * 
 * }
 * 
 * public void clickOnYesAlert() { if ((alertOnYes.isDisplayed()) &&
 * pageActions.isClickable(alertOnYes)) { try {
 * pageActions.clickOnElement(alertOnYes); extentTest.log(Status.PASS,
 * "Yes button on the Alert pop-up is clicked successfully"); } catch (Exception
 * e) { e.printStackTrace(); }
 * 
 * } else extentTest.log(Status.FAIL, "Yes button is not clicked on popup"); }
 * 
 * public void clickOnNoAlert() { if ((alertOnYes.isDisplayed()) &&
 * pageActions.isClickable(alertOnYes)) { try {
 * pageActions.clickOnElement(alertOnYes); extentTest.log(Status.PASS,
 * "Yes button on the Alert pop-up is clicked successfully"); } catch (Exception
 * e) { e.printStackTrace(); }
 * 
 * } else // alertOnYes.click(); alertYES.click();
 * 
 * }
 * 
 * public void enterCostCenterValues() throws InterruptedException { int i =
 * costCenterList.length; int j = 0; while (i != 0) {
 * setCostCenter(costCenterList[j]); Thread.sleep(1000);
 * setDepartment(departmentList[j]); Thread.sleep(1000);
 * setSubDepartment(subDepartmentList[j]); Thread.sleep(1000);
 * setPlant(plantList[j]); Thread.sleep(1000); //
 * setDescription(descriptionValues[j]); ClickOnSaveButton();
 * Thread.sleep(3000); clickOnYesAlert(); Thread.sleep(3000); clickOnReset();
 * j++; i--;
 * 
 * } }
 * 
 * public String clearCostCenterDetailsNEnterNewData(String testcaseName, String
 * sheetName) throws InterruptedException {
 * excelValidations.setCostCenterValues(testcaseName, sheetName); int
 * randnMumber = ThreadLocalRandom.current().nextInt(0, 999);
 * replaceValue(costCenterTxtFld, excelValidations.getCostCenter() +
 * randnMumber); String newcc = costCenterTxtFld.getAttribute("value");
 * replaceValue(subDepartmentTxtFld, excelValidations.getSubDepartment());
 * replaceValue(departmentTxtFld, excelValidations.getDepartment());
 * replaceValue(plantTxtFld, excelValidations.getPlant());
 * replaceValue(descriptionTxtFld, excelValidations.getDescription()); return
 * newcc; }
 * 
 * private void replaceValue(WebElement costCentertxtFieldValues, String
 * excelValue) throws InterruptedException { String value =
 * costCentertxtFieldValues.getAttribute("value"); if (value != "") {
 * costCentertxtFieldValues.sendKeys(Keys.CONTROL, Keys.chord("a")); // select
 * all text in textbox costCentertxtFieldValues.sendKeys(Keys.BACK_SPACE); //
 * delete it costCentertxtFieldValues.clear(); // newly added if
 * (!costCentertxtFieldValues.getAttribute("data-testid").equals(
 * "description_txt_fld")) costCentertxtFieldValues.sendKeys(excelValue,
 * Keys.ENTER); // enter new text else
 * costCentertxtFieldValues.sendKeys(excelValue); // enter new text
 * 
 * } else { extentTest.log(Status.FAIL, value + "Field is not cleared");
 * Assert.assertEquals("Costcenters Field is not cleared",
 * "Costcenters Fields should be cleared"); }
 * 
 * }
 * 
 * public boolean validateConfirmAlertSaveChangesTo(String testcaseName, String
 * sheetName) throws Exception { String costCenter =
 * excelValidations.getCostCenter(); String saveChangesText =
 * alertTxtSaveChanges.getText();
 * pageActions.waitUntilLoadingSymbolAppearsPolling(alertTxtSaveChanges, 0, 60);
 * if (businessUtilities.isDisplayed(alertTxtSaveChanges) &&
 * businessUtilities.isDisplayed(alertTxtNO) &&
 * businessUtilities.isDisplayed(alertOnYes)) {
 * excelValidations.setCostCenterValues(testcaseName, sheetName); try {
 * 
 * String costcentervalue[] = saveChangesText.split(" "); String ccvalue =
 * costcentervalue[4]; if (costCenter.equalsIgnoreCase(ccvalue))
 * extentTest.log(Status.PASS,
 * "Changes are done successfully for the costcenter " + costCenter); } catch
 * (Exception e) { businessUtilities.waitForPageLoad(driver); if
 * (pageActions.isElementExist(alertTxtSaveChanges, 20) &&
 * (businessUtilities.isDisplayed(alertTxtSaveChanges) &&
 * businessUtilities.isDisplayed(alertTxtNO) &&
 * businessUtilities.isDisplayed(alertOnYes))) { extentTest.log(Status.PASS,
 * "Changes are done successfully for the costcenter " + costCenter); return
 * true; }
 * 
 * } return false; } return false; }
 * 
 * public boolean validateConfirmAlertSaveChangesToCostcenter(String
 * testcaseName, String sheetName) throws Exception { String costCenter =
 * excelValidations.getCostCenter(); String saveChangesText =
 * alertTxtSaveChanges.getText(); Thread.sleep(10000); if
 * (businessUtilities.isDisplayed(alertTxtSaveChanges) &&
 * businessUtilities.isDisplayed(alertTxtNO) &&
 * businessUtilities.isDisplayed(alertOnYes)) {
 * excelValidations.setCostCenterValues(testcaseName, sheetName);
 * Thread.sleep(3000); try { Assert.assertEquals(saveChangesText,
 * "Save changes to Costcenter"); extentTest.log(Status.PASS,
 * "Changes are done successfully for the costcenter " + costCenter); } catch
 * (Exception e) { businessUtilities.waitForPageLoad(driver); if
 * (pageActions.isElementExist(alertTxtSaveChanges, 20) &&
 * (businessUtilities.isDisplayed(alertTxtSaveChanges) &&
 * businessUtilities.isDisplayed(alertTxtNO) &&
 * businessUtilities.isDisplayed(alertOnYes))) { extentTest.log(Status.PASS,
 * "Changes are done successfully for the costcenter " + costCenter); return
 * true; }
 * 
 * } return false; } return false; }
 * 
 * public void validateErrorMessageOfCostCenterAlreadyInSystem() { if
 * ((businessUtilities.isDisplayed(alertTxtAlreadyInSystem))) {
 * extentTest.log(Status.PASS, alertTxtAlreadyInSystem.getText() +
 * "Alert is displayed"); String txtYes = alertTxtYES.getText();
 * alertTxtYES.click(); extentTest.log(Status.PASS, txtYes +
 * " is clicked on the alert");
 * 
 * } else { extentTest.log(Status.INFO,
 * "Alert is not visible, new entry of cc combinations "); }
 * 
 * }
 * 
 * public void
 * verifyLoadCurrentConfirmationMessageInAddEditCostcentersScreen(String cc)
 * throws InterruptedException// String { String cccaps = cc.toUpperCase();
 * WebDriverWait w = new WebDriverWait(driver, Duration.ofMinutes(1));
 * w.until(ExpectedConditions.visibilityOf(alertTxt)); if
 * (businessUtilities.isDisplayed(alertTxt) &&
 * businessUtilities.isDisplayed(alertTxtNO) &&
 * businessUtilities.isDisplayed(alertTxtYES) &&
 * businessUtilities.isDisplayed(costcenterAlreadyExistsConfirmationMsg))
 * 
 * { String msg = costcenterAlreadyExistsConfirmationMsg.getText();
 * extentTest.log(Status.PASS, msg + " is displayed"); Thread.sleep(5000);
 * 
 * } else
 * 
 * extentTest.log(Status.SKIP,
 * "deleteDatabaseConfirmationMsg is not displayed,it is newly added"); }
 * 
 * public void validateErrorMessageWhenPlantFieldIsEmpty() throws Exception { if
 * (plantMandatoryFieldMsg.isDisplayed()) // //txtValueHasToBePresentMsg {
 * pageActions.waitUntilLoadingSymbolAppearsPolling(subDeptMandatoryFieldMsg, 1,
 * 60); String subDeptErrorText = subDeptMandatoryFieldMsg.getText(); String
 * deptErrorText = deptMandatoryFieldMsg.getText(); String plantErrorText =
 * plantMandatoryFieldMsg.getText(); Assert.assertEquals(subDeptErrorText,
 * "value has to be present"); Assert.assertEquals(deptErrorText,
 * "value has to be present"); Assert.assertEquals(plantErrorText,
 * "value has to be present"); extentTest.log(Status.PASS, "\"" + plantErrorText
 * + "\"" +
 * " Error message is displayed successfully when SubDepartment,Department and Plant Field is empty "
 * ); } else extentTest.log(Status.FAIL,
 * "Error message is not displayed as expected");
 * 
 * }
 * 
 * public void validateMappedDatabaseTable() { if
 * (hdrMappedDatabases.isDisplayed()) { List<String> predefinedHeader = new
 * ArrayList(); List<String> headerFromUI = new ArrayList();
 * predefinedHeader.add("Database"); predefinedHeader.add("Description");
 * predefinedHeader.add("Selected"); int a = predefinedHeader.size();
 * 
 * for (WebElement mpcn : mappedDatabasesColumnNames) { String
 * mappedDdHeaderColumn = mpcn.getText();
 * 
 * headerFromUI.add(mappedDdHeaderColumn); int b = headerFromUI.size(); }
 * 
 * for (int i = 0; i < a; i++) { if
 * (predefinedHeader.get(i).equals(headerFromUI.get(i)))
 * 
 * { extentTest.log(Status.PASS,
 * "Header column matches with expected and displayed are" + headerFromUI.get(i)
 * + ","); } else
 * 
 * extentTest.log(Status.PASS, "Header column doesn't match with expected"); }
 * 
 * } else
 * 
 * extentTest.log(Status.FAIL,
 * "Mapped Databases table is not displayed as expected");
 * 
 * }
 * 
 * public void validateMappedDatabaseTableUpdated() { if
 * (hdrMappedDatabases.isDisplayed()) // //txtValueHasToBePresentMsg {
 * List<WebElement> mappedDatabasesColumnNames =
 * driver.findElements(By.xpath("//tr/th")); int mDColSize =
 * mappedDatabasesColumnNames.size(); List<String> predefinedHeader = new
 * ArrayList(); List<String> headerFromUI = new ArrayList();
 * predefinedHeader.add("Database"); predefinedHeader.add("Description");
 * predefinedHeader.add("Selected"); int a = predefinedHeader.size(); for (int i
 * = 0; i < a; i++) { WebElement valueFromUI =
 * mappedDatabasesColumnNames.get(0); String mappedDdHeaderColumntext =
 * valueFromUI.getText(); // from UI headerFromUI.add(mappedDdHeaderColumntext);
 * 
 * if (predefinedHeader.get(i).equals(headerFromUI.get(i)))
 * 
 * { extentTest.log(Status.PASS,
 * "Header column matches with expected and displayed are" + headerFromUI.get(i)
 * + ","); } else
 * 
 * extentTest.log(Status.FAIL, "Header column doesn't match with expected"); } }
 * else
 * 
 * extentTest.log(Status.FAIL,
 * "Mapped Databases table is not displayed as expected");
 * 
 * }
 * 
 * public void verifytheDatabaseAscendingArrowMouseOverAndClick() throws
 * InterruptedException { if (focusFalseDatabase.isDisplayed() &
 * btnAscDatabase.isDisplayed()) { extentTest.log(Status.PASS,
 * "Database Ascending Arrow is displayed"); } else { Actions actions = new
 * Actions(driver); actions.moveToElement(focusFalseDatabase).click().perform();
 * extentTest.log(Status.FAIL, "Database Ascending Arrow is  not displayed"); }
 * }
 * 
 * public void clickMappedDatabasescolumnValuesForAscendingOrder(WebElement
 * focusFalseDescription123, WebElement btnAscDescription123) throws
 * InterruptedException { try { Actions actions = new Actions(driver);
 * actions.moveToElement(focusFalseDescription123).click().perform(); String
 * hdrTxt = btnAscDescription123.getText(); extentTest.log(Status.PASS, hdrTxt +
 * " Ascending Arrow is displayed"); } catch (Exception e) {
 * extentTest.log(Status.FAIL, "Ascending Arrow not displayed"); } }
 * 
 * public void clickAscendingOrderOfDDS() throws InterruptedException {
 * PageFactoryManageCostCenterScreen a = new
 * PageFactoryManageCostCenterScreen(driver); a.columnValuesInAscending(1); //
 * clickMappedDatabasescolumnValuesForAscendingOrder(focusFalseDatabase,
 * btnAscDatabase);
 * clickMappedDatabasescolumnValuesForAscendingOrder(focusFalseDescription,
 * btnAscDescription); a.columnValuesInAscending(2);
 * 
 * }
 * 
 * public void
 * verifytheColumnHeaderMouseOverAndClickForDescendingOrder(WebElement
 * focusFalseDescription, WebElement descLocator) { if
 * (hdrMappedDatabases.isDisplayed()) { Actions actions = new Actions(driver);
 * actions.moveToElement(focusFalseDescription).click().perform();
 * actions.moveToElement(focusFalseDescription).click().perform();
 * descLocator.isDisplayed();
 * 
 * } else extentTest.log(Status.FAIL, focusFalseDescription +
 * "Description Focus is not displayed"); }
 * 
 * public void clickDescendingOrderForDescSDDeptPlant() throws
 * InterruptedException { PageFactoryManageCostCenterScreen a = new
 * PageFactoryManageCostCenterScreen(driver); //
 * verifytheColumnHeaderMouseOverAndClickForDescendingOrder(focusFalseDatabase,
 * btnDscDatabase);// ,btnAscDescArrow,btnDescdescription);
 * a.costCentercolumnValuesinDescending(1);
 * verifytheColumnHeaderMouseOverAndClickForDescendingOrder(
 * focusFalseDescription, btnDscDescription);//
 * ,btnAscSubDeptArrow,btnDescSubDept); a.costCentercolumnValuesinDescending(2);
 * 
 * }
 * 
 * public void searchValueusingFilterOptionOnMappedDatabaseScreen() throws
 * InterruptedException { getSearchResultsOfGivenInput(
 * "TestCase6_ValidateFilterOptionOfMappedDatabasesInAddEditCostcenterScreenForDB",
 * "ManageCostcenter_EN", 1, FilterOptionDatabase); // cc
 * getSearchResultsOfGivenInput(
 * "TestCase6_ValidateFilterOptionOfMappedDatabasesInAddEditCostcenterScreenForDesc",
 * "ManageCostcenter_EN", 2, FilterOptionDescription); // desc }
 * 
 * public void getSearchResultsOfGivenInput(String testcaseName, String
 * sheetName, int j, WebElement locator) throws InterruptedException {
 * PageFactoryManageCostCenterScreen a = new
 * PageFactoryManageCostCenterScreen(driver); if
 * (hdrMappedDatabases.isDisplayed())// & textonScreen.isDisplayed()) {
 * excelValidations.setCostCenterValues(testcaseName, sheetName); String Search
 * = excelValidations.getSearch(); String SearchValue =
 * excelValidations.getSearchValues().toUpperCase(); List<WebElement> colSize =
 * driver.findElements(By.xpath("//tbody/tr/td[" + j + "]")); List<String>
 * valueFromSearchList = new ArrayList(); for (WebElement value : colSize) {
 * String text = value.getText().toUpperCase(); if
 * ((text.toUpperCase()).contains(SearchValue.toUpperCase())) // serach in list
 * { valueFromSearchList.add(text); } } // From UI
 * locator.sendKeys(SearchValue);
 * 
 * List<WebElement> colSizematches =
 * driver.findElements(By.xpath("//tbody/tr/td[" + j + "]")); List<String>
 * valueFromUIFilterList = new ArrayList<String>(); List<String>
 * valueFromUIFilterListDuplicate = new ArrayList<String>(); for (WebElement
 * valuematches : colSizematches) { String textmatches = valuematches.getText();
 * if ((textmatches.toUpperCase()).contains(SearchValue.toUpperCase())) {
 * 
 * valueFromUIFilterList.add(textmatches);
 * valueFromUIFilterListDuplicate.add(textmatches); } }
 * 
 * valueFromSearchList.equals(valueFromUIFilterList); locator.clear();
 * locator.sendKeys(Keys.CONTROL + "a"); locator.sendKeys(Keys.DELETE);
 * extentTest.log(Status.PASS, "The matching values of " + SearchValue +
 * " using filter option in " + Search + " are :" +
 * valueFromUIFilterListDuplicate); } else extentTest.log(Status.FAIL,
 * "Filterations unsuccessful");
 * 
 * }
 * 
 * public Map<String, Integer>
 * identifyTheNumberOfDatabaseEnabledOnAddEditCostCenterScreenForTheCC() {
 * Map<String, Integer> values = new HashMap<String, Integer>(); if
 * ((businessUtilities.isDisplayed(hdrMappedDatabases))) { List<WebElement>
 * count =
 * driver.findElements(By.xpath("//tr/td[3] //span[contains(@class,'checked')]")
 * ); int dbCHeckedCount = count.size(); extentTest.log(Status.PASS,
 * "The count of enabled database On Add/Edit Costcenter Screen is " +
 * dbCHeckedCount); String ccvalue =
 * driver.findElement(By.xpath("//*[@placeholder='Costcenter']")).getAttribute(
 * "value"); values.put(ccvalue, dbCHeckedCount); return values;
 * 
 * } else { extentTest.log(Status.FAIL,
 * "Add/Edit Costcenter Screen is not displayed "); return null;
 * 
 * }
 * 
 * }
 * 
 * public Map<String, Map<String, Boolean>>
 * identifyTheNumberOfDatabaseEnabledOnAddEditCostCenterScreen() { Map<String,
 * Map<String, Boolean>> ccDBValues = new HashMap<String, Map<String,
 * Boolean>>(); Map<String, Boolean> dBvalues = new HashMap<String, Boolean>();
 * if ((businessUtilities.isDisplayed(hdrMappedDatabases))) {
 * extentTest.log(Status.PASS, "Add/Edit Costcenter Screen is displayed ");
 * List<WebElement> totaldbRows = driver
 * .findElements(By.xpath("//tbody[@data-testid='mappedDatabasesTB']/tr")); int
 * i = 1; for (WebElement tr : totaldbRows) { boolean dbEnabled = false;
 * List<WebElement> b = driver .findElements(By.xpath("//tr[" + i +
 * "]/td[3] //span[contains(@class,'checked')]")); if (b.size() == 0) i++; else
 * { dbEnabled = true; String dbName = driver.findElement(By.xpath("//tr[" + i +
 * "]/td[1]")).getText(); String ccvalue =
 * driver.findElement(By.xpath("//*[@placeholder='Costcenter']"))
 * .getAttribute("value"); extentTest.log(Status.PASS,
 * "DB enabled for costcenter " + ccvalue + "is :" + dbName);
 * dBvalues.put(dbName, dbEnabled); ccDBValues.put(ccvalue, dBvalues); i++; }
 * 
 * } return ccDBValues;
 * 
 * } else { extentTest.log(Status.FAIL,
 * "MppedDatabases Field is not displayed on Add/Edit Costcenter Screen ");
 * return null;
 * 
 * }
 * 
 * }
 * 
 * public Map<String, Map<String, Boolean>>
 * identifyTheNumberOfDatabaseEnabledOnAddEditCostCenterScreenUpdated() throws
 * InterruptedException { Thread.sleep(5000); Map<String, Map<String, Boolean>>
 * ccDBValues = new HashMap<String, Map<String, Boolean>>(); Map<String,
 * Boolean> dBvalues = new HashMap<String, Boolean>(); Actions builder1 = new
 * Actions(driver); if ((businessUtilities.isDisplayed(hdrMappedDatabases))) {
 * extentTest.log(Status.PASS, "Add/Edit Costcenter Screen is displayed "); for
 * (int i = 0; i < 30; i++) { WebElement element = driver
 * .findElement(By.xpath("//tbody[@data-testid='mappedDatabasesTB']//tr[last()]"
 * )); JavascriptExecutor js1 = (JavascriptExecutor) driver;
 * js1.executeScript("arguments[0].scrollIntoView();", element);
 * builder1.moveToElement(element).build().perform(); }
 * businessUtilities.isDisplayed(driver.findElement(By.xpath(
 * "//tbody[@data-testid='mappedDatabasesTB']/tr"))); List<WebElement>
 * totaldbRows = driver
 * .findElements(By.xpath("//tbody[@data-testid='mappedDatabasesTB']/tr")); int
 * i = 1; for (WebElement tr : totaldbRows) { boolean dbEnabled = false;
 * WebElement b = driver.findElement(By.xpath("//tr[" + i + "]/td[3] //span"));
 * String cbStatus = b.getAttribute("class"); if
 * (cbStatus.contains("MuiCheckbox-colorPrimary MuiIconButton-colorPrimary"))
 * i++; else if (cbStatus.contains("Mui-checked MuiIconButton-colorPrimary")) {
 * 
 * dbEnabled = true;
 * businessUtilities.isDisplayed(driver.findElement(By.xpath("//tr[" + i +
 * "]/td[1]"))); String dbName = driver.findElement(By.xpath("//tr[" + i +
 * "]/td[1]")).getText(); String ccvalue =
 * driver.findElement(By.xpath("//*[@placeholder='Costcenter']"))
 * .getAttribute("value"); extentTest.log(Status.PASS,
 * "DB enabled for costcenter " + ccvalue + "is :" + dbName);
 * dBvalues.put(dbName, dbEnabled); ccDBValues.put(ccvalue, dBvalues); i++; }
 * 
 * } return ccDBValues;
 * 
 * } else { extentTest.log(Status.FAIL,
 * "MppedDatabases Field is not displayed on Add/Edit Costcenter Screen ");
 * return null;
 * 
 * }
 * 
 * }
 * 
 * public void clickOnLoadBtn() throws Exception { try {
 * pageActions.waitUntilLoadingSymbolAppearsPolling(getloadCostCenterBtn(), 1,
 * 60); Thread.sleep(3000); loadCostCenterBtn.click();
 * extentTest.log(Status.PASS, "Load button is clicked successfully"); } catch
 * (Exception e) { e.getStackTrace(); loadCostCenterBtn.click();
 * extentTest.log(Status.FAIL, "Load button is not clicked at first try"); } }
 * 
 * public void validateFieldsContainingValues(ExcelValidations excelValidations,
 * List<ManageCostcentersValueStored> matchingvalueStored) throws
 * InterruptedException { Thread.sleep(2000); String ccSelect =
 * excelValidations.getCostCenter().toUpperCase(); String subDeptSelect =
 * excelValidations.getSubDepartment().toUpperCase(); String deptSelect =
 * excelValidations.getDepartment().toUpperCase(); String plantSelect =
 * excelValidations.getPlant().toUpperCase(); String descSelect =
 * excelValidations.getDescription(); (new WebDriverWait(driver,
 * Duration.ofSeconds(60))).until(new ExpectedCondition<Boolean>() { public
 * Boolean apply(WebDriver d) { return
 * d.findElement(By.xpath("//input[@data-testid='subdepartmenttx']")).
 * getAttribute("value") .length() != 0; } }); int subDepLength =
 * driver.findElement(By.xpath("//input[@data-testid='subdepartmenttx']")).
 * getAttribute("value") .length(); if (subDepLength == 0) {
 * Assert.assertFalse(false, "SubDepartment field is not displayed with data");
 * } if (hdrCostcenters.isDisplayed()) { String ccPopulatedUI =
 * costCenterTxtFld.getAttribute("value"); String subDeptPopulatedUI =
 * subDepartmentTxtFld.getAttribute("value"); String deptPopulatedUI =
 * departmentTxtFld.getAttribute("value"); String plantPopulatedUI =
 * plantTxtFld.getAttribute("value"); String descPopulatedUI =
 * descriptionTxtFld.getAttribute("value");
 * 
 * List<ManageCostcentersValueStored> cs = matchingvalueStored.stream()
 * .filter(val -> val.getCostcenter().equals(ccSelect) &&
 * val.getSubDepartment().equals(subDeptSelect) &&
 * val.getDepartment().equals(deptSelect) && val.getPlant().equals(plantSelect))
 * .collect(Collectors.toList()); if
 * ((cs.get(0).getCostcenter().equalsIgnoreCase(ccPopulatedUI)) &&
 * cs.get(0).getSubDepartment().equalsIgnoreCase(subDeptPopulatedUI) &&
 * cs.get(0).getDepartment().equalsIgnoreCase(deptPopulatedUI) &&
 * cs.get(0).getPlant().equalsIgnoreCase(plantPopulatedUI) &&
 * (cs.get(0).getDescription() == null ||
 * cs.get(0).getDescription().equalsIgnoreCase(descPopulatedUI))) {
 * extentTest.log(Status.PASS,
 * "The populated values in the fields are verified for : " + ccSelect + " are"
 * + "\n Costcenter: " + ccPopulatedUI + "\n Sub Department: " +
 * subDeptPopulatedUI + "\n Department: " + deptPopulatedUI + "\n Plant: " +
 * plantPopulatedUI + "\n Description: " + descPopulatedUI
 * 
 * ); } else { extentTest.log(Status.FAIL,
 * "Matching values not found for selecting costcenter:" + "Actual;   " +
 * "Costcenter: " + ccPopulatedUI + " Sub Department: " + subDeptPopulatedUI +
 * " Department: " + deptPopulatedUI + " Plant : " + plantPopulatedUI +
 * "Description : " + descPopulatedUI + "Expected;   " + "Costcenter: " +
 * cs.get(0).getCostcenter() + " Sub Department: " +
 * cs.get(0).getSubDepartment() + " Department: " + cs.get(0).getDepartment() +
 * " Plant : " + cs.get(0).getPlant() + " Description : " +
 * cs.get(0).getDescription()); Assert.assertEquals(ccPopulatedUI,
 * cs.get(0).getCostcenter()); }
 * 
 * extentTest.log(Status.PASS, "Fields are populated with data correctly"); }
 * else extentTest.log(Status.FAIL, "Add/Edit Costcenter Page is not loaded"); }
 * 
 * public void moveScrollToTheBottomOfAddEditCostcentersScreen() throws
 * InterruptedException { Actions builder1 = new Actions(driver); if
 * ((businessUtilities.isDisplayed(hdrMappedDatabases))) { try {
 * 
 * extentTest.log(Status.PASS, "Add/Edit Costcenter Screen is displayed "); for
 * (int i = 0; i < 30; i++) { Thread.sleep(300); WebElement element = driver
 * .findElement(By.xpath("//tbody[@data-testid='mappedDatabasesTB']//tr[last()]"
 * )); JavascriptExecutor js1 = (JavascriptExecutor) driver;
 * js1.executeScript("arguments[0].scrollIntoView();", element);
 * builder1.moveToElement(element).build().perform(); }
 * extentTest.log(Status.PASS,
 * "Scroll is moved to the bottom of the ManageCostcenters Page");
 * 
 * } catch (Exception e) { e.getStackTrace(); extentTest.log(Status.PASS,
 * "Add/Edit Costcenter Screen is displayed "); for (int i = 0; i < 30; i++) {
 * Thread.sleep(300); WebElement element = driver
 * .findElement(By.xpath("//tbody[@data-testid='mappedDatabasesTB']//tr[last()]"
 * )); JavascriptExecutor js1 = (JavascriptExecutor) driver;
 * js1.executeScript("arguments[0].scrollIntoView();", element);
 * builder1.moveToElement(element).build().perform(); }
 * extentTest.log(Status.PASS,
 * "Scroll is moved to the bottom of the Add/Edit Costcenter Page");
 * 
 * } } else { extentTest.log(Status.FAIL,
 * "MappedDatabases header is not displayed, Scroll is NOT  moved to the bottom of the Add/Edit Costcenter Page"
 * ); } }
 * 
 * public void verifytheMappedDatabasesDescArrowMouseOverAndClick() throws
 * InterruptedException { if (!focusFalseDatabase.isDisplayed()) { Actions
 * actions = new Actions(driver);
 * actions.moveToElement(focusFalseDatabase).click().perform(); if
 * (focusFalseDatabase.isDisplayed()) {
 * actions.moveToElement(focusFalseDatabase).click().perform(); }
 * extentTest.log(Status.PASS, " Database Descending Arrow is displayed"); }
 * else extentTest.log(Status.FAIL,
 * " Database Descending Arrow is not displayed"); }
 * 
 * public WebElement getAlertTxtSaveChanges() { return alertTxtSaveChanges; }
 * 
 * public void verifyIfCostcenterIsPresentUpdated(String ccExcel, String
 * subDeptExcel, String deptExcel, String plantExcel, String descExcel,
 * List<ManageCostcentersValueStored> matchingvalueStored) throws Exception {
 * List<ManageCostcentersValueStored> cs = matchingvalueStored.stream()
 * .filter(val -> val.getCostcenter().equalsIgnoreCase(ccExcel.toUpperCase()))
 * .collect(Collectors.toList());
 * 
 * PageFactoryAddEditCostCenterScreen obj = new
 * PageFactoryAddEditCostCenterScreen(driver); if (cs != null && !cs.isEmpty())
 * { if (obj.costCenterTxtFld.getAttribute("value").equalsIgnoreCase(cs.get(0).
 * getCostcenter()) && obj.subDepartmentTxtFld.getAttribute("value").trim()
 * .equalsIgnoreCase(cs.get(0).getSubDepartment()) &&
 * obj.departmentTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getDepartment()) &&
 * obj.plantTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getPlant()) && obj.descriptionTxtFld.getAttribute("value").trim()
 * .equalsIgnoreCase(cs.get(0).getDescription())) { obj.ClickOnSaveButton();
 * pageActions.waitUntilLoadingSymbolAppearsPolling(getAlertTxt(), 1, 60);
 * obj.verifyLoadCurrentConfirmationMessageInAddEditCostcentersScreen(
 * excelValidations.getCostCenter()); obj.clickOnYesAlert();
 * extentTest.log(Status.PASS,
 * "The details matching the value of costcenter is already present" + ccExcel +
 * " is already present, and is loaded as below:" + "\n Costcenter: " +
 * excelValidations.getCostCenter().trim() + "\n Sub Department: " +
 * excelValidations.getSubDepartment().trim() + "\n Department: " +
 * excelValidations.getDepartment().trim() + "\n Plant Matched: " +
 * excelValidations.getDescription().trim()); if
 * (businessUtilities.isDisplayed(snackbarLoadedSuccessfully)) { String
 * snackbarMsg = snackbarLoadedSuccessfully.getText();
 * extentTest.log(Status.PASS, "\"" + snackbarMsg +
 * "\" snackbar Message is displayed"); }
 * 
 * } } else { obj.ClickOnSaveButton(); extentTest.log(Status.PASS,
 * "The below details are saved successfully" + ccExcel +
 * " is already present, and is loaded as below:" + "\n Costcenter: " +
 * excelValidations.getCostCenter().trim() + "\n Sub Department: " +
 * excelValidations.getSubDepartment() + "\n Department: " +
 * excelValidations.getDepartment().trim() + "\n Plant Matched: " +
 * excelValidations.getDescription().trim()); if
 * (businessUtilities.isDisplayed((snackbarcreatedSuccessfully))) { String
 * snackbarCreatedMsg = snackbarLoadedSuccessfully.getText();
 * extentTest.log(Status.PASS, "\"" + snackbarCreatedMsg +
 * "\" snackbar Message is displayed"); } }
 * 
 * }
 * 
 * public void verifyIfCostcenterIsPresentLatest(String testcaseName, String
 * ccExcel, List<ManageCostcentersValueStored> matchingvalueStored) throws
 * Exception { excelValidations.setCostCenterValuesUpdated(testcaseName); String
 * subDeptExcel = excelValidations.getSubDepartment(); String deptExcel =
 * excelValidations.getDepartment(); String plantExcel =
 * excelValidations.getPlant(); String descExcel =
 * excelValidations.getDescription(); List<ManageCostcentersValueStored> cs =
 * matchingvalueStored.stream() .filter(val ->
 * val.getCostcenter().equalsIgnoreCase(ccExcel.toUpperCase()))
 * .collect(Collectors.toList());
 * 
 * PageFactoryAddEditCostCenterScreen obj = new
 * PageFactoryAddEditCostCenterScreen(driver); if (cs != null && !cs.isEmpty())
 * { if (obj.costCenterTxtFld.getAttribute("value").equalsIgnoreCase(cs.get(0).
 * getCostcenter()) && obj.subDepartmentTxtFld.getAttribute("value").trim()
 * .equalsIgnoreCase(cs.get(0).getSubDepartment()) &&
 * obj.departmentTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getDepartment()) &&
 * obj.plantTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getPlant()) && obj.descriptionTxtFld.getAttribute("value").trim()
 * .equalsIgnoreCase(cs.get(0).getDescription())) { obj.ClickOnSaveButton();
 * pageActions.waitUntilLoadingSymbolAppearsPolling(getAlertTxt(), 1, 60);
 * obj.verifyLoadCurrentConfirmationMessageInAddEditCostcentersScreen(
 * excelValidations.getCostCenter()); obj.clickOnYesAlert();
 * extentTest.log(Status.PASS, "The details matching the value of costcenter " +
 * ccExcel + " is already present, and is loaded as below:" + "\n Costcenter: "
 * + excelValidations.getCostCenter().trim() + "\n Sub Department: " +
 * excelValidations.getSubDepartment().trim() + "\n Department: " +
 * excelValidations.getDepartment().trim() + "\n Plant Matched: " +
 * excelValidations.getDescription().trim());
 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarLoadedSuccessfully,
 * 1, 60); String snackbarMsg = snackbarLoadedSuccessfully.getText();
 * Assert.assertEquals(snackbarMsg, "Loaded successfully");
 * extentTest.log(Status.PASS, "\"" + snackbarMsg +
 * "\" snackbar Message is displayed"); } } else { obj.ClickOnSaveButton();
 * extentTest.log(Status.PASS, "The below details are saved successfully" +
 * ccExcel + "\n Costcenter : " + excelValidations.getCostCenter().trim() +
 * "\n Sub Department : " + excelValidations.getSubDepartment() +
 * "\n Department : " + excelValidations.getDepartment().trim() +
 * "\n Plant Matched: " + excelValidations.getDescription().trim());
 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarcreatedSuccessfully,
 * 1, 60); String snackbarCreatedMsg = snackbarcreatedSuccessfully.getText();
 * Assert.assertEquals(snackbarCreatedMsg,
 * costCenterTxtFld.getAttribute("value") + " Costcenter Created Successfully");
 * extentTest.log(Status.PASS, "\"" + snackbarCreatedMsg +
 * "\" snackbar Message is displayed");
 * 
 * } }
 * 
 *//**
	* 
	*/
/*
 * public void enablePseudoFlag() { if (txtPseudoFlag.isDisplayed()) {
 * extentTest.log(Status.PASS, "\"" + txtPseudoFlag.getText() +
 * "\" is displayed"); swtchPseudoFlag.click(); extentTest.log(Status.PASS,
 * "Pseudo Switch is enabled"); dropdownClick.click();
 * extentTest.log(Status.PASS, "Pseudo Database dropdown is clicked");
 * 
 * } else extentTest.log(Status.FAIL, "Pseudo flag  is not displayed");
 * 
 * }
 * 
 *//**
	* 
	*/
/*
 * public void createPseudoDatabaseIfUnavailable() { if
 * (pseudoDbLabel.isDisplayed()) { Boolean dbfound = false; String dbValuexl =
 * excelValidations.getDatabase(); for (WebElement list : PseudoDBList) {
 * 
 * String dbValueUI = list.getAttribute("data-value"); if
 * (dbValueUI.equals(dbValuexl.toUpperCase().trim())) { list.click();
 * extentTest.log(Status.PASS, "\"" + dbValueUI + "\" is clicked"); dbfound =
 * true; break; }
 * 
 * } if (dbfound = false) { extentTest.log(Status.FAIL,
 * "Database is not available"); } } else extentTest.log(Status.FAIL, "\"" +
 * dropdownClick + "\" snackbar Message is displayed");
 * 
 * }
 * 
 *//**
	 * @param string
	 * @param matchingvalueStored
	 * @throws Exception
	 */
/*
 * public void verifyIfDatabaseIsPresentLatest(String testcaseName,
 * List<ManageCostcentersValueStored> matchingvalueStored) throws Exception {
 * 
 * excelValidations.setCostCenterValuesUpdated(testcaseName); String ccExcel =
 * excelValidations.getCostCenter(); String subDeptExcel =
 * excelValidations.getSubDepartment(); String deptExcel =
 * excelValidations.getDepartment(); String plantExcel =
 * excelValidations.getPlant(); String descExcel =
 * excelValidations.getDescription(); String database =
 * excelValidations.getDatabase(); List<ManageCostcentersValueStored> cs =
 * matchingvalueStored.stream() .filter(val ->
 * val.getDatabase().equalsIgnoreCase(database.toUpperCase())).collect(
 * Collectors.toList());
 * 
 * PageFactoryAddEditCostCenterScreen obj = new
 * PageFactoryAddEditCostCenterScreen(driver); if (cs != null && !cs.isEmpty())
 * { if (obj.costCenterTxtFld.getAttribute("value").equalsIgnoreCase(cs.get(0).
 * getCostcenter()) && obj.subDepartmentTxtFld.getAttribute("value").trim()
 * .equalsIgnoreCase(cs.get(0).getSubDepartment()) &&
 * obj.departmentTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getDepartment()) &&
 * obj.plantTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getPlant()) &&
 * obj.descriptionTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0)
 * .getDescription()) &&
 * obj.dropdownClick.getText().trim().equalsIgnoreCase(cs.get(0).getDatabase()))
 * { obj.ClickOnSaveButton();
 * pageActions.waitUntilLoadingSymbolAppearsPolling(getAlertTxt(), 1, 120);
 * obj.verifyLoadCurrentConfirmationMessageInAddEditCostcentersScreen(database.
 * toUpperCase()); obj.clickOnYesAlert(); extentTest.log(Status.PASS,
 * "The details matching the value of Pesudo databse " + ccExcel +
 * " is already present, and is loaded as below:" + " Pseudo Database Matched: "
 * + excelValidations.getDatabase().trim());
 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarLoadedSuccessfully,
 * 1, 120); String snackbarMsg = snackbarLoadedSuccessfully.getText();
 * Assert.assertEquals(snackbarMsg, "Loaded successfully");
 * extentTest.log(Status.PASS, "\"" + snackbarMsg +
 * "\" snackbar Message is displayed"); } } else { obj.ClickOnSaveButton();
 * extentTest.log(Status.PASS, "The below details are saved successfully" +
 * "\n Database Matched: " + excelValidations.getDatabase().trim());
 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarcreatedSuccessfully,
 * 1, 240); String snackbarCreatedMsg = snackbarcreatedSuccessfully.getText();
 * Assert.assertEquals(snackbarCreatedMsg,
 * costCenterTxtFld.getAttribute("value") + " Costcenter Created Successfully");
 * extentTest.log(Status.PASS, "\"" + snackbarCreatedMsg +
 * "\" snackbar Message is displayed");
 * 
 * }
 * 
 * }
 * 
 * public void verifyIfPsedoDatabaseIsPresentByLoadingNSaving(String
 * testcaseName, List<ManageCostcentersValueStored> matchingvalueStored) throws
 * Exception { excelValidations.setCostCenterValuesUpdated(testcaseName); String
 * ccExcel = excelValidations.getCostCenter(); String subDeptExcel =
 * excelValidations.getSubDepartment(); String deptExcel =
 * excelValidations.getDepartment(); String plantExcel =
 * excelValidations.getPlant(); String descExcel =
 * excelValidations.getDescription(); String database =
 * excelValidations.getDatabase(); List<ManageCostcentersValueStored> cs =
 * matchingvalueStored.stream() .filter(val ->
 * val.getDatabase().equalsIgnoreCase(database.toUpperCase())).collect(
 * Collectors.toList()); PageFactoryAddEditCostCenterScreen obj = new
 * PageFactoryAddEditCostCenterScreen(driver); if (cs != null && !cs.isEmpty())
 * { if (obj.costCenterTxtFld.getAttribute("value").equalsIgnoreCase(cs.get(0).
 * getCostcenter()) && obj.subDepartmentTxtFld.getAttribute("value").trim()
 * .equalsIgnoreCase(cs.get(0).getSubDepartment()) &&
 * obj.departmentTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getDepartment()) &&
 * obj.plantTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
 * getPlant()) &&
 * obj.descriptionTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0)
 * .getDescription()) &&
 * obj.dropdownClick.getText().trim().equalsIgnoreCase(cs.get(0).getDatabase()))
 * { clickOnLoadBtn(); extentTest.log(Status.PASS,
 * "The details matching the value of Pesudo databse " + ccExcel +
 * " is already present, and is loaded as below:" + " Pseudo Database Matched: "
 * + excelValidations.getDatabase().trim());
 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarLoadedSuccessfully,
 * 1, 240); String snackbarMsg = snackbarLoadedSuccessfully.getText();
 * Assert.assertEquals(snackbarMsg, "Loaded successfully");
 * extentTest.log(Status.PASS, "\"" + snackbarMsg +
 * "\" snackbar Message is displayed");
 * 
 * } } else { obj.ClickOnSaveButton(); extentTest.log(Status.PASS,
 * "The below details are saved successfully" + "\n Database Matched: " +
 * excelValidations.getDatabase().trim());
 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarcreatedSuccessfully,
 * 1, 60); String snackbarCreatedMsg = snackbarcreatedSuccessfully.getText();
 * Assert.assertEquals(snackbarCreatedMsg, dropdownClick.getText() +
 * " Costcenter Created Successfully"); extentTest.log(Status.PASS, "\"" +
 * snackbarCreatedMsg + "\" snackbar Message is displayed");
 * 
 * }
 * 
 * }
 * 
 *//**
	 * @param matchingvalueStored
	 * @throws Exception
	 *//*
		 * public void verifyIfPsedoDatabaseIsPresentByLoadingNSavingBySettingValues(
		 * List<ManageCostcentersValueStored> matchingvalueStored) throws Exception {
		 * 
		 * String ccExcel = excelValidations.getCostCenter(); String subDeptExcel =
		 * excelValidations.getSubDepartment(); String deptExcel =
		 * excelValidations.getDepartment(); String plantExcel =
		 * excelValidations.getPlant(); String descExcel =
		 * excelValidations.getDescription(); String database =
		 * excelValidations.getDatabase(); List<ManageCostcentersValueStored> cs =
		 * matchingvalueStored.stream() .filter(val ->
		 * val.getDatabase().equalsIgnoreCase(database.toUpperCase())).collect(
		 * Collectors.toList()); PageFactoryAddEditCostCenterScreen obj = new
		 * PageFactoryAddEditCostCenterScreen(driver); if (cs != null && !cs.isEmpty())
		 * { if (obj.costCenterTxtFld.getAttribute("value").equalsIgnoreCase(cs.get(0).
		 * getCostcenter()) && obj.subDepartmentTxtFld.getAttribute("value").trim()
		 * .equalsIgnoreCase(cs.get(0).getSubDepartment()) &&
		 * obj.departmentTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
		 * getDepartment()) &&
		 * obj.plantTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0).
		 * getPlant()) &&
		 * obj.descriptionTxtFld.getAttribute("value").trim().equalsIgnoreCase(cs.get(0)
		 * .getDescription()) &&
		 * obj.dropdownClick.getText().trim().equalsIgnoreCase(cs.get(0).getDatabase()))
		 * { clickOnLoadBtn(); extentTest.log(Status.PASS,
		 * "The details matching the value of Pesudo databse " + ccExcel +
		 * " is already present, and is loaded as below:" + " Pseudo Database Matched: "
		 * + excelValidations.getDatabase().trim());
		 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarLoadedSuccessfully,
		 * 1, 60); String snackbarMsg = snackbarLoadedSuccessfully.getText();
		 * Assert.assertEquals(snackbarMsg, "Loaded successfully");
		 * extentTest.log(Status.PASS, "\"" + snackbarMsg +
		 * "\" snackbar Message is displayed"); } } else { obj.ClickOnSaveButton();
		 * extentTest.log(Status.PASS, "The below details are saved successfully" +
		 * "\n Database Matched: " + excelValidations.getDatabase().trim());
		 * pageActions.waitUntilLoadingSymbolAppearsPolling(snackbarcreatedSuccessfully,
		 * 1, 60); String snackbarCreatedMsg = snackbarcreatedSuccessfully.getText();
		 * Assert.assertEquals(snackbarCreatedMsg, selectDBField.getText() +
		 * " Costcenter Created Successfully"); extentTest.log(Status.PASS, "\"" +
		 * snackbarCreatedMsg + "\" snackbar Message is displayed");
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */