package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.entity.Advisor;
import com.project.entity.Bookings;
import com.project.entity.Role;
import com.project.entity.User;
import com.project.repository.AdvisorRepository;
import com.project.repository.BookingRepository;
import com.project.repository.UserRepository;
import com.project.security.UserPrinciple;
import com.project.security.jwt.JwtProvider;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdvisorRepository advisorRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
    public User signInAndReturnJWT(User signInRequest) {
    	
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        
        String jwt = jwtProvider.generateToken(userPrinciple);

        User signInUser = userPrinciple.getUser();
        signInUser.setToken(jwt);
        
        return signInUser;
    }
	
	@Override
	public User findByEmail(String username) {
		return userRepository.findByEmail(username);
	}

	@Override
	public List<Advisor> getAllAdvisor() {
		return advisorRepository.findAll();
	}

	@Override
	public Bookings bookAdvisor(Bookings bookings) {
		// TODO Auto-generated method stub
		return bookingRepository.save(bookings);
	}

	@Override
	public List<Bookings> getAllBookingsById(Long userId) {
		
		return bookingRepository.findAllByUserId(userId);
	}
}
