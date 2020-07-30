package com.tcs.models;

import java.util.Date;

import lombok.Data;

@Data
public class Registration {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	private Date dob;
	private String gender;
	private String countryId;
	private String stateId;
	private String cityId;
	private String pwd;
	private String accountStatus;
	private String accountSwitch;
	private Date createdDate;
	private Date UpdatedDate;

}
