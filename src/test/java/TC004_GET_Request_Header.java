import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request_Header {
	@Test
	void getHeader() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body " + responseBody);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is " + statusCode);

		String header = response.header("Transfer-Encoding");
		Assert.assertEquals(header, "chunked");
		System.out.println("Header 1 is " + header);

		String header2 = response.header("Via");
		Assert.assertEquals(header2, "1.1 vegur");
		System.out.println("Header 2 is " + header2);
		
	}

}
