import org.testng.Assert;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {


		JsonPath js = new JsonPath(PayLoad.coursePrice());
//		1. Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
//		2.Print Purchase Amount
		int purchasAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchasAmount);
		
//		3. Print Title of the first course
		String tle = js.getString("courses[0].title");
		System.out.println(tle);
//		4. Print All course titles and their respective Prices
		for(int i=0;i<count;i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			
			System.out.println(courseTitles);
		}
		
//		5. Print no of copies sold by RPA Course
		for(int i=0;i<count;i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies = js.get("courses["+i+"].copies");
				System.out.println("---"+copies);
				break;
			}
		}
		
//		6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		for(int i=0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price*copies;
			sum+=amount;
			System.out.println(amount);
			
		}
		Assert.assertEquals(sum, purchasAmount);
		
		
	}

}
