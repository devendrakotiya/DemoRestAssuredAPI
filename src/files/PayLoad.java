package files;

public class PayLoad {
	public static String addPlace()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String coursePrice()
	{
		String jsonBody = "{\n" +
	            "  \"dashboard\": {\n" +
	            "    \"purchaseAmount\": 910,\n" +
	            "    \"website\": \"rahulshettyacademy.com\"\n" +
	            "  },\n" +
	            "  \"courses\": [\n" +
	            "    {\n" +
	            "      \"title\": \"Selenium Python\",\n" +
	            "      \"price\": 50,\n" +
	            "      \"copies\": 6\n" +
	            "    },\n" +
	            "    {\n" +
	            "      \"title\": \"Cypress\",\n" +
	            "      \"price\": 40,\n" +
	            "      \"copies\": 4\n" +
	            "    },\n" +
	            "    {\n" +
	            "      \"title\": \"RPA\",\n" +
	            "      \"price\": 45,\n" +
	            "      \"copies\": 10\n" +
	            "    }\n" +
	            "  ]\n" +
	            "}";
		
		return jsonBody;
	}
	
	public static String Addbook(String isbn, String aisle)
	{
		String PayLoad =  "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return PayLoad;
	}
	
	
	
	
}
