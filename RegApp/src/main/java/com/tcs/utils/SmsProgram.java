package com.tcs.utils;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClient.Builder;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

public class SmsProgram {
	

public static void	sendSms(Long phno, String pwd){
	
		NexmoClient client = new NexmoClient.Builder()
			  .apiKey("ba5ad00c")
			  .apiSecret("QWvDydKkc7wfqQld")
			  .build();
	
	//TextMessage message = new TextMessage(FROM_NUMBER, TO_NUMBER, "Hello from Nexmo!");
              
			String messageText = "Your password is :"+pwd;
			TextMessage message = new TextMessage("916303660984", "phno",messageText );

			SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

			for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
			    System.out.println(responseMessage);
			}

}
}
