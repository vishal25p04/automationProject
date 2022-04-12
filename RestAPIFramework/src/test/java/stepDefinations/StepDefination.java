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
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place payload")
	public void add_place_payload() throws IOException {		
		res = given().spec(reqSpecification()).body(data.addPlacePayLoad());	
	}
	
	@When("user calls {string} with Post http method")
	public void user_calls_with_post_http_method(String string) {
		response = res.when().post("/maps/api/place/add/json").then().spec(resSpecification()).
				extract().response();
	}
	
	@Then("the API call got success with status {int}")
	public void the_api_call_got_success_with_status(int int1) {
		assertEquals(response.getStatusCode(), int1);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		JsonPath js =new JsonPath(response.asString());
		assertEquals(js.getString(key), value);
	}

}
