package com.ijse.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.entity.ProductEntity;
import com.ijse.hello.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductEntity entity){
        if (entity.getName()==null || entity.getDescription()==""){
            return ResponseEntity.status(400).body("Please Enter a Valid product Name");
        }
        if (entity.getPrice()==null){
            return ResponseEntity.status(400).body("Please Enter a Price");
        }
        try {
            ProductEntity productEntity=service.createProduct(entity);
            return ResponseEntity.status(201).body(productEntity);
            
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }


    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductEntity>> getAllProduct(){
        List<ProductEntity> entities=service.getAllProduct();
        return ResponseEntity.status(201).body(entities);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id){
        ProductEntity entity=service.getProductById(id);
        if (entity==null){
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(entity);
        }

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id,@RequestBody ProductEntity entity){
        ProductEntity productEntity=service.updateProduct(id,entity);

        if (entity==null){
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(entity);
        }
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id){
        service.deleteProduct(id);

    }

}
