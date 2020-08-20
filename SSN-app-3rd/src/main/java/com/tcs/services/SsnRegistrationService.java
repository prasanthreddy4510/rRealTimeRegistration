package com.tcs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.models.SsnDetails;
import com.tcs.models.States;
@Service
public interface SsnRegistrationService {
	
	
	public List<States> getStates();
	public Long savindDetails(SsnDetails ssn);
	 public boolean validateSsn(Long ssn,String state);

}
