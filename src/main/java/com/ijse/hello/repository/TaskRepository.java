package com.ijse.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hello.entity.Task;

@Repository  //same as Dao
public interface TaskRepository  extends JpaRepository<Task,Long>{
    //custom queries
    

}
