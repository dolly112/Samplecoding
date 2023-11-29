/*
 * package com.utilities;
 * 
 * import java.io.BufferedInputStream; import java.io.File; import
 * java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.io.IOException; import java.net.MalformedURLException; import
 * java.net.URL; import java.net.UnknownHostException; import
 * java.text.SimpleDateFormat; import java.util.Collections; import
 * java.util.Date; import java.util.HashMap; import java.util.Map; import
 * java.util.Properties; import java.util.concurrent.TimeUnit;
 * 
 * import javax.activation.DataHandler; import javax.activation.FileDataSource;
 * import javax.mail.Message; import javax.mail.Multipart; import
 * javax.mail.Session; import javax.mail.Transport; import
 * javax.mail.internet.InternetAddress; import javax.mail.internet.MimeBodyPart;
 * import javax.mail.internet.MimeMessage; import
 * javax.mail.internet.MimeMultipart;
 * 
 * import org.apache.commons.io.FileUtils; import
 * org.apache.log4j.BasicConfigurator; import org.apache.log4j.Logger; import
 * org.apache.log4j.xml.DOMConfigurator; import
 * org.apache.tools.ant.property.GetProperty; import
 * org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot;
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions; import
 * org.openqa.selenium.devtools.DevTools; import
 * org.openqa.selenium.devtools.v113.network.Network; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.edge.EdgeOptions; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.openqa.selenium.ie.InternetExplorerDriver; import
 * org.openqa.selenium.remote.RemoteWebDriver; import org.slf4j.LoggerFactory;
 * import org.testng.ITestNGListener; import org.testng.annotations.AfterMethod;
 * import org.testng.annotations.AfterSuite; import
 * org.testng.annotations.BeforeClass; import
 * org.testng.annotations.BeforeMethod; import
 * org.testng.annotations.BeforeSuite; import org.testng.annotations.Parameters;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.MediaEntityBuilder; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.reporter.ExtentHtmlReporter; import
 * com.daimler.plaUM.dataloader.ExcelValidations; import
 * com.daimler.plaUM.pageobjects.PLAWebHomePage; import
 * com.daimler.plaUM.pageobjects.PLAWebRequestAccessPage; import
 * com.daimler.plaUM.pageobjects.PageFactoryAddEditCostCenterScreen; import
 * com.daimler.plaUM.pageobjects.PageFactoryHomePage; import
 * com.daimler.plaUM.pageobjects.PageFactoryLoginPage; import
 * com.daimler.plaUM.pageobjects.PageFactoryManageCostCenterScreen; import
 * com.daimler.plaUM.pageobjects.PageFactoryManageRequestAccessPage; import
 * com.daimler.plaUM.pageobjects.PageFactoryRequestAccessPage; import
 * com.daimler.plaUM.pageobjects.PageFactoryManageRoles; import
 * com.daimler.plaUM.pageobjects.PageFactoryManageUsers; import
 * com.daimler.plaUM.pageobjects.PageFactoryMapRolesPage; import
 * com.daimler.plaUM.pageobjects.PageFactoryOverviewScreen; import
 * com.daimler.plaUM.pageobjects.PageFactorySearchCostcenter; import
 * com.daimler.plaUM.pageobjects.PageFactorySearchDatabase; import
 * com.daimler.plaUM.pageobjects.PageFactoryUserManagemaentAddEditDatabasesPage;
 * import
 * com.daimler.plaUM.pageobjects.PageFactoryUserManagemaentManageDatabasesPage;
 * import com.daimler.plaUM.pageobjects.PageFactoryUserManagementHomeScreenPage;
 * 
 * import jcifs.smb.NtlmPasswordAuthentication; import jcifs.smb.SmbFile; import
 * jcifs.smb.SmbFileOutputStream;
 * 
 * 
 *//***
	 * It implements ITestListener.. This Class do the actions of before and after
	 * executions like: launch browser & close browser, take screenshots, create
	 * report with unique name &email report, place report in shared drive etc....
	 * 
	 * @author GRANDIS
	 * 
	 *
	 */
