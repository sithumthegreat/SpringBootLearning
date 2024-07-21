package com.ijse.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Category;
import com.ijse.hello.repository.CateogoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CateogoryRepository repository;


    @Override
    public Category createCategory(Category categoryEntity) throws Exception {
        // TODO Auto-generated method stub
        return repository.save(categoryEntity);
    }

    @Override
    public List<Category> getAll()  {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public Category getCategoryById(Long id) {
        // TODO Auto-generated method stub
        return repository.findById(id).orElse(null);
    }

}
