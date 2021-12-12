/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sa.app.servicio;

import com.app.sa.app.entidad.User;
import com.app.sa.app.repositorio.UserRepository;
import java.util.List;

//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samue
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // this method will return to us all the existent users
    public List<User>getAll() {
        return repository.findAll();
    }

    // this method will return to us each specified user by his/her id
    public User getUser(int Id){
        return repository.findById(Id).orElse(null);
    }

    // this method will save a new user
    public User save(User user){
            
                return repository.save(user);
            
      
    }

    // This method will to look if an user exist on the system by its email

    public User updateUser(User user){
        User prodantiguo=getUser(user.getId());
        prodantiguo.setIdentification(user.getIdentification());
        prodantiguo.setName(user.getName());
        prodantiguo.setBirthtDay(user.getBirthtDay());
        prodantiguo.setMonthBirthtDay(user.getMonthBirthtDay());
        prodantiguo.setAddress(user.getAddress());
        prodantiguo.setCellPhone(user.getCellPhone());
        prodantiguo.setEmail(user.getEmail());
        prodantiguo.setPassword(user.getPassword());
        prodantiguo.setZone(user.getZone());
        prodantiguo.setType(user.getType());


        return repository.save(prodantiguo);
    }
    
    public void deleteUser(Integer id){
        repository.deleteById(id);
    }     
    
 public boolean getUserByEmail(String email){
      
     return true;
    }

    

    
    }