/*
 * public class BaseInitializerOriginal implements ITestNGListener {
 * 
 * 
 * public static Logger LOGGER =
 * Logger.getLogger(BaseInitializerOriginal.class); public static WebDriver
 * driver; // public PageFactoryHomePage pfHomePage; // public
 * PageFactoryOverviewScreen pfOverviewPage; // public PageFactoryLoginPage
 * pfLoginPage; // public PageFactoryUserManagementHomeScreenPage
 * managementHomeScreen; // public PageFactoryManageCostCenterScreen
 * manageCostCenterScreen; // public PageFactoryAddEditCostCenterScreen
 * addEditCostCenterScreen; // public PageFactoryManageUsers manageUsers; //
 * public PageFactoryManageRoles manageRoles; // public
 * PageFactoryUserManagemaentManageDatabasesPage manageDatabasesScreen; //
 * public PageFactoryUserManagemaentAddEditDatabasesPage addEditDatabasesScreen;
 * // public PageFactoryMapRolesPage mapRolesScreen; // public
 * PageFactorySearchCostcenter searchCostcenterScreen; // public
 * PageFactorySearchDatabase searchDatabaseScreen; // public
 * ManageCostcentersValueStored cc; // public PLAWebRequestAccessPage
 * plaRequestAccessPage; // public PLAWebHomePage plaWebHomePage; // public
 * PageFactoryManageRequestAccessPage manageRequestAccessPage; // public
 * PageFactoryRequestAccessPage requestAccessPage;
 * 
 * 
 * 
 * 
 * public PageFactoryManageRoles getManageRoles() { return manageRoles; }
 * 
 * public void setManageRoles(PageFactoryManageRoles manageRoles) {
 * this.manageRoles = manageRoles; }
 * 
 * public PageFactoryManageUsers getPageFactoryManageUsers() { return
 * manageUsers; }
 * 
 * public void setPageFactoryManageUsers(PageFactoryManageUsers manageUsers) {
 * this.manageUsers = manageUsers; }
 * 
 * public PageFactoryAddEditCostCenterScreen getAddEditCostCenterScreen() {
 * return addEditCostCenterScreen; }
 * 
 * public void setAddEditCostCenterScreen(PageFactoryAddEditCostCenterScreen
 * addEditCostCenterScreen) { this.addEditCostCenterScreen =
 * addEditCostCenterScreen; }
 * 
 * public PageFactoryManageCostCenterScreen getManageCostCenterScreen() { return
 * manageCostCenterScreen; }
 * 
 * public void setManageCostCenterScreen(PageFactoryManageCostCenterScreen
 * manageCostCenterScreen) { this.manageCostCenterScreen =
 * manageCostCenterScreen; }
 * 
 * public PageFactoryUserManagementHomeScreenPage getManagementHomeScreen() {
 * return managementHomeScreen; }
 * 
 * public void setManagementHomeScreen(PageFactoryUserManagementHomeScreenPage
 * managementHomeScreen) { this.managementHomeScreen = managementHomeScreen; }
 * 
 * public static ExtentReports extentReport; public static ExtentTest
 * extentTest; public ExtentHtmlReporter htmlReport; public static
 * BusinessUtilities utilityAction; public static ExcelValidations
 * excelValidations; public PageActions pageActions; public String reportPath =
 * null; public String userId; public String passWord; public String newUser;
 * public String plaPassWord; public String UMAdmin; public String SuperAdmin;
 * public static String reqLanguage; public static String ReqScreenShot; public
 * static String executionIn; public static String sendEmailTo; public static
 * String sendEmailFrom; public static String Browser; public static String
 * Environment; public static String buildNumber; public String projectPath =
 * System.getProperty("user.dir"); public String currentReportFolder; public
 * static String dynamicReportFolderName; public static String sharedFolderUrl;
 * String excelPath = projectPath + "/lib/ConfuigurationFile.xlsx"; public
 * String reportFolderPath = projectPath + "//Reports//";
 * 
 * static Properties Prop = null; static FileInputStream io = null;
 * 
 *//**
	 * It uses initialize the objects of page factory classes using setter method.
	 * Note: TO Access the pagefactory elements, have to call the pagefactory
	 * settermethod here
	 * 
	 * @author GRANDIS
	 */
