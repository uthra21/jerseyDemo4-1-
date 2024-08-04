package com.progrank4.jerseyDemo4;

import java.util.*;
import java.util.stream.Collectors;

public class CityDao {
	
	List<city> cities;
	public CityDao() {
		cities = new ArrayList<city>();
		city city1 = new city(101, "Banglore");
		city city2 = new city(102, "Noida");
		city city3 = new city(103, "Chennai");
		
		cities.addAll(Arrays.asList(city1,city2,city3));
	}
	
	public List<city> getAllCity(){
		return cities;
	}
	
	public city getCityByID(int cityID){
		List<city> result = cities.stream().filter(x->x.getCityID() == cityID)
		.collect(Collectors.toList());
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public List<city> createCity(city city){
		cities.add(city);
		return cities;
	}
	
	public List<city> removeCity(int id){
		city city = getCityByID(id);
		if(city != null) {
			cities.remove(city);
		}
		return cities;
		
	}
	
	public List<city> updateCity(int id, String cityName){
		city city = getCityByID(id);
		if(city != null) {
			city.setCityName(cityName);
		}
		return cities;
	}	
}
