package resources;

import java.util.ArrayList;
import java.util.List;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad() {
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
		return place;
	}

}
