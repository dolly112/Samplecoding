import org.testng.Assert;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Notes when output is in double quotes, its a string else a integer

		JsonPath js = new JsonPath(Payload.coursePrice());
		// Print No of courses returned by API
		int countOfCourses = js.getInt("courses.size()"); // get size from Array
		System.out.println(countOfCourses); // o/p is intgr because not in double quotes
		// Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		// Print Title of the first course
		String titleOfFirstCourse = js.get("courses[0].title");
		System.out.println(titleOfFirstCourse);
		// Print All course titles and their respective Prices

		for (int i = 0; i < countOfCourses; i++)

		{
			System.out.println("************print all courses*****************");
			String courseTitle = js.getString("courses[" + i + "].title"); // i varaible to write in string, +
			System.out.println(courseTitle);
			int coursePrice = js.getInt("courses[" + i + "].price"); // get or getString also will work here
			System.out.println(coursePrice);

			System.out.println("***************Can also be written as*******************");
			String courseTitle2 = js.get("courses[" + i + "].title"); // the output we have to know what type it is so
																		// storing as string in a variable
			System.out.println(courseTitle2);

			// sys always expects string argument, so we are converting to string else we will get error
			System.out.println(js.get("courses[" + i + "].price").toString()); // we no need to store as we are
																				// directly converting what we are
																				// getting as
			// String

		}
		System.out.println("*************************");
		// Print total no of copies sold
		int courseSize = js.getInt("courses.size()");
		int empty = 0;
		for (int i = 0; i < courseSize; i++) {
			int copies = js.getInt("courses[" + i + "].copies");
			empty = empty + copies;

		}
		System.out.println("Total copies are:" + empty);

		System.out.println("*************************");
		System.out.println(js.get("courses[2].copies").toString());
		int RPAcopies = js.getInt("courses[2].copies");
		System.out.println(RPAcopies);

		System.out.println("**********Another way***************");

		for (int i = 0; i < courseSize; i++) {
			// get titile //equals RPA//print copies
			System.out.println(js.getString("courses[" + i + "].title").toString());
			if (js.get("courses[" + i + "].title").equals("RPA")) {  //equals or equalsIgnorecase
				
				System.out.println(js.get("courses[" + i + "].copies").toString());
				break; //come out of the loop if we found it, no need to contimue next iteration
			} 
		}

		// Verify if Sum of all Course prices matches with Purchase Amount

		int prizesize = js.getInt("courses.size()");
		int empty2 = 0;
		for (int i = 0; i < prizesize; i++) {
			int price = js.getInt("courses[" + i + "].price");
			System.out.println(price);
			empty2 = empty2 + price;

		}
		int priceTotal = empty2;
		int purchaseAmount1 = js.get("dashboard.purchaseAmount");
		Assert.assertEquals(priceTotal, purchaseAmount1);

	
	
	
	
	
	}}
