package com.tcs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.models.Registration;
import com.tcs.models.UnlockAcc;
import com.tcs.service.UnlockAccountService;
import com.tcs.utils.AppConstants;

@Controller
public class UnlockController {
	
	@Autowired
	private UnlockAccountService unlockService;

	@GetMapping("/unlockAcc")
	public String unlockAccount(@RequestParam("email")String email,Model model) {
	
		UnlockAcc acc=new UnlockAcc();
		acc.setEmail(email);
		model.addAttribute(AppConstants.EMAIL, email);
		model.addAttribute(AppConstants.UNLC_ACC, acc);
		
		return "unlockscreen";
		
	}
	
	@PostMapping("/saveUnlock")
	@ResponseBody
	public String HandleSubmitButton(@ModelAttribute("unlockAcc")UnlockAcc acc) {
		String res=null;
		try {
			res = unlockService.saveUnlock(acc);
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		return res;
		
	}
}
