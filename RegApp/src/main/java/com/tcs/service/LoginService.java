package com.tcs.service;

import com.tcs.models.Login;


public interface LoginService {

	public boolean validateLogin(Login login);
	
	public boolean forgotPwd(String email);
}
