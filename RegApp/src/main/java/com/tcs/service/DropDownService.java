package com.tcs.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.tcs.models.Country;

@Service
public interface DropDownService {

	public Map<Integer,String> getAllCountries();
	public Map<Integer,String> getStatesByCountry(Integer countryId);
	public Map<Integer,String> getCitiesByState(Integer stateId);
	
}
