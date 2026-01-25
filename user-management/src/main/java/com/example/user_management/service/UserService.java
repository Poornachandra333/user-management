package com.example.user_management.service;

import com.example.user_management.dto.UserRequestDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.entity.User;
import com.example.user_management.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public UserResponseDto createUser(UserRequestDto dto);
    public List<UserResponseDto> getAllUsers();
    public UserResponseDto updateUser(UserRequestDto dto);
}
