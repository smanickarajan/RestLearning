import io.restassured.RestAssured;

public class MockResponse {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given().log().all().get("https://run.mocky.io/v3/b36a0f42-512e-4b09-b352-f745b7204355").then().log()
				.all();

	}

}
