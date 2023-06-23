package com.project.controller;

import com.project.entity.Advisor;
import com.project.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdvisorController {
	
	@Autowired
	private AdvisorService advisorService;

	//http://localhost:8070/admin/advisor
	
	@PostMapping("/advisor")
	public ResponseEntity<?> createAdvisor(@RequestBody Advisor advisor) {
		
		if(advisor.getAdvisorName().equals("") || advisor.getAdvisorPhoto().equals(""))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		Advisor a = advisorService.createAdvisor(advisor);
		if(a == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
