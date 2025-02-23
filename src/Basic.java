import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import files.PayLoad;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		validate if ADD place API is working as excpected 
		//given - all input details
		//when - submit the API
		//then - validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		// add place 
		
		// passing payload using JSON FILE <-----> 
		// .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Owner\\Documents\\addPlace.json"))))
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(PayLoad.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("-----" + response + "-----");
		JsonPath js = new JsonPath(response);
		String place_id = js.getString("place_id");
		System.out.println(place_id);
		
		String newAddress = "70 winter walk, USA";
		
		//update place
		given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//get -  there is no point to send header in get method
		String getPlaceResponse = given().log().all().queryParam("Key", "qaclick123")
				.queryParam("place_id",place_id)
		.when().get("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
		.extract().response().asString();
		
		System.out.println("heyyyy----------" + getPlaceResponse);
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
	}

}
