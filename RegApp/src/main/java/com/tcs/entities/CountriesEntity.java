package com.tcs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="countries")
@Entity
public class CountriesEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer countryId;
	private String countryCode;
	private String countryName;
}
