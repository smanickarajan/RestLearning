package ConvertResponsetoPojo;

import io.restassured.RestAssured;

public class TestNestedJsonResponse {

	public static void main(String[] args) {
		NestedJsonPojo emp = RestAssured.get("https://run.mocky.io/v3/07a92459-0e17-4265-873a-4ae40e5693eb")
				.as(NestedJsonPojo.class);
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getSal());
		System.out.println(emp.isIsmarried());
		
		Address add = emp.getAddress();
		System.out.println(add.getCountry());
		
		System.out.println(emp.getAddress().getCity());
	}

}
