package com.tcs.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class PassingerInfo {
	private String firstName;
	private String lastName;
	private String gender;
	private String from;
	private String to;
	private Date journeyDate;
	private Integer ticketId;
	 
}
