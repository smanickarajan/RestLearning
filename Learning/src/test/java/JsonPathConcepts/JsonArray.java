package JsonPathConcepts;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonArray {
	@Test
	public void NestedJson() {
		String response="[\r\n" + 
				"  [\r\n" + 
				"    \"10\",\r\n" + 
				"    \"20\",\r\n" + 
				"    \"30\"\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    \"100\",\r\n" + 
				"    \"200\",\r\n" + 
				"    \"300\",\r\n" + 
				"    \"400\"\r\n" + 
				"  ]\r\n" + 
				"]";
		
		JsonPath js= new JsonPath(response);
		
		System.out.println(js.getString("$"));
		System.out.println(js.getString("[1]"));
		System.out.println(js.getString("[1][2]"));
		System.out.println(js.getList("$").size());
		
		List<Object> internallist = (List<Object>) js.getList("$").get(1);
		
		System.out.println(internallist.size());
}
}
