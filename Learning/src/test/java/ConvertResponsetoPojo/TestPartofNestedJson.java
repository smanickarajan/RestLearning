package ConvertResponsetoPojo;

import io.restassured.RestAssured;

public class TestPartofNestedJson {

	public static void main(String[] args) {
		Address add = RestAssured.get("https://run.mocky.io/v3/07a92459-0e17-4265-873a-4ae40e5693eb")
				.jsonPath()
				.getObject("address", Address.class);
		
		
		
		System.out.println(add.getCountry());
		
	

	}

}
