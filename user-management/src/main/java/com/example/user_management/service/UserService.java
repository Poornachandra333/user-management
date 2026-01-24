package com.example.user_management.service;

import com.example.user_management.dto.UserRequestDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    UserResponseDto createUser(UserRequestDto dto);
}
