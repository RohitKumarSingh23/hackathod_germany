package com.api.login.controller;

import com.api.login.dto.LoginResponseDto;
import com.api.login.dto.UserDto;
import com.api.login.service.UserService;
import com.api.login.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class LogInController {
        @Autowired
        UserService userService;

    @PostMapping("/login")
    public LoginResponseDto userLogin(@RequestBody UserDto userDto){

        LoginResponseDto loginResponseDto = userService.getlogInUserDetails(userDto);
        return loginResponseDto;
    }
}
