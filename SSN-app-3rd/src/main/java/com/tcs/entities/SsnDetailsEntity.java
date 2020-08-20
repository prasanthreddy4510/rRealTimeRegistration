package com.tcs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="SSN_Details")
@Data
public class SsnDetailsEntity {
	@Id
	@Column(name="ssn_number")
	@GeneratedValue(generator = "IdGenerator")
	@GenericGenerator(name = "IdGenerator",
	    strategy = "com.tcs.utils.SsnGenerator"
	   )
	private Long ssnNumber;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="dob")
	private Date dob;
	@Column(name="state")
	private String state;
	@Column(name="created_date",updatable=false)
    @Temporal(value=TemporalType.DATE)
	@CreationTimestamp
	private Date createdDate;
	
	@Column(name="updated_date",insertable=false)
	@Temporal(value=TemporalType.DATE)
	@UpdateTimestamp
	private Date updatedDate;

}
