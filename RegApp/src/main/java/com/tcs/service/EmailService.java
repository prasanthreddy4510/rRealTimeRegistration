package com.tcs.service;



import com.tcs.models.Registration;

public interface EmailService {
	
	public void sendEmailWithAttachments(Registration reg) throws Exception;

}
