package com.tcs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entities.SsnDetailsEntity;
import com.tcs.entities.StatesEntity;
import com.tcs.models.SsnDetails;
import com.tcs.models.States;
import com.tcs.repositories.SsnRepositories;
import com.tcs.repositories.StatesRepository;

@Service
public class SsrRegistrationsServiceImpl implements SsnRegistrationService {
	
	@Autowired
	private SsnRepositories repo;
	
	@Autowired
	private StatesRepository sRepo;

	@Override
	public Long savindDetails(SsnDetails ssn) {
       SsnDetailsEntity entity=new SsnDetailsEntity();
       BeanUtils.copyProperties(ssn, entity);
       SsnDetailsEntity detailsEntity = repo.save(entity);
     
    	   return detailsEntity.getSsnNumber();
      
	}

	@Override
	public boolean validateSsn(Long ssn, String state) {

		SsnDetailsEntity entity = repo.findBySsnNumberAndState(ssn, state);
		
		if(entity!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<States> getStates() {
		List<States> statesAll=new ArrayList<States>();
	List<StatesEntity> list = sRepo.findAll();
	for(StatesEntity entity:list) {
		States state=new States();
		BeanUtils.copyProperties(entity, state);
		 statesAll.add(state);
	}
     
		return statesAll;
	}

	
}
