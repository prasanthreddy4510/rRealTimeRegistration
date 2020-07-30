package com.tcs.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entities.RegistrationEntity;

public interface RegistrationEntityRepo extends JpaRepository<RegistrationEntity,Serializable>{
	
	public RegistrationEntity findByEmail(String email);
    
	public RegistrationEntity findByEmailAndPwd(String email,String pwd);
}
