package com.project.bank.service;

import com.project.bank.entity.Transaction;
import com.project.bank.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionService {

    Logger log = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    TransactionRepository transactionRepository;

    @PostConstruct
    public void setupInitialData() {
        transactionRepository.save(getTransaction("1234","test","1111","SUCCESS"));
        transactionRepository.save(getTransaction("1235","test12","111112","SUCCESS"));
        log.info("Initial Transaction setup done with {} ", transactionRepository.findAll());
    }

    private static Transaction getTransaction(String srcAcctno, String userId, String destAcctNo, String status) {
        Transaction transaction = new Transaction();
        transaction.setSoruceAccountNo(srcAcctno);
        transaction.setUserId(userId);
        transaction.setDestinationAccountNo(destAcctNo);
        transaction.setAmount(1000.00);
        transaction.setCreatedTime(LocalDate.now());
        transaction.setUpdatedTime(LocalDate.now());
        transaction.setStatus(status);
        return transaction;
    }
}
