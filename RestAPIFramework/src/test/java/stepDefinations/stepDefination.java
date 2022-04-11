package stepDefinations;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class stepDefination {
	
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	
	@Given("Add Place payload")
	public void add_place_payload() {
		RestAssured.baseURI="https://rahushettyacademy.com";
		
		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setName("FrontLine");
		place.setPhone_number("(+91) 983 893 3930");
		place.setAddress("29, side Layout");
		place.setWebsite("www.google.com");
		place.setLanguage("English");
		
		List<String> list = new ArrayList<>();
		list.add("Shoe Park");
		list.add("Shop");
		place.setTypes(list);
		
		Location loc = new Location();
		loc.setLat(-40.234567);
		loc.setLng(33.876823); 
		place.setLocation(loc);
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).
		expectStatusCode(200).build();
		
		res = given().spec(req).body(place);
		
		//System.out.println(response.asString());
	}
	
	@When("user calls {string} with Post http method")
	public void user_calls_with_post_http_method(String string) {
		response = res.when().post("/maps/api/place/add/json").then().spec(resSpec).
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
