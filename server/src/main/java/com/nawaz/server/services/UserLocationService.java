package com.nawaz.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawaz.server.models.Location;
import com.nawaz.server.repo.UserLocationRepo;

@Service
public class UserLocationService  {
	@Autowired
	UserLocationRepo locationRepo;
	
	public Location create(Location locationReq) {		
		boolean res = locationRepo.createLocation(locationReq);
		System.out.println("res : "+res);
		
		return locationReq;
	}
	
	public Location update(Location locationReq) {		
		boolean res = locationRepo.updateLocation(locationReq);
		System.out.println("res : "+res);

		return locationReq;
	}
	
	public List<Location> get() {		
		List<Location> res = locationRepo.getAllLocations();
		System.out.println("res : "+res);
				
		return res;
	}

	public Location get(int id) {		
		Location res = locationRepo.getLocationById(id);
		System.out.println("res : "+res);
		
		return res;
	}

	public String delete(int id) {		
		boolean res = locationRepo.deleteLocation(id);
		System.out.println("res : "+res);
		
		return "Location Delete Response is "+res;
	}

}
