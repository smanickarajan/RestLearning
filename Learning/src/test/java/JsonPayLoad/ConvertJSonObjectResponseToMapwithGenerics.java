package JsonPayLoad;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJSonObjectResponseToMapwithGenerics {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		Map<String,Object> JsonResponse = RestAssured.given().log().all()
				.get("https://run.mocky.io/v3/ab5dace0-5ad6-4e2f-bbf8-f046df7ea2d8")
				.as(new TypeRef<Map<String, Object>>() {
				});
		String firstname = JsonResponse.get("firstname").toString();
		System.out.println(firstname);

		Set<Entry<String, Object>> Keyset = JsonResponse.entrySet();
		
		for (Entry<String, Object> e:Keyset) {
			System.out.println(e);
		}
		
	}

}
