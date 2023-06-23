package com.project.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Bookings;
import com.project.entity.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//  http://localhost:8070/user/register
	
	@PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
		if(user.getUsername().equals("") || user.getPassword().equals("") || user.getEmail().equals(""))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        if (userService.findByEmail(user.getEmail()) != null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody User user) {
    	if(user.getEmail().equals("") || user.getPassword().equals(""))
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	
    	User u = userService.signInAndReturnJWT(user);
    	if(u == null)
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    	
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    
    @GetMapping("/{id}/advisor")
    public ResponseEntity<?> getAllAdvisors() {
    	
    	return ResponseEntity.ok(userService.getAllAdvisor());
    }
    // /user/{id}/advisor/book
    @PostMapping("/{id}/advisor/book")
    public ResponseEntity<?> bookAdvisor(@RequestBody Bookings bookings) {
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @GetMapping("/{id}/advisor/bookings")
    public ResponseEntity<?> getAllAdvisor(@PathVariable("id") Long userId) {
    	return ResponseEntity.ok(userService.getAllBookingsById(userId));
    }
}
