package com.tcs.repositories;
import com.tcs.entities.CountriesEntity;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepo extends JpaRepository<CountriesEntity,Serializable>{

	
}
