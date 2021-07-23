package com.api.login.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class TransactionalAccount {
    @Id
    private String accountNumber;
    private double balance;
    private double amount;
    private String comment;
    @CreationTimestamp
    private LocalDate dateTime;
}
