package com.tcs.request;

import java.util.Date;

import lombok.Data;

@Data
public class PassingerInfo {

	private String firstName;
	private String lastName;
	private String gender;
	private String from;
	private String to;
	private Date journeyDate;
	private Integer ticketId;
}
