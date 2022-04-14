package JsonPayLoad;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateSimpleJsonObject {

	public static void main(String[] args) {
		Map<String,String> jsonpayload=new HashMap<>();
		jsonpayload.put("id", "1");
		jsonpayload.put("firstname", "Manick");
		jsonpayload.put("IsMarried", "true");
		jsonpayload.put("Salary", "100.25");
		RestAssured.given().log().all().body(jsonpayload).get();

	}

}