/*
 * public void objectIntialization() { setPlaWebHomePage(new
 * PLAWebHomePage(driver)); setSearchDatabaseScreen(new
 * PageFactorySearchDatabase(driver)); setSearchCostcenterScreen(new
 * PageFactorySearchCostcenter(driver)); setPfHomePage(new
 * PageFactoryHomePage(driver)); setPfOverviewPage(new
 * PageFactoryOverviewScreen(driver)); setPfLoginPage(new
 * PageFactoryLoginPage(driver)); setManagementHomeScreen(new
 * PageFactoryUserManagementHomeScreenPage(driver));
 * setManageCostCenterScreen(new PageFactoryManageCostCenterScreen(driver));
 * setAddEditCostCenterScreen(new PageFactoryAddEditCostCenterScreen(driver));
 * setPageFactoryManageUsers(new PageFactoryManageUsers(driver));
 * setPfUserManagementManageDatabasesPage(new
 * PageFactoryUserManagemaentManageDatabasesPage (driver));
 * setPfMapRolesPage(new PageFactoryMapRolesPage (driver));
 * setPfUserManagementAddEditDatabasesPage(new
 * PageFactoryUserManagemaentAddEditDatabasesPage (driver)); setManageRoles(new
 * PageFactoryManageRoles(driver)); setPlaRequestAccessPage(new
 * PLAWebRequestAccessPage(driver)); setPlaWebHomePage(new
 * PLAWebHomePage(driver)); setRequestAccessPage(new
 * PageFactoryRequestAccessPage(driver)); setManageRequestAccessPage(new
 * PageFactoryManageRequestAccessPage(driver)); BasicConfigurator.configure(); }
 * 
 *//**
	 * This method for launch the browser then login to application and select the
	 * required language based on run configuration Get the all parameters from
	 * dynamicTestng Class
	 * 
	 * @author GRANDIS on
	 * @param browser
	 * @param language
	 * @param environment
	 * @param executingIn
	 * @param screenshot
	 * @param emailTo
	 * @throws Exception
	 */
/*
 * //Select from constants file
 * 
 * @Parameters({ "browser", "language", "environment", "executingIn",
 * "screenshot", "emailFrom", "emailTo" })
 * 
 * @BeforeMethod(groups = { "SmokeTest", "RegressionTest" }) public void
 * startBrowser(String browser, String language, String environment, String
 * executingIn, String screenshot, String emailFrom, String emailTo) throws
 * Exception {
 * 
 * utilityAction = new BusinessUtilities(); pageActions = new PageActions();
 * excelValidations= new ExcelValidations(); reqLanguage = "EN"; ReqScreenShot =
 * screenshot; executionIn = executingIn; sendEmailTo = emailTo; sendEmailFrom =
 * emailFrom;
 * 
 * Browser = browser; Environment = "DEV"; //TEST userId =
 * getProperty("UserName"); //passWord =
 * PasswordEncryptDcrypt.decrypt(System.getenv("AppPwd")); passWord
 * =getProperty("UserName"); // add you password for dev rosmols
 * newUser=getProperty("PlaUsername"); plaPassWord=getProperty("PlaUsername");
 * UMAdmin=getProperty("UMAdmin"); SuperAdmin=getProperty("SuperAdmin"); //
 * passWord =getProperty("UserName"); // add you password for dev
 * LOGGER.info("Launching the Browser");
 * 
 * //Change to Switch statement if (browser.equalsIgnoreCase("Edge")) {
 * launchEdgeChromium(); } else if (browser.equalsIgnoreCase("chrome")) {
 * 
 * lauchChrome(executingIn); driver.manage().deleteAllCookies(); } else if
 * (browser.equalsIgnoreCase("firefox")) { lauchFirefox(); } else if
 * (browser.equalsIgnoreCase("IE")) { launchInternetExplorer(); } if
 * (environment.equalsIgnoreCase("TI")) { driver.get(getProperty("TI_URL")); }
 * else if (environment.equalsIgnoreCase("INT")) {
 * driver.get(getProperty("INT_URL")); } else if
 * (environment.equalsIgnoreCase("PROD")) { driver.get(getProperty("PROD_URL"));
 * }else if (environment.equalsIgnoreCase("TEST")) {
 * driver.get(getProperty("TEST_URL")); }else {
 * LOGGER.info("Invalid Environment Details"); } objectIntialization();
 * 
 * driver.manage().window().maximize(); driver.navigate().refresh();
 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //
 * driver.manage().deleteAllCookies(); //newly added // DevTools devTools =
 * ((ChromeDriver) driver).getDevTools(); // devTools.createSession(); // Send
 * the command to clear the browser cache
 * 
 * // devTools.send(Network.clearBrowserCache());
 * 
 * PageFactoryLoginPage p = new PageFactoryLoginPage(null);
 * if(pfLoginPage.isDaimlerFormDisplayed()) //commented {
 * pfLoginPage.login(userId, passWord); //commented // Thread.sleep(5000);//
 * if(getlogin_TBox_Int_UserName()) } else //commented
 * extentTest.log(Status.FAIL, "Login page not displayed"); //commented
 * 
 * if (language.contains("EN")) {
 * LOGGER.debug("Started the language selection");
 * pfHomePage.allScreens_Dpdw_Lang.click(); pfHomePage.LanguageEN.click();
 * 
 * } else { pfHomePage.allScreens_Dpdw_Lang.click();
 * pfHomePage.LanguageDE.click(); }
 * 
 * Thread.sleep(5000); // if(pfLoginPage.isDaimlerWelcomeTextDisplayed())
 * //rosmols added // pfLoginPage.login(userId, passWord); // else //
 * extentTest.log(Status.FAIL, "Login page not displayed"); }
 * 
 * // if(true) // { //rosmols added // // pfLoginPage.login(userId, passWord);
 * // PageFactoryLoginPage pf= new PageFactoryLoginPage(driver); //
 * pf.verifyUsernamePasswordField(); // } // else // extentTest.log(Status.FAIL,
 * "Login page not displayed"); // // }
 * 
 * 
 *//**
	 * This method for launch edge browser Note: For local execution latest driver
	 * should place in lib folder
	 * 
	 * @author GRANDIS
	 * @throws InterruptedException
	 */
