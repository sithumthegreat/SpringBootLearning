package com.ijse.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Order;
import com.ijse.hello.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<com.ijse.hello.entity.Order> getAll() throws Exception {
        // TODO Auto-generated method stub
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order orderEntity) throws Exception {
        // TODO Auto-generated method stub
        return orderRepository.save(orderEntity);
    }

  


    

}
