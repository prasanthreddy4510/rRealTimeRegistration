package com.tcs.serviceimpls;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tcs.models.Registration;
import com.tcs.service.EmailService;
import com.tcs.utils.AppConstants;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender emailSender;

	@Override
	public void sendEmailWithAttachments(Registration reg) throws MessagingException {
		MimeMessage message=emailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setTo(reg.getEmail());
		helper.setSubject(AppConstants.UNLCK_YR_ACC_THRU_PRASANTH_GRANADE);
		try {
			helper.setText(getUnlockEmailBody(reg),true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		emailSender.send(message);
	}

	private String getUnlockEmailBody(Registration reg) throws Exception {
		
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader(AppConstants.UNLOCK_ACC_BODY);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", reg.getFirstName());
		mailBody = mailBody.replace("{LNAME}", reg.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", reg.getPwd());
		mailBody = mailBody.replace("{EMAIL}", reg.getEmail());

		return mailBody;
	}
	
	

}
