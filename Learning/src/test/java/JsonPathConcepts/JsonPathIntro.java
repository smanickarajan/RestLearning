package JsonPathConcepts;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathIntro {
@Test
public void JsonPathextract() {
	String response="{\r\n" + 
			"    \"firstname\": \"Jim\",\r\n" + 
			"    \"lastname\": \"Jackson\",\r\n" + 
			"    \"totalprice\": 937,\r\n" + 
			"    \"depositpaid\": true,\r\n" + 
			"    \"bookingdates\": {\r\n" + 
			"        \"checkin\": \"2015-12-07\",\r\n" + 
			"        \"checkout\": \"2017-11-17\"\r\n" + 
			"    }\r\n" + 
			"}";
	
	JsonPath js=new JsonPath(response);
	String lastname=js.getString("lastname");
	System.out.println(lastname);
	
	Object lname = js.get("lastname");
	System.out.println(lname);
	
	Object totalprice = js.get("totalprice");
	System.out.println(totalprice);
	
	Object depositpaid = js.get("depositpaid");
	System.out.println(depositpaid);
}
}
