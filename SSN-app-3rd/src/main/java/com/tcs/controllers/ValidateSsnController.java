package com.tcs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.services.SsnRegistrationService;

@RestController
public class ValidateSsnController {
	
	@Autowired
	private SsnRegistrationService service;
	
	@GetMapping(value="/validate/{ssn}/{state}")
	public ResponseEntity<String> validateSsn(@PathVariable("ssn")String ssnNumber,
			                                  @PathVariable("state")String state){
		boolean isValid = service.validateSsn(Long.parseLong(ssnNumber), state);
		String s=null;
		if(isValid) {
			s="valid";
		}
		else {
			s="invalid";
		}
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(s,HttpStatus.OK);
		
		return responseEntity;
		
		
	}

}
