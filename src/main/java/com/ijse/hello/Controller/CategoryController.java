package com.ijse.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.entity.Category;
import com.ijse.hello.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService service;
    

   @PostMapping("/category") 
   public ResponseEntity<?>  createCategory(@RequestBody Category category){
    if (category.getName()==null ){
        return ResponseEntity.status(400).body("please Enter a valid Category");
    }
    try {
        Category createdCategory=service.createCategory(category);
        return ResponseEntity.status(201).body(createdCategory);
    } catch (Exception e) {
       
        return ResponseEntity.status(400).body(e.getMessage());
    }
    

   }

   @GetMapping("/category")

   public ResponseEntity<List<Category>> getAllCategory() {
    List<Category> category=service.getAll();
    return ResponseEntity.status(200).body(category);
   }


//    @PutMapping("Category/{categoryId}")
//    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId,@RequestBody Category category){
//     Category updatedCategory=service.

//    }


    


}
