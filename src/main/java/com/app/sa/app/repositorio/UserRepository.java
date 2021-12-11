/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.sa.app.repositorio;

import com.app.sa.app.entidad.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author samue
 */
public interface UserRepository extends MongoRepository<User,Integer>{
        Optional<User> findByEmail(String email);

}
