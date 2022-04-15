package ConvertResponsetoPojo;

import io.restassured.RestAssured;

public class TestSimpleJsonResponse {

	public static void main(String[] args) {
		SimpleJSonPojo emp = RestAssured.get("https://run.mocky.io/v3/a6d6fd77-149a-42a0-b318-7e55b41d2cf6")
				.as(SimpleJSonPojo.class);
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getSal());
		System.out.println(emp.isIsmarried());
	}

}
