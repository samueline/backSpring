/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.sa.app.repositorio;

import com.app.sa.app.entidad.Orders;
import com.app.sa.app.entidad.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author samue
 */
public interface OrderRepository  extends MongoRepository<Orders,Integer>{

 @Query("{'salesMan.zone':?0}")
 List<Orders> findByZone(final String country);
 
 @Query("{'status':?0}")
 List<Orders> findByStatus(final String status);
  
 
}
