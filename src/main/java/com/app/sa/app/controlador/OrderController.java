/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sa.app.controlador;

import com.app.sa.app.entidad.Orders;
import com.app.sa.app.entidad.User;
import com.app.sa.app.servicio.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samue
 */

@RestController
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
                                  RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service;
    
     @GetMapping("/all")
    public List<Orders> findAllOrder(){
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Orders findOrder(@PathVariable Integer id){
        return service.getOrder(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity addOrder(@RequestBody Orders order){
        service.save(order);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity editOrder(@RequestBody Orders order){
        service.updateOrder(order);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/zona/{ZONA}")
    public List<Orders> findOrderUser(@PathVariable String ZONA){
        return service.getOrderCustomer(ZONA);
    }
    @GetMapping("/state/{status}/{id}")
    public List<Orders> findByStatus(@PathVariable("status") String status,@PathVariable("id") Integer id){
        return service.findByStatus(status, id);
    }
    @GetMapping("/salesman/{id}")
    public List<Orders> findSalesMan(@PathVariable("id") Integer id){
        return service.findBySales(id);
    }
    @GetMapping("/date/{date}/{id}")
     public List<Orders> findSalesManDate(@PathVariable("date") String date,@PathVariable("id") Integer id){
        return service.findByDate(date,id);
    }
    
}
