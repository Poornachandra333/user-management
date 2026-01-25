package com.example.user_management.controller;

import com.example.user_management.dto.UserRequestDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.entity.User;
import com.example.user_management.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllUsers")
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser")
    public UserResponseDto updateUser(@RequestBody UserRequestDto dto){
        return userService.updateUser(dto);
    }

}
