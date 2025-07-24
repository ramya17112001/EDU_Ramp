package com.user_service.controller;
//package com.smarttelecom.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.dto.UserUpdateRequest;
import com.user_service.dto.PlanUsageDto;
import com.user_service.dto.UserDto;
import com.user_service.model.User;
import com.user_service.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users") 

public class UserController { 
	 @Autowired
	    private UserService userService;
	 @GetMapping
	    public List<UserDto> getAllUsers() {
	        return userService.getAllUsers();
	    } 
	    // Use authentication principal or token in real app, here email is for sample
	    @GetMapping("/me")
	    public UserDto getCurrentUser(@RequestParam String email) {
	        return userService.getCurrentUser(email);
	    }
	    @PostMapping
	    public UserDto createUser(@RequestBody UserDto userDto) {
	        return userService.createUser(userDto);
	    } 

	    @PutMapping("/update")
	    public UserDto updateUser(@RequestParam String email,
	                               @RequestBody UserUpdateRequest req) {
	        return userService.updateUser(email, req);
	    }

	    @GetMapping("/plan-usage")
	    public PlanUsageDto getPlanUsage(@RequestParam String email) {
	        return userService.getPlanUsage(email);
	     }
	
}
	