package stepDefinations;

import java.io.IOException;
import io.cucumber.java.Before;

public class Hooks {
	StepDefination sd = new StepDefination();
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		if(StepDefination.place_id!=null)
			return;
		sd.add_place_payload_with("BurgerKing", "Patna", "Hindi");
		sd.user_calls_with_http_method("addPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("BurgerKing", "getPlaceAPI");
	}

}