/*
 * public WebDriver launchEdge() throws InterruptedException {
 * 
 * String edgePath = projectPath + "//lib//MicrosoftWebDriver.exe";
 * System.setProperty("webdriver.edge.driver", edgePath); return driver = new
 * EdgeDriver(); }
 * 
 *//**
	 * This method for launch chrome browser Note: For local execution latest driver
	 * should place in lib folder
	 * 
	 * @author GRANDIS
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
/*
 * public WebDriver lauchChrome(String executingIn) throws MalformedURLException
 * {
 * 
 * if (executingIn.equalsIgnoreCase("local")) { // String path =
 * System.getProperty("user.dir"); // String chromePath = path +
 * "//lib//chromedriver.exe"; // System.setProperty("webdriver.chrome.driver",
 * chromePath); ChromeOptions options = new ChromeOptions();
 * options.setExperimentalOption("useAutomationExtension", false);
 * options.addArguments("--remote-allow-origins=*");
 * options.setExperimentalOption("excludeSwitches",Collections.singletonList(
 * "enable-automation")); options.addArguments("--remote-allow-origins=*");
 * //newly added because of error in v 111 driver = new ChromeDriver(options);
 * //new line // Map<String, Object> prefs = new HashMap<String, Object>(); //
 * prefs.put(
 * "profile.content_settings.exceptions.automatic_downloads.*.setting", 1); //
 * ChromeOptions options = new ChromeOptions(); // //
 * options.setExperimentalOption("prefs", prefs); //
 * options.setExperimentalOption("useAutomationExtension", false); // driver =
 * new ChromeDriver(options);
 * 
 * 
 * } else if (executingIn.equalsIgnoreCase("remote")) {
 * LOGGER.info("Entered into OpenShift Related chrome");
 * System.setProperty("webdriver.chrome.driver", "/opt/chrome/chromedriver");
 * ChromeOptions options = new ChromeOptions();
 * options.addArguments("--disable-web-security");
 * options.addArguments("--ignore-certificate-errors");
 * options.addArguments("--allow-running-insecure-content");
 * options.addArguments("--allow-insecure-localhost");
 * options.addArguments("--no-sandbox");
 * options.addArguments("--start-maximized");
 * options.addArguments("--disable-dev-shm-usage");
 * options.addArguments("--headless"); // driver = new ChromeDriver(options);
 * driver= new RemoteWebDriver(new URL("http://localhost:4444"),options);
 * 
 * }
 * 
 * return driver; }
 * 
 *//**
	 * This method for launch Firefox browser Note: For local execution latest
	 * driver should place in lib folder
	 * 
	 * @author GRANDIS
	 * @throws InterruptedException
	 */
/*
 * public WebDriver lauchFirefox() { String firefoxPath = projectPath +
 * "//lib//MicrosoftWebDriver.exe"; System.setProperty("webdriver.gecko.driver",
 * firefoxPath); return driver = new FirefoxDriver(); }
 * 
 *//**
	 * This method for launch IE browser Note: For local execution latest driver
	 * should place in lib folder
	 * 
	 * @author GRANDIS
	 * @throws InterruptedException
	 */
