package resources;

public enum APIResourse {
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;

	APIResourse(String resource) {
		this.resource = resource;
	}
	
	public String getResource(){
		return resource;
	}

}
