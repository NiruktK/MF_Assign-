package com.project.service;

import com.project.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Advisor;

@Service
public class AdvisorServiceImpl implements AdvisorService {
	
	@Autowired
	private AdvisorRepository advisorRepository;

	@Override
	public Advisor createAdvisor(Advisor advisor) {
		if(advisor.getAdvisorName().equals("") || advisor.getAdvisorPhoto().equals(""))
			return null;
		return advisorRepository.save(advisor);
	}

}
