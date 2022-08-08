import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_GET_Request {
	@Test
	void getEmployeeDetail() {
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "employee/5");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,	200);
		System.out.println("Status Code is "+statusCode);
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("Status Line is "+statusLine);
	
	
	
	}

}
