package pojoclasses;

import java.util.Arrays;

import io.restassured.RestAssured;

public class TestPojo {

	public static void main(String[] args) {
		Employee emp=new Employee();
		Address add=new Address();
		emp.setName("Manick");
		emp.setId(1);
		emp.setSal(100.25);
		emp.setIsmarried(true);
		emp.setMobnos(Arrays.asList("123","456"));
		
		add.setStreet("New Street");
		add.setCity("Chennai");
		add.setCountry("India");
		
		emp.setUser_address(add);
		
		RestAssured.given().log().all().body(emp).post();

	}

}