/*
 * public WebDriver launchInternetExplorer() { String IEpath = projectPath +
 * "//lib//IEDriverServer.exe"; System.setProperty("webdriver.ie.driver",
 * IEpath); return driver = new InternetExplorerDriver(); }
 * 
 * //@SuppressWarnings("deprecation") public void launchEdgeChromium(){
 * 
 * System.setProperty("webdriver.edge.driver",
 * System.getProperty("user.dir").concat("\\lib\\msedgedriver.exe"));
 * EdgeOptions edgeOptions = new EdgeOptions();
 * 
 * //edgeOptions.UseChromium = true; WebDriver driver = new
 * EdgeDriver(edgeOptions); // driver.get("https://www.google.com/");
 * 
 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * }
 * 
 *//**
	 * Method fore get the screenshot
	 * 
	 * @author GRANDIS
	 * @param details : name of the screenshot
	 * @return : return the image relative path
	 * @throws IOException
	 */
/*
 * public String getScreenshot(String details) throws IOException { Date date =
 * new Date(); SimpleDateFormat dateFormat = new
 * SimpleDateFormat("yyyy-MM-dd hh-mm-ss"); String fileName =
 * dateFormat.format(date) + ".png"; TakesScreenshot screenShot =
 * (TakesScreenshot) driver; File fileAs =
 * screenShot.getScreenshotAs(OutputType.FILE); String currentPath =
 * dynamicReportFolderName + "/"; String imgPath = currentPath + details + "-" +
 * fileName; FileUtils.copyFile(fileAs, new File(imgPath)); String
 * imgRelativePath = ".//" + details + "-" + fileName; return imgRelativePath; }
 * 
 *//**
	 * Method for add the screenshot to extent report
	 * 
	 * @author GRANDIS
	 * @param logDetails : name of the screenshot
	 * @param imagePath  : path of the image
	 * @return
	 * @throws IOException
	 */
/*
 * public Object addScreenshotToReport(String logDetails, String imagePath)
 * throws IOException { extentTest.log(Status.INFO, logDetails,
 * MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build()); return
 * extentTest;
 * 
 * }
 * 
 *//**
	 * Method get screenshot based on run configuration, this method should be call
	 * inside the test script run configuration: onPass will take screenshot else
	 * will not take screenshot
	 * 
	 * @author GRANDIS
	 * @param logDetails
	 * @throws IOException
	 */
/*
 * public void logWithScreenshot(String logDetails) throws IOException { if
 * (ReqScreenShot.equalsIgnoreCase("Both")|ReqScreenShot.contains("OnPass")) {
 * String screenShotPath = getScreenshot(logDetails);
 * addScreenshotToReport(logDetails, screenShotPath); } }
 * 
 *//**
	 * Method for take screenshot on failure , method written for custom listener
	 * 
	 * @author GRANDIS
	 * @param testName
	 * @throws IOException
	 */
/*
 * public void reportWithScreenshotOnFail(String testName) throws IOException {
 * String screenShotPath = getScreenshot(testName);
 * addScreenshotToReport(testName, screenShotPath); }
 * 
 *//**
	 * This method for create extent report with Date and time in specified folder
	 * 
	 * @author GRANDIS
	 * @throws UnknownHostException
	 */
/*
 * @BeforeSuite(groups = { "SmokeTest", "RegressionTest" }) public void
 * extentreportCreation() throws UnknownHostException { reportPath =
 * dynamicReportname("No"); htmlReport = new ExtentHtmlReporter(reportPath);
 * extentReport = new ExtentReports(); extentReport.attachReporter(htmlReport);
 * }
 * 
 *//**
	 * This method for create a file name with Date & time format
	 * 
	 * @author GRANDIS
	 * 
	 * @param customreportPathYesNo : provide "Yes" it will provide dynamic name for
	 *                              custom report, If No/any text Extent report will
	 *                              be dynamic name
	 * @return
	 */
/*
 * public String dynamicReportname(String customreportPathYesNo) { Date date =
 * new Date(); SimpleDateFormat dateFormat = new
 * SimpleDateFormat("yyyy-MM-dd hh-mm-ss"); String reportName =
 * dateFormat.format(date); if (customreportPathYesNo.equalsIgnoreCase("Yes")) {
 * return System.getProperty("user.dir") + "//custom_report//Custom_Report" +
 * reportName + ".html"; } else { // Creating dynamic report folder name
 * currentReportFolder = dynamicReportFolderCreation(); String reportPath =
 * currentReportFolder + reportName + ".html"; return reportPath; } }
 * 
 *//**
	 * Method for close the browser after each execution and flush the extent report
	 * 
	 * @author GRANDIS
	 * @throws InterruptedException
	 */
