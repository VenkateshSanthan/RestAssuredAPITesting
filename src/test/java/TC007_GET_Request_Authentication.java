import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_GET_Request_Authentication {

	public void getRequestAuthentication() {
		
		RestAssured.baseURI="";	
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		
		authScheme.setUserName("venkat1423");
		authScheme.setPassword("nsy92");
		
		RestAssured.authentication = authScheme;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/hju");
		ResponseBody responseBody = response.getBody();
		System.out.println("Response Body is :"+responseBody);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is :"+statusCode);
		
		String statusLine=response.getStatusLine();
		Assert.assertEquals(statusLine, "nnkjas");
		System.out.println("Status Line is :"+statusLine);
		
		
		
		
		
		
		
	}

}
