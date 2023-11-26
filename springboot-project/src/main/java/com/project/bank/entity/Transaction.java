package com.project.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String userId;
    private String soruceAccountNo;
    private String destinationAccountNo;
    private Double amount;
    private String status;
    private LocalDate createdTime;
    private LocalDate updatedTime;
}
