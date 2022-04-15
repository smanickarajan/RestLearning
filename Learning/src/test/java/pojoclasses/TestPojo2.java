package pojoclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;

public class TestPojo2 {

	public static void main(String[] args) {
		Employee2 emp=new Employee2();
		Address add1=new Address();
		Address add2=new Address();
		emp.setName("Manick");
		emp.setId(1);
		emp.setSal(100.25);
		emp.setIsmarried(true);
		emp.setMobnos(Arrays.asList("123","456"));
		
		add1.setStreet("New Street");
		add1.setCity("Chennai");
		add1.setCountry("India");
		
		add2.setStreet("Old Street");
		add2.setCity("Trivandrum");
		add2.setCountry("India");
		List<Address> alladd=new ArrayList<>();
		alladd.add(add1);
		alladd.add(add2);
		emp.setUser_address(alladd);
		
		
		RestAssured.given().log().all().body(emp).post();

	}

}
