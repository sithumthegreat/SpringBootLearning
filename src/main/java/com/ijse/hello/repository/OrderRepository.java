package com.ijse.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hello.entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
                
}
