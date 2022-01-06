package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumDemo {
	
	public static void main(String[] args) {
	
	
	//System.setProperty("webdriver.chrome.driver", "/Users/827599/Documents/Sample/Samplecoding/exeFilesUsed/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/Users/827599/Downloads/chromedriver");
	
	WebDriver driver= new ChromeDriver();
	
	driver.get("https://demoqa.com/");
//    driver.findElement(By.xpath("//div[@class='category-cards']/div[2]")).click();
//	WebElement value= driver.findElement(By.xpath("//div[@class='row']/div[2]"));
//    String PleaseGetText =value.getText();
//    System.out.println(PleaseGetText);
   // Assert.assertEquals(PleaseGetText,"Please select an item from left to start practice.");
	
	
	driver.findElement(By.xpath("//div[@class='category-cards']/div[6]")).click();
	WebElement header= driver.findElement(By.xpath("//div[@class='rt-tr'/div]"));
     String HeaderDetailsinText =header.getText();
    System.out.println(HeaderDetailsinText);
    
  
    
    
    
    
  /*  add()
    
    
	add(int 2, int 3)
	
	
	
	add(int 5,int 6)  8  8 */
	
	
	
	
	}	

}
