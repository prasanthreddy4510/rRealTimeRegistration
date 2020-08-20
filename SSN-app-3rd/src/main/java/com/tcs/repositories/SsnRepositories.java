package com.tcs.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.entities.SsnDetailsEntity;

@Repository
public interface SsnRepositories extends JpaRepository<SsnDetailsEntity,Serializable> {

	public SsnDetailsEntity findBySsnNumberAndState(Long ssnNumber,String state);
}
