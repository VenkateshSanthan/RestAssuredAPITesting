import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_Validating_JSONResponse {

	@Test
	public void validatingJSONResponse() {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/employee/1");
		JsonPath jsonpath = response.jsonPath();
//		System.out.println(jsonPath.get("body"));
		System.out.println(jsonpath.get("id"));
//		System.out.println(jsonPath.get("name"));
//		System.out.println(jsonPath.get("year"));
//		System.out.println(jsonPath.get("color"));
//		System.out.println(jsonPath.get("pantone_value"));
	
	
	
	}

}
