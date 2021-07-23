package com.api.login.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Data
@Slf4j
public class LoginResponseDto {

    private String transactionalAccountNumber;
    private double transactionalBalance;
    private double transactionalAmount;
    private String transactionalComment;
    @CreationTimestamp
    private LocalDate transactionaldateTime;

    private String mortgageAccountNumber;
    private double mortgageBalance;
    private double mortgageAmount;
    private String mortgageComment;
    @CreationTimestamp
    private LocalDate mortgagedateTime;

}
