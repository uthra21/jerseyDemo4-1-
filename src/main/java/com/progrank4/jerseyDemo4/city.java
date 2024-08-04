package com.progrank4.jerseyDemo4;

public class city {
	
	
	private int cityID;
	private String cityName;
	
	public int getCityID() {
		return cityID;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public city() {System.out.println("calling");}
	
	public city(int cityID, String cityName) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
