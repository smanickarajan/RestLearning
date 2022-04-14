package JsonPathConcepts;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathRootnode {
@Test
public void JsonPathextract() {
	String response="{\r\n" + 
			"    \"firstname\": \"Jim\",\r\n" + 
			"    \"lastname\": \"Jackson\",\r\n" +
			"}";
	
	JsonPath js=new JsonPath(response);
	System.out.println((Object)js.get("$"));
	System.out.println((Object)js.get(""));
	System.out.println((Object)js.getString("$"));
	System.out.println((Object)js.getString(""));
}
}
