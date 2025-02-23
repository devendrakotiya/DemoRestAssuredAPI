import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;


public class JiraBugcreateandAttachSC {

	public static void main(String[] args) {
		// Create bug in jira
		RestAssured.baseURI = "https://devendrakotiya1999.atlassian.net";
		String response = given()
		.header("Content-Type","application/json")
		.header("Authorization", "Basic ZGV2ZW5kcmFrb3RpeWExOTk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBSYktGYTZ6a0kwcHNyZnhWVmhicjk5ODAteXE4TjMzd3BwTmJWVVlSTHlLSDQxX09MNGRubmNGbkUxaGRNYm5MVVBWVWZSalR6TlZ3OERWUmJSR3lyTlJKZ2UyOUhuWmgyaGRTY3p2MUphQjlDQUQwSUI2OEN0dWRPbzhObWcxWHlIX21UcTkxNXMxbmlubUxFTkFWQ2Y0ODFRbU8tbUtSTVhBcGJmS3A3RVU9MzNFOTRDQzA=")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"ECS\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"web option are not working\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "")
		.log().all()
		.post("/rest/api/3/issue").then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		JsonPath js = new JsonPath(response);
		String ID = js.getString("id");
		System.out.println(ID);
		
		//Attach sc on jira
		
		given().pathParam("key", ID)
		.header("X-Atlassian-Token", "no-check")
		.header("Authorization", "Basic ZGV2ZW5kcmFrb3RpeWExOTk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBSYktGYTZ6a0kwcHNyZnhWVmhicjk5ODAteXE4TjMzd3BwTmJWVVlSTHlLSDQxX09MNGRubmNGbkUxaGRNYm5MVVBWVWZSalR6TlZ3OERWUmJSR3lyTlJKZ2UyOUhuWmgyaGRTY3p2MUphQjlDQUQwSUI2OEN0dWRPbzhObWcxWHlIX21UcTkxNXMxbmlubUxFTkFWQ2Y0ODFRbU8tbUtSTVhBcGJmS3A3RVU9MzNFOTRDQzA=")
		.multiPart("file",new File("/Users/Rohit/Desktop/2025/Certificates/Screenshot.png"))
		.log().all()
		.post("rest/api/3/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
		
		
	}

}
