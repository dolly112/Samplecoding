import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses()
	{
		// Verify if Sum of all Course prices matches with Purchase Amount
		JsonPath js = new JsonPath(Payload.coursePrice());
		int courseSize = js.getInt("courses.size()");
		int sum=0;
		for(int i=0;i< courseSize;i++)
		
		{
			int courseprice=js.getInt("courses["+i+"].price");
			int courseCopies=js.getInt("courses["+i+"].copies");
			int amount= courseprice * courseCopies;
			System.out.println(amount);
			sum = sum + amount;
			
		}
		System.out.println(sum);
		int purchaseAmount1 = js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount1);
		
	}
	
	
	
	

}
