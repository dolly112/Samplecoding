import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SampleAPIToAutomate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
//		
//	RestAssured.baseURI="https://api.chucknorris.io";	
//	String response= given().log().all().
//			when().get("/jokes/random").
//			then().log().all().
//			assertThat().statusCode(200).toString();
//		
//	JsonPath js= new JsonPath(response)	;
//		String value= js.getString("value");
//		System.out.println("value" + value);
		 RestAssured.baseURI = "https://api.chucknorris.io";

	        Response response = given()
	                .when()
	                .get("/jokes/random")
	                .then()
	                .statusCode(200) // Ensure status code is 200 OK
	                .extract()
	                .response();

	        int statusCode = response.getStatusCode();
	        if (statusCode == 200) {
	            String responseBody = response.getBody().asString();
	            System.out.println("Response Body: " + responseBody);

	            // Now try to parse the JSON only if the response is not empty
	            if (!responseBody.isEmpty()) {
	                String jokeValue = response.jsonPath().getString("value");
	                System.out.println("Chuck Norris Joke: " + jokeValue);
	            } else {
	                System.out.println("Response body is empty");
	            }
	        } else {
	            System.out.println("Failed to fetch Chuck Norris joke. Status code: " + statusCode);
	        }
	    }
	
		
		
	}