/*
 * @AfterMethod(groups = { "SmokeTest", "RegressionTest" }) public void
 * tearDown() throws InterruptedException { driver.manage().deleteAllCookies();
 * //newly added driver.quit(); extentReport.flush();
 * LOGGER.info("Closed the Browser");
 * 
 * }
 * 
 *//**
	 * Method for send report after suite execution based run configuration, mail
	 * will send if we run in remote linux environment
	 * 
	 * @author GRANDIS
	 * @param executingIn : whether executing in local/remote
	 * @param emailTo     : recipients mail id
	 * @throws IOException
	 */
/*
 * @Parameters({ "executingIn", "emailTo", })
 * 
 * @AfterSuite(groups = { "SmokeTest", "RegressionTest" }) public void
 * SendReport(String executingIn, String emailTo) throws IOException { if
 * (executingIn.contains("remote")) { String absoluteFilePathOfAttachment =
 * reportPath; sendReportAfterSuiteExecution(absoluteFilePathOfAttachment,
 * sendEmailFrom, emailTo); String sourcePath = reportFolderPath;
 * storeReportInSharedFolder(sourcePath); LOGGER.
 * info(" *******Completed the suite Execution With Emailable Report  In Remote system ********"
 * ); } else { LOGGER.info(" ******Completed the suite Execution ********"); } }
 * 
 *//**
	 * This method for send email after the execution Note: mail form : value hard
	 * coded, provide valid email id
	 * 
	 * @author GRANDIS
	 * @param path       : absolute path of the report
	 * @param emailFrom: from emailId, it just variable even though it is invalid it
	 *                   will send email
	 * @param mailTo     : recipients email id by ";" separated
	 * 
	 */
/*
 * public void sendReportAfterSuiteExecution(String path, String mailFrom,
 * String mailTo) { LOGGER.info(" Start Sending Email...."); String
 * absoluteFilePathOfAttachment = path;
 * LOGGER.debug(absoluteFilePathOfAttachment); LOGGER.debug(" Path " +
 * absoluteFilePathOfAttachment); String subject = "CockpitAutomation Report";
 * String from = mailFrom; String toemail = mailTo; try { sendMail(toemail,
 * subject, from, absoluteFilePathOfAttachment);
 * LOGGER.info(" ************Sent Email To recipients *********");
 * 
 * } catch (Exception e) { LOGGER.info(e.getStackTrace()); } }
 * 
 *//**
	 * 
	 * Method for send email to recipients In Open-shift Environment
	 * 
	 * @author GRANDIS
	 * @param toemail                      : recipients email id , for multiple
	 *                                     provide by using separator ";"
	 * @param subject                      : provide subject for email
	 * @param from                         : provide form email id (if provide
	 *                                     invalid from email mail will sent"
	 * @param absoluteFilePathOfAttachment : path for the attachments
	 * @throws Exception
	 */
/*
 * public void sendMail(final String toemail, final String subject, final String
 * from, final String absoluteFilePathOfAttachment) throws Exception {
 * LOGGER.info("Invoking the Send Mailer"); String smtpHostServer =
 * "smtprelay.rd.corpintra.net"; Properties props = System.getProperties();
 * props.put("mail.smtp.host", smtpHostServer); Session session =
 * Session.getInstance(props, null); String body =
 * "Please find the attached  test reports"; try { MimeMessage msg = new
 * MimeMessage(session); msg.addHeader("Content-type",
 * "text/HTML; charset=UTF-8"); msg.addHeader("format", "flowed");
 * msg.addHeader("Content-Transfer-Encoding", "8bit"); msg.setFrom(new
 * InternetAddress(from, from)); msg.setSubject(subject, "UTF-8");
 * msg.setText(body, "UTF-8"); msg.setDescription(body); msg.setSentDate(new
 * Date()); msg.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse(toemail, false));
 * 
 * MimeBodyPart messageBodyPart = new MimeBodyPart(); Multipart multipart = new
 * MimeMultipart(); FileDataSource source = new
 * FileDataSource(absoluteFilePathOfAttachment);
 * messageBodyPart.setDataHandler(new DataHandler(source));
 * messageBodyPart.setFileName("TestReport.html");
 * multipart.addBodyPart(messageBodyPart); msg.setContent(multipart);
 * Transport.send(msg); LOGGER.info("Email  sent to -  " + toemail); } catch
 * (Exception e) { LOGGER.error("Couldn't send mail to " + toemail +
 * " because of exception : " + e.getLocalizedMessage()); throw e; }
 * 
 * }
 * 
 *//**
	 * Method for store files in the destination i.e Public shared drive
	 * 
	 * @author GRANDIS
	 * @param source:               source path to read the files
	 * @param smbAuth               : smbauth to access the shared drive
	 * @param destiSharedFolderPath : Destination folder to write the files
	 * @throws IOException
	 */
