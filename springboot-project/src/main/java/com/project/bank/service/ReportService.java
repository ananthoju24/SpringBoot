package com.project.bank.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.project.bank.dao.ReportsDao;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    Logger log = LoggerFactory.getLogger(ReportService.class);
    @Autowired
    ReportsDao reportsDao;

    ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
    }

    public String getAllTransactions(){
        List<Map<String, Object>> dbResponse = reportsDao.getAllTransactions();
        String json = getJsonString(dbResponse);
        log.info("Requested all transactions & response is {}", json);
        return json;
    }

    public String getTransaction(String userid) {
        log.info("Requested transaction details for user id {}", userid);
        List<Map<String, Object>> dbResponse = reportsDao.getTransactionReport(userid);
        String json = getJsonString(dbResponse);
        log.info("Requested transaction details for user id {} & response is {}", userid, json);
        return json;
    }

    public String getCustomerDetails() {
        List<Map<String, Object>> dbResponse = reportsDao.getCustomerDetails();
        String json = getJsonString(dbResponse);
        log.info("Requested Customer details & response is {}", json);
        return json;
    }

    private String getJsonString(List<Map<String, Object>> dbResponse) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(dbResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }


}
