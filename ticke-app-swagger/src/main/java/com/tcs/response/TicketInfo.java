package com.tcs.response;

import java.util.Date;

import lombok.Data;

@Data
public class TicketInfo {

	private String name;
	private Integer ticketId;
	private String from;
	private String to;
	private Date journeyDate;
	
}
