package com.project.bank.service;

import com.project.bank.entity.Customer;
import com.project.bank.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {

    Logger log = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void setupInitalData() {
        customerRepository.save(getCustomer("test","password","test@myspringboot.com","90157*****"));
        customerRepository.save(getCustomer("test12","password12","test12@myspringboot.com","90112*****"));
        log.info("Customer Added to DB {} ", customerRepository.findAll());
    }

    private static Customer getCustomer(String userId, String password, String mail, String mobileNo) {
        Customer customer = new Customer();
        customer.setUserId(userId);
        customer.setPassword(password);
        customer.setEmailId(mail);
        customer.setMobileNo(mobileNo);
        customer.setCreatedTime(LocalDate.now());
        customer.setUpdatedTime(LocalDate.now());
        return customer;
    }
}
