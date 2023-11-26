package com.project.bank.controller;

import com.project.bank.dto.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping("/service/status")
    public ResponseEntity<String> serviceStatus(){
        return new ResponseEntity<>("Service is up and running ", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CustomerDto customer){
        return new ResponseEntity<>("login success", HttpStatus.OK);
    }


}
