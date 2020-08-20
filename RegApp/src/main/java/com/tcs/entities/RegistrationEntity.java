package com.tcs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "UserRegistration")
public class RegistrationEntity {
	
	@Id
	@SequenceGenerator(name = "USER_REG_SEQ",sequenceName = "USER_REG_SEQ")
	@GeneratedValue(generator = "USER_REG_SEQ",strategy = GenerationType.SEQUENCE)
	private Integer userId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_NAME")
	private String email;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	@Column(name = "DATEOFBIRTH")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "COUNTRY")
	private String countryId;
	@Column(name = "STATE")
	private String stateId;
	@Column(name = "CITY")
	private String cityId;
	@Column(name = "PASSWORD")
	private String pwd;
	@Column(name = "ACCOUNT_STATUS")
	private String accountStatus;
	@Column(name = "ACCOUNT_SWITCH")
	private String accountSwitch;
	@Column(name = "CREATED_DT",updatable = false)
	@Temporal(value = TemporalType.DATE)
	@CreationTimestamp
	private Date createdDate;
	@Column(name="UPDATED_DT",insertable = false)
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date UpdatedDate;
	

}
