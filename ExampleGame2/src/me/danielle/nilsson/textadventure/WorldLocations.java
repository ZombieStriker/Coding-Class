package me.danielle.nilsson.textadventure;

public enum WorldLocations {

	RIVER("A Toxic River", "You travel near a river of toxic sludge."),
	DESTROYED_TOWN("A Destroyed Town","You look around and see remnants of the old world"),
	GAS_STATION("A Gas Station", "You see an empty gas station."),
	WASTELAND("An Empty Wasteland"," There is nothing past this point"),
	MOUNTAINS("Mountains",false),
	;

	String locationName;
	String travelToMessage;
	boolean traverseable = true;

	WorldLocations(String l1, String l2){
		locationName = l1;
		travelToMessage = l2;
	}
	WorldLocations(String l1, boolean traverseable){
		locationName = l1;
		this.traverseable = traverseable;
	}
	public boolean canGoTo(){
		return traverseable;
	}
	public String getLocationName(){
		return locationName;
	}
	public String getTravelToMessage(){
		return travelToMessage;
	}
}
