package JsonPayLoad;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateComplexPayload {

	public static void main(String[] args) {
		List<Map<String,Object>>finalpayload=new LinkedList<>();
		Map<String,Object> firstJsonObject=new LinkedHashMap<>();
		firstJsonObject.put("id", 1);
		firstJsonObject.put("firstname", "Manick");
		firstJsonObject.put("IsMarried", true);
		firstJsonObject.put("Salary", 100.25);
		
		List<String> mobilenos=Arrays.asList("12345","89756");
		firstJsonObject.put("mobile", mobilenos);
		Map<String,Object> Skillset=new LinkedHashMap<>();
		Skillset.put("name", "Testing");
		Skillset.put("Proficiency", "Medium");
		firstJsonObject.put("Skills", Skillset);
		finalpayload.add(firstJsonObject);
		
		
		Map<String,Object> seconJsonObject=new LinkedHashMap<>();
		seconJsonObject.put("id", 2);
		seconJsonObject.put("firstname", "Rajan");
		seconJsonObject.put("IsMarried", false);
		seconJsonObject.put("Salary", 60.25);
		List<Map<String,Object>>skilllist=new LinkedList<>();
		Map<String,Object> Skillset1=new LinkedHashMap<>();
		Skillset1.put("name", "Testing");
		Skillset1.put("Proficiency", "Medium");
		skilllist.add(Skillset1);
		Map<String,Object> javaskill=new LinkedHashMap<>();
		javaskill.put("Java", "Testing");
		javaskill.put("Proficiency", "Medium");
		List<String> certfications=Arrays.asList("OCP11","OCP12");
		javaskill.put("certfications", certfications);
		skilllist.add(javaskill);
		seconJsonObject.put("Skills", skilllist);
		finalpayload.add(seconJsonObject);
		
		RestAssured.given().log().all().body(finalpayload).get();
	}

}
