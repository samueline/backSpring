/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sa.app.controlador;

import com.app.sa.app.entidad.User;
import com.app.sa.app.servicio.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author samue
 */
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> findAllUser(){
        return service.getAll();
    }
    
//    @GetMapping("/{id}")
//    public Producto findProducto(@PathVariable String id){
//        return service.getUser(id);
//    }
    
    @PostMapping("/save")
    public ResponseEntity addUser(@RequestBody User user){
        service.save(user);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/save")
    public ResponseEntity editUser(@RequestBody User user){
        service.updateUser(user);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
        return ResponseEntity.status(204).build();
    }
    
}
