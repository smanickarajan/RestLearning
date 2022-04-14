package JsonPayLoad;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConertJsonArraytoResponsetoMapwithGenerics {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
	List<Map<String, Object>> JsonResponse = RestAssured.given().log().all()
				.get("https://run.mocky.io/v3/d7a147bd-ff77-4deb-b8a8-fce4e8fdf924").as(new TypeRef<List<Map<String,Object>>>() {
				});
		Map<String,Object> emp1=JsonResponse.get(1);
		System.out.println(emp1.get("firstname"));
	}

}
