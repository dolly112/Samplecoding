package files;

public class Payload {

	public static String AddPlacePayload()
	{
		return "{\n" + 
				"  \"location\": {\n" + 
				"    \"lat\": -38.383494,\n" + 
				"    \"lng\": 33.427362\n" + 
				"  },\n" + 
				"  \"accuracy\": 50,\n" + 
				"  \"name\": \"Bungalow house\",\n" + 
				"  \"phone_number\": \"(+91) 883 333 3333\",\n" + 
				"  \"address\": \"11, wide layout, cohen 09\",\n" + 
				"  \"types\": [\n" + 
				"    \"chill park\",\n" + 
				"    \"shop\"\n" + 
				"  ],\n" + 
				"  \"website\": \"http://google.com\",\n" + 
				"  \"language\": \"French-IN\"\n" + 
				"}";
	}
	
	public static String coursePrice()
	{
		return"{\n" + 
				"\"dashboard\": {\n" + 
				"\"purchaseAmount\": 135,\n" + 
				"\"website\": \"rahulshettyacademy.com\"\n" + 
				"},\n" + 
				"\"courses\": [\n" + 
				"{\n" + 
				"\"title\": \"Selenium Python\",\n" + 
				"\"price\": 50,\n" + 
				"\"copies\": 6\n" + 
				"},\n" + 
				"{\n" + 
				"\"title\": \"Cypress\",\n" + 
				"\"price\": 40,\n" + 
				"\"copies\": 4\n" + 
				"},\n" + 
				"{\n" + 
				"\"title\": \"RPA\",\n" + 
				"\"price\": 45,\n" + 
				"\"copies\": 10\n" + 
				"}\n" + 
				"]\n" + 
				"}\n" + 
				"";
	}
	
	
}
