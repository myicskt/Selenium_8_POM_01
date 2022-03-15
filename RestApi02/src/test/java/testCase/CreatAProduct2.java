package testCase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreatAProduct2 {

	@Test
	public void readAProduct() {
		/*given: all input details(base URI,Headers,Payload/Body,QueryParameters)
		when:  submit api requests(Http method,Endpoint/Resource)
		then:  validate response(status code, Headers, responseTime, Payload/Body)

		"name": "Sanmsung Galaxy s21.1",
    	"price": "649",
    	"description": "Best then s21",
    	"category_id": 2
}
*/
	Response response =
		given()
		.baseUri("http://techfios.com/api-prod/api/product")
		.header("Content-Type","application/json; charset=UTF-8")
		.
		.queryParam("id", "2941")
		//.auth().preemptive().basic("userName", "password").
		.header("Aauthorization", "Bearejfjfjfj").
	when()
		.post("/create.php"). 
	then()
	.extract().response();
	
	int actualStatusCode= response.getStatusCode();
	System.out.println(actualStatusCode);
	Assert.assertEquals(actualStatusCode, 200);
	
	String acutualHeader= response.getHeader("Content-Type");
	Assert.assertEquals(acutualHeader, "application/json; charset=UTF-8");
	
	
	String responseBody =response.getBody().asString();
	System.out.println("Responce Body" + responseBody);
	
	JsonPath jp = new JsonPath(responseBody);
	
	String productId =jp.getString("message");
	System.out.println("product massage : "+message);
	Assert.assertEquals(productId, "message");
	
	String productPrice =jp.getString("price");
	System.out.println("product price : "+productPrice);
	Assert.assertEquals(productPrice, "199");
	
	}

}
