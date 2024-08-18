package com.ijse.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hello.entity.OrderEntity;
import com.ijse.hello.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity createOrder(OrderEntity order) throws Exception {
        // TODO Auto-generated method stub
        return orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        return orderRepository.findAll();
    }

}
