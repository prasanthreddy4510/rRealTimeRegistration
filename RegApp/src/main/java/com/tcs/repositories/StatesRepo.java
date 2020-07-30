package com.tcs.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entities.StatesEntity;

public interface StatesRepo extends JpaRepository<StatesEntity,Serializable>{

	public List<StatesEntity> findAllByCountryId(Integer countryId); 
	
}
