import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*; // needed for given()
import static org.hamcrest.Matchers.*; // for equalTo 

import org.testng.Assert;

import files.Payload;
import files.ReusableMethods;

public class Basics {

	public static void main(String[] args) {
		// rest assured works on -> given, when, then
		//given-take all input details 
		// when-submit the API - like get/ post all (resource and http method will go under "when") -remaining all will go under "given"
		//Then- validate the response -what all validations done
		
		//validate Add place API
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlacePayload())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")) //equalTo - hamcrest import needed
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
       //ToDo //Add place ->Update place with new address-> Get Place to validate if new address is present in response
		//To extract response string
		JsonPath js=new JsonPath(response); //for parsing Json, which takes input as string
		String placeid= js.getString("place_id");
		System.out.println(placeid); 
		
	  //update place API
		String newAddress="Summer Walk, Africa";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		
		
		//get place API
		String getPlaceresponse= given().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	    .when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).body("address", equalTo(newAddress)).extract().response().asString();
		 
		/* JsonPath js1= new JsonPath(getPlaceresponse); //for parsing json
		String actualAddress= js1.getString("address");     //can be written as below line 55 and 56//  */
		
		JsonPath json= ReusableMethods.rawToJson(getPlaceresponse); //classname.method
		String actualAddress= json.getString("address");
		
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
		
		
		
		
		
		
		
		
		
	
	}

}
