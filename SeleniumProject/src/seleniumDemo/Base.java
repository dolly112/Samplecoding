package seleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		// gecko driver

		//System.setProperty("webdriver.gecko.driver", "/Users/827599/Documents/Sample/Samplecoding/exeFilesUsed/geckodriver.exe");
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/827599/Documents/Sample/Samplecoding/exeFilesUsed/chromedriver.exe");
		//WebDriver driver= new FirefoxDriver(]);
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		
	}

}
