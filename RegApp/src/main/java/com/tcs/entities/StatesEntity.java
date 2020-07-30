package com.tcs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="states")
public class StatesEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer stateId;
	private Integer countryId;
	private String stateName;
}
