package com.tcs.serviceimpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entities.RegistrationEntity;
import com.tcs.models.Login;
import com.tcs.repositories.RegistrationEntityRepo;
import com.tcs.service.LoginService;
import com.tcs.utils.SmsProgram;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private RegistrationEntityRepo repo;

	@Override
	public boolean validateLogin(Login login) {
		RegistrationEntity entity=null;
		try {
		    entity = repo.findByEmailAndPwd(login.getEmail(), login.getPwd());
		}catch(Exception e) {
			e.getMessage();
		}
		   if(entity!=null) {
			   return true;
		   }
		
		return false;
	}

	@Override
	public boolean forgotPwd(String email) {
		RegistrationEntity entity=null;
		try {
		entity = repo.findByEmail(email);
		
		if(entity!=null) {
		String pwd=entity.getPwd();
		Long phno=entity.getPhoneNumber();
			SmsProgram.sendSms(phno,pwd);
			return true;
		}
		}catch(Exception e) {
			e.getMessage();
		}
		
		return false;
	}

}
