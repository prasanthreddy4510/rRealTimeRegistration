package com.tcs.serviceimpls;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entities.RegistrationEntity;
import com.tcs.models.Registration;
import com.tcs.repositories.RegistrationEntityRepo;
import com.tcs.service.EmailService;
import com.tcs.service.RegistrationService;
import com.tcs.utils.AppConstants;
import com.tcs.utils.RandomePasswordGenerator;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationEntityRepo repo;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public boolean saveUserDtls(Registration registration) {
		registration.setPwd(RandomePasswordGenerator.randomAlphaNumeric(AppConstants.TARGET_STRING_LENGHT));
		registration.setAccountStatus(AppConstants.ACC_STATUS); 
		
		RegistrationEntity entity=new RegistrationEntity();
		BeanUtils.copyProperties(registration, entity);
		RegistrationEntity save = repo.save(entity);
		try {
			emailService.sendEmailWithAttachments(registration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		if(save!=null) {
			return true;
			
		}
		
		return false;
	}

	@Override
	public String validateEmail(String email) {
		RegistrationEntity entity=null;
		try {
			entity = repo.findByEmail(email);
		
		if (entity != null) {
			return AppConstants.DUPLICATE;
		}
		}catch(Exception e) {
			e.getMessage();
		}
		return AppConstants.UNIQUE;
	}

}
