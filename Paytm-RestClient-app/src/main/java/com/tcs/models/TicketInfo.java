package com.tcs.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketInfo {

	private String name;
	private Integer ticketId;
	private String from;
	private String to;
	private Date journeyDate;
}
