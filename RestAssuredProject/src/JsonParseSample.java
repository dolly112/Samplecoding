import java.util.Iterator;

import org.testng.Assert;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class JsonParseSample {

	public static void main(String[] args) {

		
		
		JsonPath js= new JsonPath(Payload.getResponse());
		//1. Print No of courses returned by API
		int courseSize= js.get("courses.size()");
		// 2.Print Purchase Amount
		System.out.println(js.get("dashboard.purchaseAmount").toString()); 
		//3. Print Title of the first course
		System.out.println(js.get("courses[0].title").toString());
		//4. Print All course titles and their respective Prices
		
		for(int i=0; i< courseSize; i++)
		{
			
		String cTitle= js.get("courses["+i+"].title");	
		int cPrice=	js.get("courses["+i+"].price");
		
			
		System.out.println("cTitle" +cTitle );
		System.out.println("cPrice" +cPrice );
		}
		// 5. Print no of copies sold by RPA Course
		for(int i=0; i< courseSize ; i++)
		{
		String title= js.get("courses["+i+"].title").toString();	
		if(title.equals("RPA"))
		System.out.println(js.getString("courses["+i+"].price"));
			
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		
		int purchaseAmount =js.get("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		
		int cost=0;	
		for(int i=0; i< courseSize; i++)
		{
		int price= js.get("courses["+i+"].price");	
		int copies= js.get("courses["+i+"].copies");	
			
		cost = cost + (price*copies);
		
		}
		System.out.println(cost);
		Assert.assertEquals(cost, purchaseAmount);
			
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
