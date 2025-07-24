package com.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth_service.dto.AuthResponse;
//import com.auth_service.config.JwtTokenProvider;
import com.auth_service.dto.LoginRequest;
import com.auth_service.dto.RegisterRequest;
import com.auth_service.exception.UserAlreadyExistsException;
//import com.auth_service.dto.UserDto;
import com.auth_service.model.User;
import com.auth_service.model.UserRole;
import com.auth_service.repository.UserRepository;
import com.auth_service.security.JwtUtil;
//import com.auth_service.util.JwtTokenUtil;

@Service
public class AuthService {
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegisterRequest req) {
         if (userRepository.existsByEmail(req.getEmail()))
            throw new RuntimeException("This email already exists");
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setRole(req.getRole());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest req) {
        User user = userRepository.findByEmail(req.getEmail()).orElseThrow(
            () -> new RuntimeException("Invalid email or password"));
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid email or password");
        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token, user.getRole());
    } 
}
  
 