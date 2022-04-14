package JsonPayLoad;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateSimpleJsonArray {

	public static void main(String[] args) {
		Map<String,Object> empDetails=new LinkedHashMap<>();
		empDetails.put("id", 1);
		empDetails.put("firstname", "Manick");
		empDetails.put("IsMarried", true);
		empDetails.put("Salary", 100.25);
		
		Map<String,Object> empDetails1=new LinkedHashMap<>();
		empDetails1.put("id", 2);
		empDetails1.put("firstname", "Rajan");
		empDetails1.put("IsMarried", false);
		empDetails1.put("Salary", 50.25);
		
		List<Map<String,Object>> allempdetails=new ArrayList<>();
		allempdetails.add(empDetails);
		allempdetails.add(empDetails1);
		RestAssured.given().log().all().body(allempdetails).get();
		

	}

}
