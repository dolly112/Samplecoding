import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*; //for given

public class DynamicJson {
	
	String id;
	@Test(dataProvider="bookData")
	public void addBook(String getisbn, String getaisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response= given().log().all().header("Content-Type","application/json")
		.body(Payload.addBook(getisbn, getisbn))
	    .when()
	    .post("/Library/Addbook.php")
		.then().log().all().statusCode(200).extract().response().asString();
		JsonPath js=new JsonPath(response);
		 id=js.get("ID");  //get by default is considered as string or getstring can be used
		System.out.println(id);
		
		}
	
	@DataProvider(name="bookData")
	public Object[][] getData()
	{
		return new Object[][] { {"errer","3434"}, {"fdgfg","54354"}, {"grere", "4534"} };
		
		
	}
	
	@Test
	public void deleteBook()
	{
	RestAssured.baseURI="http://216.10.245.166";
	String response= given().log().all().header("Content-Type","application/json")
	.body("{\n"
			+ " \n"
			+ "\"ID\" : \""+id+"\"\n"
			+ " \n"
			+ "} ")
	.when()
	.post("/Library/DeleteBook.php")
	.then().assertThat().statusCode(200).extract().toString();
	JsonPath js= new JsonPath(response);
	String output= js.get("Msg");
	System.out.println(output);
	
}
	
	
	
	
	
	
	
	
	

}
/*
 * send dynamic json as 
 * 1.hard cord in body
 * 2.use data param
 * 
 * 
 * */
