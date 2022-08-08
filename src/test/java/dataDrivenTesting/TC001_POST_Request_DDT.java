package dataDrivenTesting;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_POST_Request_DDT {

	@Test(dataProvider = "empdataprovider")
	void postNewEmployee(String ename, String eage, String esal) {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", esal);
		requestParams.put("age", eage);

		httpRequest.header("content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "/create");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " + responseBody);

//		Assert.assertEquals(responseBody.contains(ename), true);
//		Assert.assertEquals(responseBody.contains(esal), true);
//		Assert.assertEquals(responseBody.contains(eage), true);

		int statusCode = response.getStatusCode();
		System.out.println("Status Code Is :" + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@DataProvider(name = "empdataprovider")
	String[][] getEmpData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/dataDrivenTesting/New_Employee_Detail.xlsx";
		int rowCount = XLUtil.getRowCount(path, "Sheet1");
		System.out.println("Row Count is :"+rowCount);
		int cellCount = XLUtil.getCellCount(path, "Sheet1", 1);
		System.out.println("Cell Count is :"+cellCount);
		
		String empData[][] = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j<cellCount; j++) {
				empData[i-1][j] = XLUtil.getCellData(path,"Sheet1", i, j);
			}
		}
		return empData;

	}
}
