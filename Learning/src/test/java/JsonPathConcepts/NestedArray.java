package JsonPathConcepts;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class NestedArray {
	
	@Test
	public void NestedArrayJson() {
	String response="[\r\n" + 
			"  {\r\n" + 
			"    \"Name\": \"Manickrajan\",\r\n" + 
			"    \"Age\": 35,\r\n" + 
			"    \"Married\": true,\r\n" + 
			"    \"Address\": [\r\n" + 
			"      {\r\n" + 
			"        \"No\": \"90\",\r\n" + 
			"        \"Street\": \"New Street1\",\r\n" + 
			"        \"Pincode\": \"629001\"\r\n" + 
			"      },\r\n" + 
			"      {\r\n" + 
			"        \"No\": \"95\",\r\n" + 
			"        \"Street\": \"New Street2\",\r\n" + 
			"        \"Pincode\": \"629002\"\r\n" + 
			"      }\r\n" + 
			"    ]\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"Name\": \"Test\",\r\n" + 
			"    \"Age\": 30,\r\n" + 
			"    \"Married\": false,\r\n" + 
			"    \"Address\": [\r\n" + 
			"      {\r\n" + 
			"        \"No\": \"80\",\r\n" + 
			"        \"Street\": \"New Street3\",\r\n" + 
			"        \"Pincode\": \"629003\"\r\n" + 
			"      },\r\n" + 
			"      {\r\n" + 
			"        \"No\": \"85\",\r\n" + 
			"        \"Street\": \"New Street4\",\r\n" + 
			"        \"Pincode\": \"629004\"\r\n" + 
			"      }\r\n" + 
			"    ]\r\n" + 
			"  }\r\n" + 
			"]";
	
	JsonPath js= new JsonPath(response);
	
	System.out.println(js.getString("[0].Address[0].Street"));
	System.out.println(js.getString("[1].Address[0].Street"));
	System.out.println(js.getList("[0].Address.Pincode"));
	System.out.println(js.getList("Address.Pincode"));
}
}
