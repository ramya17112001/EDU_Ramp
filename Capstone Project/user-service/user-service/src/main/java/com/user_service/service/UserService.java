package com.user_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import com.user_service.dto.UpdatePlanRequest;
import com.user_service.dto.UserUpdateRequest;
import com.user_service.dto.PlanUsageDto;
import com.user_service.dto.UserDto;
import com.user_service.exception.UserNotFoundException;
import com.user_service.model.User;
import com.user_service.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
 
@Service 

public class UserService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                    .map(user -> modelMapper.map(user, UserDto.class))
                      .toList();
    } 
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }


    public UserDto getCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("User not found: " + email));
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto updateUser(String email, UserUpdateRequest request) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("User not found: " + email));
        if (request.getName() != null) user.setName(request.getName());
        if (request.getPhone() != null) user.setPhone(request.getPhone());
        if (request.getPlanId() != null) user.setPlanId(request.getPlanId());
        User updated = userRepository.save(user);
        return modelMapper.map(updated, UserDto.class);
    }

    public PlanUsageDto getPlanUsage(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("User not found: " + email));
        PlanUsageDto dto = new PlanUsageDto();
        dto.setUserId(user.getId());
        dto.setPlanId(user.getPlanId());
        dto.setPlanName("Example Plan"); 
        dto.setTotalUsage(0.0); 
        return dto;
    } 
 
	} 