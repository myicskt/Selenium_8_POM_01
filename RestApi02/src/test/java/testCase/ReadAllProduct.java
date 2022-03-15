package testCase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ReadAllProduct {

	@Test
	public void readAllProduct() {
		/*given: all input details(base URI,Headers,Payload/Body,QueryParameters)
		when:  submit api requests(Http method,Endpoint/Resource)
		then:  validate response(status code, Headers, responseTime, Payload/Body)
*/
	Response response =
		given()
		.baseUri("http://techfios.com/api-prod/api/product")
		.header("Content-Type","application/json; charset=UTF-8").
	when()
		.get("/read.php"). 
	then()
	.extract().response();
	
	int actualStatusCode= response.getStatusCode();
	System.out.println(actualStatusCode);
	Assert.assertEquals(actualStatusCode, 200);
	
	String acutualHeader= response.getHeader("Content-Type");
	Assert.assertEquals(acutualHeader, "application/json; charset=UTF-8");
	
	
		
		
	}

}
