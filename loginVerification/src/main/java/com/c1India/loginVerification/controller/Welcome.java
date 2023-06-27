package com.c1India.loginVerification.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.c1India.loginVerification.model.Staff;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class Welcome {

	@GetMapping("/welcome")
	public String helloWorld() {
		return "Welcome to Hell";
	}
	
	@RequestMapping("/staff")
	@PostMapping( consumes="application/json", produces="application/json")
	@ResponseBody
	public Staff verifyStaff(@RequestBody String staffJson) throws JsonParseException, JsonMappingException, IOException {
		
		Staff  staff  = new ObjectMapper().readValue(staffJson, Staff.class);
		
		System.out.println("here is the staff body");
		System.out.println(staff);
		return staff;
	}
	
}
