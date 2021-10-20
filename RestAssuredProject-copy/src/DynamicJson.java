import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	
	@Test
	public void addBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		given().header("Content-Length","application/json").body("{\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\n" + 
				"\"isbn\":\"bcd\",\n" + 
				"\"aisle\":\"227\",\n" + 
				"\"author\":\"John foe\"\n" + 
				"}")
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
