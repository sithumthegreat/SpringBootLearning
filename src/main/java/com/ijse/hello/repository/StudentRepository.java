package com.ijse.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hello.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
