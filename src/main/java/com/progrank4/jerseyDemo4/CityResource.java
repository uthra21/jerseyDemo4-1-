package com.progrank4.jerseyDemo4;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("cities")
public class CityResource {
	
	CityDao dao = new CityDao();
	
	@GET
	@Path("getCities")
	@Produces(MediaType.APPLICATION_JSON)
	public List<city> getCity() {
		return dao.getAllCity();
	}
	
	@GET
	@Path("getCities/{cityID}")
	@Produces(MediaType.APPLICATION_JSON)
	public city cityByID(@PathParam("cityID") int cityID) {
		city city = dao.getCityByID(cityID);
		if(city == null) {
			throw new CityNotFoundException("Wrong cityID. Check and run again");
		}
		return dao.getCityByID(cityID);
	} 
	
	@POST
	@Path("addCity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<city> addCity(city city) {
	    // Automatically set cityID if not provided
	    if (city.getCityID() == 0) {
	        int newId = dao.getAllCity().size() + 101; // or another logic to determine new ID
	        city.setCityID(newId);
	    }

	    // Check if the city with the provided ID already exists
	    if (dao.getCityByID(city.getCityID()) != null) {
	        throw new CityNotFoundException("City with the given ID already exists. Check and run again");
	    }

	    return dao.createCity(city);
	}

	
	@DELETE
	@Path("deletecities/{cityID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<city> removeCity(@PathParam("cityID") int cityID) {
		city city = dao.getCityByID(cityID);
		if(city == null) {
			throw new CityNotFoundException("Wrong cityID. Check and run again");
		}
		return dao.removeCity(cityID);
	}
	
	@PUT
	@Path("updateCity/{cityID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<city> updateCity(@PathParam("cityID") int cityID, city city) {
	    // Check if the city with the provided ID exists
	    if (dao.getCityByID(cityID) == null) {
	        throw new CityNotFoundException("Wrong city ID. Check and run again");
	    }

	    // Update city information
	    return dao.updateCity(cityID, city.getCityName());
	}

}
