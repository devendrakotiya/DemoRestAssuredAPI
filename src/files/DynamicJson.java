package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all()
				.header("Content-Type","application/json")
				.body(PayLoad.Addbook(isbn, aisle))
				.when()
				.post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
//		System.out.print(response);
		
			JsonPath js = new JsonPath(response);
			String ID = js.get("ID");
			System.out.println(ID);
		
	}

	@DataProvider(name = "BooksData")
	public Object[][] getdata()
	{
		return new Object[][] {{"hjjcd", "4563"},{"gfhcv","6787"}, {"bhxs","9857"}};
	}
	}

