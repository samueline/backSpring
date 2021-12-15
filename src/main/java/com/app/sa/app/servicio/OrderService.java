/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sa.app.servicio;


import com.app.sa.app.entidad.Orders;
import com.app.sa.app.entidad.User;
import com.app.sa.app.repositorio.OrderRepository;
import com.app.sa.app.repositorio.crud.OrderRepositorio;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samue
 */
@Service

public class OrderService {

    @Autowired
    private OrderRepository repository;

    
    private OrderRepositorio rep;
    
    
    public List<Orders> getAll(){
        return repository.findAll();
    }
     public Orders getOrder(int Id){
        return repository.findById(Id).orElse(null);
    }

    // this method will save a new user
    public Orders save(Orders order){
            
        return repository.save(order);
            
    }
    
      public Orders updateOrder(Orders order){
        Orders prodantiguo=getOrder(order.getId());
        
        prodantiguo.setStatus(order.APROVED);
//        prodantiguo.setRegisterDay(order.getRegisterDay());
//     
//        prodantiguo.setSalesMan(order.getSalesMan());
//        prodantiguo.setProducts(order.getProducts());
//        prodantiguo.setQuantities(order.getQuantities());
        
        

        return repository.save(prodantiguo);
    }
      
       public List<Orders> getOrderCustomer(String zone){
         return repository.findByZone(zone);
    }
    
       public List<Orders> findByStatus(String status, Integer id){
           return repository.findByStatus(status, id);
       }
       public List<Orders> findBySales(Integer id){
           return repository.findBySalesMan(id);
       }
       public List<Orders> findByDate(String date,Integer id){
           
           return rep.orderSalesManByDate(date,id);
       }
       
}
