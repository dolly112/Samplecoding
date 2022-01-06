
package seleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	
	public static void main(String[] args) throws InterruptedException 
	
	{
		//System.setProperty("webdriver.chrome.driver", "/Users/827599/Documents/Sample/Samplecoding/exeFilesUsed/chromedriver");
		System.setProperty("webdriver.chrome.driver", "/Users/827599/Downloads/chromedriver");
		// /Users/827599/eclipse-workspace-2/SeleniumProject/driver
		//System.setProperty("webdriver.chrome.driver", "/Users/827599/eclipse-workspace-2/SeleniumProject/driver/chromedriver.exe");
		//System.out.println("--------------sys->"+System.getProperty("webdriver.chrome.driver"));
		WebDriver driver= new ChromeDriver();
	
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("Selenium");
		Thread.sleep(3000);
		List<WebElement> values= driver.findElements(By.xpath("//*[@role='listbox']/li")); ////*[@class='aajZCb']
		
		//System.out.println(values);
		for(int i=0;i<values.size();i++)
		{
			//WebElement value= driver.findElement(By.className("G43f7e"));
			String store= values.get(i).getText().trim();
			//System.out.println(store);	
			if (store.equals("selenium ide"))
			{
				System.out.println("matching words"+store);	
			}
//			else
//			{
//				System.out.println("No matching words");
//				System.out.println(store);
//			}
//		
	/*	for (WebElement webElement : values) {  //ctrl+ space after entering for 
			
			if(webElement.getText().trim().equals("selenium ide"))
			{	
				
				webElement.click();
				break;
			}*/
			
		}
				
				
		}
		
	
		
		
	


	
	}

