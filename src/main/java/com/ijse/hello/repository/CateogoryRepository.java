package com.ijse.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hello.entity.Category;
@Repository
public interface CateogoryRepository extends JpaRepository<Category,Long>{

}
