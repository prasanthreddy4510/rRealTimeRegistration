package com.tcs.repositories;
import com.tcs.entities.StatesEntity;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends JpaRepository<StatesEntity,Serializable> {

}
