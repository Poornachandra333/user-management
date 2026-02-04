package com.example.user_management.service.impl;

import com.example.user_management.dto.UserRequestDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.entity.User;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
//        UserResponseDto response = new UserResponseDto();
//        response.setName(savedUser.getName());
//        response.setEmail(savedUser.getEmail());
//        response.setPhoneNo(savedUser.getPhoneNo());
//        response.setRole(savedUser.getRole());
//        response.setActive(savedUser.isActive());
//
//        return response;
        return setAllDetails(savedUser);
    }

    public UserResponseDto setAllDetails(User user){
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setActive(user.isActive());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        userResponseDto.setRole(user.getRole());
        userResponseDto.setPhoneNo(user.getPhoneNo());
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> getAllUsers(){
        List<User>list= userRepository.findAll();
        List<UserResponseDto> answer = new ArrayList<>();
        for(User user:list){

//            UserResponseDto userResponseDto=new UserResponseDto();
//            userResponseDto.setActive(user.isActive());
//            userResponseDto.setEmail(user.getEmail());
//            userResponseDto.setName(user.getName());
//            userResponseDto.setRole(user.getRole());
//            userResponseDto.setPhoneNo(user.getPhoneNo());
            answer.add(setAllDetails(user));
        }
        return answer;
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto dto) {
        User user=userRepository.findById(dto.getId()).orElseThrow(()->new RuntimeException("User not found"));
        user.setEmail(dto.getEmail());
        user.setId(dto.getId());
        user.setPassword(dto.getPassword());
        user.setPhoneNo(dto.getPhoneNo());
        user.setRole("user");
        user.setActive(true);
        userRepository.save(user);
        return setAllDetails(user);
    }
    @Override
    public String deleteUser(int id){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        userRepository.delete(user);
        return "SuccessFully Deleted User";
    }

}