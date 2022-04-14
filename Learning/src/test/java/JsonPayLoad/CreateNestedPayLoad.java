package JsonPayLoad;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateNestedPayLoad {

	public static void main(String[] args) {
		Map<String,Object> jsonpayload=new LinkedHashMap<>();
		jsonpayload.put("id", 1);
		jsonpayload.put("firstname", "Manick");
		jsonpayload.put("IsMarried", true);
		jsonpayload.put("Salary", 100.25);
		
		Map<String,Object> addressmap=new LinkedHashMap<>();
		addressmap.put("No", "10");
		addressmap.put("Street", "New Street");
		addressmap.put("Pincode", "629002");
		jsonpayload.put("address", addressmap);
		RestAssured.given().log().all().body(jsonpayload).get();

	}

}
