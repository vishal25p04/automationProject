package resources;

import java.util.ArrayList;
import java.util.List;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name, String address, String language) {
		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setName(name);
		place.setPhone_number("(+91) 983 893 3930");
		place.setAddress(address);
		place.setWebsite("www.google.com");
		place.setLanguage(language);
		
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
