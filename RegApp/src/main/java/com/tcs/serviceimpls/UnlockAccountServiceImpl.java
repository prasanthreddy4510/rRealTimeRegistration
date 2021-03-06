package com.tcs.serviceimpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entities.RegistrationEntity;
import com.tcs.models.UnlockAcc;
import com.tcs.repositories.RegistrationEntityRepo;
import com.tcs.service.UnlockAccountService;
import com.tcs.utils.AppConstants;

@Service
public class UnlockAccountServiceImpl implements UnlockAccountService {
	
	@Autowired
	private RegistrationEntityRepo repo;

	@Override
	public String saveUnlock(UnlockAcc ua) {
		RegistrationEntity entity=null;
		try {
		 entity = repo.findByEmail(ua.getEmail());
		entity.setPwd(ua.getConfimPwd());
		entity.setAccountStatus("unlocked");
		RegistrationEntity entity2 = repo.save(entity);
		if(entity2.getPwd().equals(ua.getConfimPwd()))
		{	
			return AppConstants.USR_UNLCKD_PWD_CNFIRD;
		}
		}catch(Exception e) {
			e.getMessage();
		}
		
		return AppConstants.UNLC_FLD;
	}

}
