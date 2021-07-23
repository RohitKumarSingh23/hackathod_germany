package com.api.login.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
        @NotBlank
        private Long customerId;
        @NotBlank
        private String password;

    }

