package com.tcs.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.models.Registration;
import com.tcs.service.DropDownService;
import com.tcs.service.RegistrationService;
import com.tcs.utils.AppConstants;

@Controller
public class RegistrationController {
	
	Logger logger=LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private DropDownService ddp;
	
	@GetMapping("/reg")
	public String loadForm(Model model) {
		
		logger.debug("***method execution started***");
		
		try {
			Registration registration = new Registration();
		     Map<Integer, String> allCountries = ddp.getAllCountries();
		     model.addAttribute(AppConstants.COUNTRIES, allCountries);
			model.addAttribute(AppConstants.REGISTER, registration);
		}catch(Exception e) {
		logger.error("***execption occured while loading registration form:"+e.getMessage());	
		}
		logger.debug("***method execution ended");
		logger.info("****registration form is  loaded*****");
		return "registration";
	}
	
	@PostMapping("/saveForm")
	public String handleSubmitBtn(@ModelAttribute("register") Registration registration, Model attribute) {
	
		logger.debug("***method execution started*****");
		
		try {
			boolean isSaved = service.saveUserDtls(registration);
			if(isSaved) {
				
				attribute.addAttribute(AppConstants.SUCC_MSG,AppConstants.CNTACT_SVD);
			}
			else {
				attribute.addAttribute(AppConstants.ERR_MSG,AppConstants.FLED_TO_SAVE);
			}
		}catch(Exception e) {
			logger.error("***error occured while saving user details:"+e.getMessage());
		}
		
		logger.debug("method execution ended****");
		
			return "confirmation";
	}
	
	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer,String> getStatesByCountryId(@RequestParam("countryId")Integer countryId){
		
		logger.debug("***Methid execution started***");
		
		Map<Integer, String> states=null;
		try {
		 states = ddp.getStatesByCountry(countryId);
		}catch(Exception e) {
			logger.error("***exception occured while pulling states: "+e.getMessage());
		}
		
		logger.debug("***method execution ended****");
		logger.info("***states are loaded to UI****");
		return states;
		
	}
	
	@GetMapping("/getCities")
	@ResponseBody
	public Map<Integer,String> getCitiesByStateId(@RequestParam("stateId")Integer stateId){
		
		Map<Integer,String> cities=null;
		try {
			cities= ddp.getCitiesByState(stateId);
		}catch(Exception e) {
			e.getMessage();
		}
		return cities;
	}
	
	@GetMapping("/validateEmail")
	@ResponseBody
	public String emailValidation(@RequestParam("email") String email) {

		String emailStatus=null;
		try {
		 emailStatus = service.validateEmail(email);
		}catch(Exception  e) {
			e.getMessage();
		}
		return emailStatus;
	}
	
	
}
