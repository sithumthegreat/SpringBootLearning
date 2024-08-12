package com.ijse.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Order;

@Service
public interface OrderService {
    List<Order> getAll() throws Exception;
    Order createOrder(Order orderEntity) throws Exception;


}
