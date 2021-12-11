/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sa.app.servicio;

import com.app.sa.app.entidad.Producto;
import com.app.sa.app.repositorio.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;
        
    public List<Producto> getProductos(){
        return repository.findAll();
    }
    
    public Producto saveProducto(Producto producto){
        return repository.save(producto);
    }
    
    public Producto getProducto(String id){
        return repository.findById(id).orElse(null);
    }
    
    public Producto updateProducto(Producto producto){
        Producto prodantiguo=getProducto(producto.getReference());
        prodantiguo.setBrand(producto.getBrand());
        prodantiguo.setCategory(producto.getCategory());
        prodantiguo.setDescription(producto.getDescription());
        prodantiguo.setAvailability(true);
        prodantiguo.setPrice(producto.getPrice());
        prodantiguo.setQuantity(producto.getQuantity());
        prodantiguo.setPhotography(producto.getPhotography());

        return repository.save(prodantiguo);
    }
    
    public void deleteProducto(String id){
        repository.deleteById(id);
    }     
    
    
    
}
