package com.ijse.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Student;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Student findStudentById(Long studentId);


}