/*
 * 
 * private void fileStoreRec(File source, NtlmPasswordAuthentication smbAuth,
 * String destiSharedFolderPath) throws IOException { File[] listOfFiles =
 * source.listFiles();
 * 
 * for (File file : listOfFiles) { SmbFile smbDir = new
 * SmbFile(destiSharedFolderPath + "/" + file.getName(), smbAuth); if
 * (file.isDirectory()) { if (!smbDir.exists()) { smbDir.mkdir(); }
 * fileStoreRec(file, smbAuth, destiSharedFolderPath + "/" + file.getName()); }
 * else { if (!smbDir.exists()) { SmbFileOutputStream out = null;
 * BufferedInputStream inBuf = null; inBuf = new BufferedInputStream(new
 * FileInputStream(file)); out = (SmbFileOutputStream) smbDir.getOutputStream();
 * byte[] buf = new byte[5242880]; int len; while ((len = inBuf.read(buf)) > 0)
 * { out.write(buf, 0, len); } inBuf.close(); out.close(); } } } }
 * 
 *//**
	 * read the files from the source path and give it to method "fileStoreRec"
	 * 
	 * @author GRANDIS:
	 * @param sourcePath: source path for reading files
	 * @throws IOException
	 */
/*
 * private void storeReportInSharedFolder(String sourcePath) throws IOException
 * { sharedFolderUrl = getProperty("TI_URL"); try { String WiwPwd =
 * PasswordEncryptDcrypt.decrypt(getProperty("WiwPwd"));
 * NtlmPasswordAuthentication smbAuth = getSmbAuth("APAC", "GRANDIS", WiwPwd);
 * LOGGER.info("************shared drive Connection started ***************");
 * File source = new File(sourcePath); fileStoreRec(source, smbAuth,
 * sharedFolderUrl);
 * LOGGER.debug("************Files copied to SharedDrive***************");
 * 
 * } catch (Exception e) { e.printStackTrace(); LOGGER.error(e.getMessage()); }
 * }
 * 
 *//**
	 * Method for create report folder under "Reports" folder with Date& time format
	 * Ex: 26-03-2020 12.03 PM
	 * 
	 * @author GRANDIS
	 * @return : it will return the path of folder which has been created
	 */
/*
 * public String dynamicReportFolderCreation() { Date date = new Date();
 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm a");
 * String reportName = dateFormat.format(date); dynamicReportFolderName =
 * createDir(reportFolderPath, reportName); return dynamicReportFolderName;
 * 
 * }
 * 
 *//***
	 * Method for create folder under given path
	 * 
	 * @author GRANDIS
	 * @param mainFolderPath : path for create folder
	 * @param folderName     : folder name to create in above path
	 * @return: It will return the path of the newly created folder i.e appending
	 *          given path with new folder name
	 */
/*
 * public String createDir(String mainFolderPath, String folderName) { String
 * path = mainFolderPath + folderName + "/"; File file = new File(path); if
 * (!file.exists()) { boolean bool = file.mkdir();
 * LOGGER.info("crated folder successfully with " + path); return path; } else {
 * LOGGER.info("Dynamic Report folder already created"); return path; } }
 * 
 *//**
	 * Method To Authenticate the given shared drive path
	 * 
	 * @author GRANDIS
	 * @param domain   : domain name of the shared drive Ex: APAC
	 * @param username : username to access the shared drive "WID"
	 * @param password : password for access the shared drive
	 * @return : it will return the auth for authentication
	 */
