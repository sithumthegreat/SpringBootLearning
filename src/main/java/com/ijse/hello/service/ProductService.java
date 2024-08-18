package com.ijse.hello.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.ProductEntity;
@Service
public interface ProductService {
    ProductEntity createProduct(ProductEntity entity);
    List<ProductEntity> getAllProduct();
    ProductEntity getProductById(Long id);
    ProductEntity updateProduct(Long id,ProductEntity entity);
    void deleteProduct(Long id);



}
