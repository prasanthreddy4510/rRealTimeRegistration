package com.tcs.serviceimpls;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entities.CitiesEntity;
import com.tcs.entities.CountriesEntity;
import com.tcs.entities.StatesEntity;
import com.tcs.models.Country;
import com.tcs.repositories.CitiesRepo;
import com.tcs.repositories.CountriesRepo;
import com.tcs.repositories.StatesRepo;
import com.tcs.service.DropDownService;

@Service
public class DropDownServiceImpl implements DropDownService{

	@Autowired
	private CountriesRepo countryRepo;
	
	@Autowired
	private StatesRepo stateRepo;
	

	@Autowired
	private CitiesRepo cityRepo;
	
	@Override
	public Map<Integer, String> getAllCountries() {
		
		
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();
		try {
		List<CountriesEntity> list = countryRepo.findAll();
		list.forEach(contriesEntity->{
			map.put(contriesEntity.getCountryId(), contriesEntity.getCountryName());
		});
		}catch(Exception e) {
			e.getMessage();
		}
		
		return map;
	}

	@Override
	public Map<Integer, String> getStatesByCountry(Integer countryId) {
		
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();
		try {
	     List<StatesEntity> list = stateRepo.findAllByCountryId(countryId);     
	     list.forEach(statesEntity->{
				map.put(statesEntity.getStateId(),statesEntity.getStateName());
			});
		}catch(Exception e) {
			e.getMessage();
		}
		
		return map;
	}

	@Override
	public Map<Integer, String> getCitiesByState(Integer stateId) {

		Map<Integer,String> map=new LinkedHashMap<Integer,String>();
		
		try {
		
		List<CitiesEntity> list = cityRepo.findAllByStateId(stateId);
		list.forEach(citiesEntity->{
			map.put(citiesEntity.getCityId(),citiesEntity.getCityName());
		});
		}catch(Exception e) {
			e.getMessage();
		}
		return map;
	}

}
