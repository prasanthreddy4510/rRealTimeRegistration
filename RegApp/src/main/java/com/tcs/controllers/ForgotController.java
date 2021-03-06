package com.tcs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.models.Email;
import com.tcs.service.LoginService;
import com.tcs.utils.AppConstants;

@Controller
public class ForgotController {
	
	@Autowired
	private LoginService ser;

	@GetMapping("/load")
	public String forgotForm(Model model) {
		Email email=new Email();
		model.addAttribute("email",email);
	return "forgotpwd";	
	}
	
	@PostMapping("/forgot")
	@ResponseBody
	public String handleSub(@ModelAttribute("email")Email email) {
		try {
		boolean isSent = ser.forgotPwd(email.getEmail());
		if(isSent) {
			return AppConstants.MSG_SNT_TO_REG_MBL;
		}
		}catch(Exception e) {
			e.getMessage();
		}
		return AppConstants.MSG_DID_NT_SENT;
		
	}
}
