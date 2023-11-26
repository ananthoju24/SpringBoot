package com.project.bank.controller;


import com.project.bank.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    ReportService reportService;
    //http://localhost:8080/reports/service/status
    @GetMapping("/service/status")
    public ResponseEntity<String> serviceStatus(){
        return new ResponseEntity<>("Report service is up and running ", HttpStatus.OK);
    }
    @GetMapping("/transaction/{userid}")
    @ResponseBody
    public ResponseEntity<String> getTransaction(@PathVariable("userid") String userid) {
        return new ResponseEntity<>(reportService.getTransaction(userid), HttpStatus.OK);
    }

    @GetMapping("/transaction/all")
    @ResponseBody
    public ResponseEntity<String> getAllTransaction() {
        return new ResponseEntity<>(reportService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/customer/data")
    @ResponseBody
    public ResponseEntity<String> getCustomerData() {
        return new ResponseEntity<>(reportService.getCustomerDetails(), HttpStatus.OK);
    }
}
