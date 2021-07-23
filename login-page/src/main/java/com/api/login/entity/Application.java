package com.api.login.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Application {
    @Id
    private Long customerId;
    private String password;
    private String title;
    private String firstName;
    private String middleName;
    private String surName;
    private String dob;
    private String phoneNo;
    private String email;
    private String transactionalAccNo;
    private String mortgageAccNo;
    private String contractType;
    private String employmentStatus;
    @CreationTimestamp
    private LocalDate jobStartDate;
    private String occupation;
    private String operationType;
    private double propertyCost;
    private double deposite;
    private String maritalStatus;


}
