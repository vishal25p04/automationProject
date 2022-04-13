package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResourse;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String language) throws IOException {
		res = given().spec(reqSpecification()).body(data.addPlacePayLoad(name,address,language));
	}
	
	@When("user calls {string} with {string} http method")
	public void user_calls_with_http_method(String resource, String httpMethod) {
		APIResourse resAPI = APIResourse.valueOf(resource);
		System.out.println(resAPI.getResource());
		
		if(httpMethod.equalsIgnoreCase("POST"))
			response = res.when().post(resAPI.getResource());
		else if(httpMethod.equalsIgnoreCase("GET"))
			response = res.when().get(resAPI.getResource());
	}
	
	@Then("the API call got success with status {int}")
	public void the_api_call_got_success_with_status(int int1) {
		response.then().spec(resSpecification());
		assertEquals(response.getStatusCode(), int1);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		JsonPath js =new JsonPath(response.asString());
		assertEquals(js.getString(key), value);
	}

}
