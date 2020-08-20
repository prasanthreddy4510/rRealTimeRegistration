package com.tcs.clients;

import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tcs.models.PassingerInfo;
import com.tcs.models.TicketInfo;

@RestController
public class ClientRestController {

	private String endPointUrl="http://localhost:8898//bookTicket";
	
	public void invokeRestApi() {
		
		PassingerInfo pInfo=new PassingerInfo();
		pInfo.setFirstName("ganesh");
		pInfo.setLastName("khan");
		pInfo.setFrom("hyd");
		pInfo.setTo("mum");
		Date da=new Date();
        pInfo.setJourneyDate(da);
        
        HttpHeaders headers=new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type","application/json");
        
        HttpEntity<PassingerInfo> entity=new HttpEntity<PassingerInfo>(pInfo,headers);
        
        RestTemplate rt=new RestTemplate();
        ResponseEntity<TicketInfo> responseEntity = rt.postForEntity(endPointUrl, entity,TicketInfo.class);
        if(201==responseEntity.getStatusCodeValue()) {
        	TicketInfo body = responseEntity.getBody();
        	System.out.println(body);
        }
        
	}
}
