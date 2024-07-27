package com.ijse.hello.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.service.ClassService;
@RestController
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping("/class")
    public ResponseEntity<Class> createClass(@RequestBody Class classes){
        try {
            Class createdClass=classService.createClass(classes);
            return ResponseEntity.status(200).body(createdClass);
            
        } catch (Exception e) {
            
            return ResponseEntity.status(400).body(null);
        }

    }

}
