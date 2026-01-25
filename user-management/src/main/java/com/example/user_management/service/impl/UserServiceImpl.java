package com.example.user_management.service.impl;

import com.example.user_management.dto.UserRequestDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.entity.User;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        // Convert DTO to Entity
        User user = new User(dto.getName(),dto.getEmail(),dto.getPhoneNo(),dto.getPassword(),"User",true);
//        user.setName(dto.getName());
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
//        user.setPhoneNo(dto.getPhoneNo());
        // Default values
//        user.setRole("User");
//        user.setActive(true);

        // Save to DB
        User savedUser = userRepository.save(user);

        // Convert Entity to Response DTO
        UserResponseDto response = new UserResponseDto();
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setPhoneNo(savedUser.getPhoneNo());
        response.setRole(savedUser.getRole());
        response.setActive(savedUser.isActive());

        return response;
    }
}