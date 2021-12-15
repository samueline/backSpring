/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sa.app.repositorio.crud;

import com.app.sa.app.entidad.Orders;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author samue
 */

public class OrderRepositorio {
@Autowired
private MongoTemplate mongoTemplate;
    
    public List<Orders> orderSalesManByDate(String dateStr, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                                    .gte(LocalDate.parse(dateStr,dtf).minusDays(1).atStartOfDay())
                                    .lt(LocalDate.parse(dateStr,dtf).plusDays(2).atStartOfDay())
                                    .and("salesMan.id").is(id);
        
        query.addCriteria(dateCriteria);
        List<Orders> orders = mongoTemplate.find(query,Orders.class);
        return orders;
    }
}
