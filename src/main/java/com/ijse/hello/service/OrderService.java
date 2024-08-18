package com.ijse.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.OrderEntity;

@Service
public interface OrderService {
    OrderEntity createOrder(OrderEntity order)throws Exception;
    List<OrderEntity> getAll()throws Exception;


}
