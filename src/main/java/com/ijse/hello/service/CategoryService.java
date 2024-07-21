package com.ijse.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Category;

@Service
public interface CategoryService {
    Category createCategory(Category categoryEntity)throws Exception;
    List<Category> getAll();
    void deleteCategory(Long id);
    Category getCategoryById(Long id);

}
