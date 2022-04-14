package JsonPathConcepts;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathWithFIlters {

	public static void main(String[] args) {

		File file = new File("..\\Learning\\src\\test\\java\\JsonPathConcepts\\People.json");
		JsonPath js = new JsonPath(file);
		
		System.out.println(js.getString("[0].Name"));
		List<Object> allnames = js.getList("Name");
		System.out.println(allnames);
		
		List<Object> allfemalnames = js.getList("findAll{it.Gender=='Female'}.Name");
		System.out.println(allfemalnames);
		
		int age = js.getInt("find{it.Name=='DEF' & it.Gender=='Female' }.Age");
		System.out.println(age);
		
		File file1 = new File("..\\Learning\\src\\test\\java\\JsonPathConcepts\\People2.json");
		JsonPath js1 = new JsonPath(file1);
		System.out.println(js1.getString("data[0].Name"));
	}

}
