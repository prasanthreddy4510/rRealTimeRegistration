package com.tcs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="state_master")
@Entity
public class StatesEntity {

	@Id
	@Column(name="state_id")
	private Integer stateId;
	@Column(name="state_name") 
	private String stateName;
	
}
