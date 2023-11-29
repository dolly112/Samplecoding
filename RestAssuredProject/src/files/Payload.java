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
				"\"purchaseAmount\": 910,\n" + 
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
	public static String addBook(String isbn,String aisle)
	{
		String payload="{\n"
				+ "\n"
				+ "\"name\":\" Appium Automation with Java\",\n"
				+ "\"isbn\":\""+isbn+"\",\n"
				+ "\"aisle\":\""+aisle+"\",\n"
				+ "\"author\":\"John foe\"\n"
				+ "}";
		return payload;
	}
	
	public static String getResponse()
	{
		
	return "{\r\n"
			+ "\r\n"
			+ "\"dashboard\": {\r\n"
			+ "\r\n"
			+ "\"purchaseAmount\": 910,\r\n"
			+ "\r\n"
			+ "\"website\": \"rahulshettyacademy.com\"\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "\"courses\": [\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"Selenium Python\",\r\n"
			+ "\r\n"
			+ "\"price\": 50,\r\n"
			+ "\r\n"
			+ "\"copies\": 6\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"Cypress\",\r\n"
			+ "\r\n"
			+ "\"price\": 40,\r\n"
			+ "\r\n"
			+ "\"copies\": 4\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"RPA\",\r\n"
			+ "\r\n"
			+ "\"price\": 45,\r\n"
			+ "\r\n"
			+ "\"copies\": 10\r\n"
			+ "\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "]\r\n"
			+ "\r\n"
			+ "}";
		
	}
	
	
}
