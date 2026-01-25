package com.example.user_management.controller;

import com.example.user_management.dto.UserRequestDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/")
    public UserResponseDto createUser(@RequestBody UserRequestDto dto){
       return  userService.createUser(dto);
    }

}
