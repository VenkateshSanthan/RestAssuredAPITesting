import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request_AllHeaders {

	@Test()
	public void getAllHeaders() {

		RestAssured.baseURI = "http://reqres.in/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/api/users?page=2");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " + responseBody);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is " + statusCode);

		Headers allHeaders = response.getHeaders();

		for (Header header : allHeaders) {
			System.out.println(header.getName() + " --------->" + header.getValue());
		}

	}

}
