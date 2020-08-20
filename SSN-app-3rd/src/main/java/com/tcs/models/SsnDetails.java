package com.tcs.models;

import java.util.Date;

import lombok.Data;

@Data
public class SsnDetails {
	private Long ssnNumber;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String state;
	private Date createdDate;
	private Date updatedDate;
	
	

}
