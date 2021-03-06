package com.tcs.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.models.Login;
import com.tcs.service.LoginService;
import com.tcs.utils.AppConstants;

@Controller
public class LoginController {
	
	Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;

	@GetMapping("/login")
	public String loadLoginForm(Model model) {
		logger.debug("***Method execution started******");
		Login log=new Login();
		model.addAttribute("login",log);
		logger.debug("***Method execution ended****");
		logger.info("***loginform page loaded******");
		return "loginform";
		
	}
	
	@PostMapping("/validate")
	
	public String handlSbmtBtn(@ModelAttribute("login")Login login, RedirectAttributes att) {
		logger.debug("***method execution started****");
		boolean isValid=false;
		try {
		if(login!=null) {
		 isValid = service.validateLogin(login);
		}
		if(isValid) {
			att.addFlashAttribute(AppConstants.SUCC_MSG,AppConstants.THNKS_FOR_PRASANTH_PVT_LTD);	
		}
		else {
		att.addFlashAttribute(AppConstants.ERR_MSG, AppConstants.INVLID_CREDENTIALS);
		}
		}catch(Exception e) {
			
			logger.error("***exception occured while validating login****"+e.getMessage());
			
		}
		logger.debug("****method execution ended****");
		return "redirect:/login";
		
	}
	
}
