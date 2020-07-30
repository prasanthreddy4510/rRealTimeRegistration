package com.tcs.service;

import org.springframework.stereotype.Service;

import com.tcs.models.Registration;

@Service
public interface RegistrationService {

	public boolean saveUserDtls(Registration registration);
	public String validateEmail(String email);
}