/*
 * 
 * private NtlmPasswordAuthentication getSmbAuth(String domain, String username,
 * String password) { NtlmPasswordAuthentication auth = new
 * NtlmPasswordAuthentication(domain, username, password); return auth; }
 * 
 * public PageFactoryHomePage getPfHomePage() { return pfHomePage; }
 * 
 * public void setPfHomePage(PageFactoryHomePage pfHomePage) { this.pfHomePage =
 * pfHomePage; }
 * 
 * public PageFactoryOverviewScreen getPfOverviewPage() { return pfOverviewPage;
 * }
 * 
 * public void setPfOverviewPage(PageFactoryOverviewScreen pfOverviewPage) {
 * this.pfOverviewPage = pfOverviewPage; }
 * 
 * public PageFactoryLoginPage getPfLoginPage() { return pfLoginPage; }
 * 
 * public void setPfLoginPage(PageFactoryLoginPage pfLoginPage) {
 * this.pfLoginPage = pfLoginPage; }
 * 
 * public PageFactoryUserManagemaentManageDatabasesPage
 * getPfUserManagementManageDatabasesPage() { return manageDatabasesScreen; }
 * 
 * public void setPfUserManagementManageDatabasesPage(
 * PageFactoryUserManagemaentManageDatabasesPage manageDatabasesScreen) {
 * this.manageDatabasesScreen = manageDatabasesScreen; } // public
 * PageFactoryUserManagemaentAddEditDatabasesPage
 * getPfUserManagementAddEditDatabasesPage() { return addEditDatabasesScreen; }
 * 
 * public void setPfUserManagementAddEditDatabasesPage(
 * PageFactoryUserManagemaentAddEditDatabasesPage addEditDatabasesScreen) {
 * this.addEditDatabasesScreen = addEditDatabasesScreen; }
 * 
 * public PageFactoryMapRolesPage getPfMapRolesPage() { return mapRolesScreen; }
 * 
 * public void setPfMapRolesPage(PageFactoryMapRolesPage mapRolesScreen) {
 * this.mapRolesScreen = mapRolesScreen; }
 * 
 * 
 * public void setPfLoginPage(PageFactoryLoginPage pfLoginPage) {
 * this.pfLoginPage=pfLoginPage; }
 * 
 * public void PageFacotryLoginPage getPfLoginPage() { return pfLoginPage; }
 * 
 *//**
	 * @author GRANDIS Method for initialize the property file
	 *//*
		 * public void init() { String ORpath = "TestData.properties"; try { io = new
		 * FileInputStream(ORpath); Prop = new Properties(); Prop.load(io); } catch
		 * (FileNotFoundException e) { e.toString(); } catch (Exception es) {
		 * LOGGER.error(es.getMessage()); }
		 * 
		 * }
		 * 
		 * 
		 * public String getProperty(String propertName) { init(); return
		 * Prop.getProperty(propertName); }
		 * 
		 * public PageFactorySearchCostcenter getSearchCostcenterScreen() { return
		 * searchCostcenterScreen; }
		 * 
		 * public void setSearchCostcenterScreen(PageFactorySearchCostcenter
		 * searchCostcenterScreen) { this.searchCostcenterScreen =
		 * searchCostcenterScreen; }
		 * 
		 * public String getPassWord() { return passWord; }
		 * 
		 * public void setPassWord(String passWord) { this.passWord = passWord; }
		 * 
		 * public ManageCostcentersValueStored getCc() { return cc; }
		 * 
		 * public void setCc(ManageCostcentersValueStored cc) { this.cc = cc; }
		 * 
		 * public PageFactorySearchDatabase getSearchDatabaseScreen() { return
		 * searchDatabaseScreen; }
		 * 
		 * public void setSearchDatabaseScreen(PageFactorySearchDatabase
		 * searchDatabaseScreen) { this.searchDatabaseScreen = searchDatabaseScreen; }
		 * 
		 * public PLAWebRequestAccessPage getRequestAccessPage() { return
		 * plaRequestAccessPage; }
		 * 
		 * public void setPlaRequestAccessPage(PLAWebRequestAccessPage
		 * requestAccessPage) { this.plaRequestAccessPage = requestAccessPage; }
		 * 
		 * public PLAWebHomePage getPlaWebHomePage() { return plaWebHomePage; }
		 * 
		 * public void setPlaWebHomePage(PLAWebHomePage plaWebHomePage) {
		 * this.plaWebHomePage = plaWebHomePage; }
		 * 
		 * public PageFactoryManageRequestAccessPage getManageRequestAccessPage() {
		 * return manageRequestAccessPage; }
		 * 
		 * public void setManageRequestAccessPage(PageFactoryManageRequestAccessPage
		 * manageRequestAccessPage) { this.manageRequestAccessPage =
		 * manageRequestAccessPage; }
		 * 
		 * public void setRequestAccessPage(PageFactoryRequestAccessPage
		 * requestAccessPage) { this.requestAccessPage = requestAccessPage; }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */