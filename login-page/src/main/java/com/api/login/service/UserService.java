package com.api.login.service;

import com.api.login.dto.LoginResponseDto;
import com.api.login.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
    LoginResponseDto getlogInUserDetails(UserDto userDto);
}
