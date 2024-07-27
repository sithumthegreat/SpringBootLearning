package com.ijse.hello.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ijse.hello.service.ClassService;
import com.ijse.hello.service.StudentService;

public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    

}
