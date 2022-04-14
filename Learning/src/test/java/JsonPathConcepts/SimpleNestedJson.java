package JsonPathConcepts;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SimpleNestedJson {
@Test
public void NestedJson() {
	String response="{\r\n" + 
			"  \"Name\": \"Manickrajan\",\r\n" + 
			"  \"Age\": 35,\r\n" + 
			"  \"Married\": true,\r\n" + 
			"  \"Address\": {\r\n" + 
			"    \"No\": \"90\",\r\n" + 
			"    \"Street\": \"New Street\",\r\n" + 
			"    \"Pincode\": \"629002\"\r\n" + 
			"  }\r\n" + 
			"}";
	
	JsonPath js= new JsonPath(response);
	
	System.out.println(js.getString("Name"));
	System.out.println(js.getInt("Age"));
	System.out.println(js.getBoolean("Married"));
	System.out.println((Object)js.get("Address"));
	System.out.println(js.getString("Address.Street"));
}
}
