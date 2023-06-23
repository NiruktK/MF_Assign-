package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.entity.Advisor;
import com.project.entity.Bookings;
import com.project.entity.User;

public interface UserService {

	User createUser(User user);

	User findByEmail(String email);

	User signInAndReturnJWT(User signInRequest);

	List<Advisor> getAllAdvisor();

	Bookings bookAdvisor(Bookings bookings);


	List<Bookings> getAllBookingsById(Long userId);
	
}
