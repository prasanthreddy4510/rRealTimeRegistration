package com.tcs.swagger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.request.PassingerInfo;
import com.tcs.response.TicketInfo;

@RestController
public class TicketController {

	@PostMapping("/bookTicket")
	public ResponseEntity<TicketInfo> getDetails(@RequestBody PassingerInfo pInfo ){
		TicketInfo info=new TicketInfo();
		info.setName(pInfo.getFirstName()+" "+pInfo.getLastName());
		info.setFrom(pInfo.getFrom());
		info.setTo(pInfo.getTo());
		info.setJourneyDate(pInfo.getJourneyDate());
		info.setTicketId(23322);
		
		return new ResponseEntity<TicketInfo>(info,HttpStatus.CREATED);
		
	}
}
