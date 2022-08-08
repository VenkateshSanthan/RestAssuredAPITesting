import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_POST_Request {
	@Test
	void postRequest() {
		
		RestAssured.basePath = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("Name", "Bjoy");
		requestParams.put("Salary", "$5000");
		requestParams.put("Age", "38");
		requestParams.put("Id", "ACT1234D");
		
		httpRequest.header("Content-type","application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST,"/create");
		String statusCode=response.jsonPath().get("status");
		System.out.println("Status Code is"+statusCode);
		Assert.assertEquals(statusCode, "success");
		
		int statusCode2 = response.getStatusCode();
		System.out.println("Status Code is "+statusCode2);
		
		
		
	
	}

}
