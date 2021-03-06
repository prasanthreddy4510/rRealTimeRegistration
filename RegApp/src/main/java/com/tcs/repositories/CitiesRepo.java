package com.tcs.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entities.CitiesEntity;

public interface CitiesRepo extends JpaRepository<CitiesEntity,Serializable> {

	public List<CitiesEntity> findAllByStateId(Integer stateId);
}
