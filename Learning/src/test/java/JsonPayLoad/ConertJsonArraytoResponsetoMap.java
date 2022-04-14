package JsonPayLoad;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class ConertJsonArraytoResponsetoMap {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		List<Object> JsonResponse = RestAssured.given().log().all()
				.get("https://run.mocky.io/v3/d7a147bd-ff77-4deb-b8a8-fce4e8fdf924").as(List.class);
		Map<String, Object> emp1 = (Map<String, Object>) JsonResponse.get(0);
		System.out.println(emp1.get("firstname"));
	}

}
