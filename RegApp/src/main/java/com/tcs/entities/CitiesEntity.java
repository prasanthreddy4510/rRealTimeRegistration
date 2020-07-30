package com.tcs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cities")
public class CitiesEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer cityId;
	private Integer stateId;
	private String cityName;
}
