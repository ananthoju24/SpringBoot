package com.project.bank.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportsDao {

    Logger log = LoggerFactory.getLogger(ReportsDao.class);

    @PersistenceContext
    EntityManager entityManager;

    public List<Map<String, Object>> getAllTransactions() {
        String query = "Select t from Transaction t";
        log.info("Query {}", query);
        return executeQueryAndGetResult(query);
    }

    public List<Map<String, Object>> getTransactionReport(String userId) {
        String query = "Select t from Transaction t, Customer c where c.userId='" + userId + "' and c.userId = t.userId";
        log.info("Query {}", query);
        return executeQueryAndGetResult(query);

    }

    public List<Map<String, Object>> getCustomerDetails() {
        String query = "Select c from Customer c";
        return executeQueryAndGetResult(query);
    }

    private List<Map<String, Object>> executeQueryAndGetResult(String query) {
        List<Map<String, Object>> results = new ArrayList<>();
        entityManager.createQuery(query).getResultList().forEach(result ->
        {
            HashMap<String, Object> row = new HashMap<>();
            row.put(result.getClass().getSimpleName(), result);
            results.add(row);
        });
        return results;
    }
}
