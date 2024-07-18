package com.ijse.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hello.entity.ProductEntity;
import com.ijse.hello.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;

    @Override
    public ProductEntity createProduct(ProductEntity entity) {
        return repository.save(entity);


        
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public ProductEntity getProductById(Long id) {
        // TODO Auto-generated method stub
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductEntity entity) {
        // TODO Auto-generated method stub
       ProductEntity existingProduct=repository.findById(id).orElse(null);
       if (existingProduct==null){
        return null;
       }else{
        existingProduct.setDescription(entity.getDescription());
        existingProduct.setName(entity.getName());
        existingProduct.setPrice(entity.getPrice());
        return repository.save(existingProduct);

       }
    }

    @Override
    public void deleteProduct(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    

}
