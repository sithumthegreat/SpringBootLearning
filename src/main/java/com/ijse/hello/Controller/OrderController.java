package com.ijse.hello.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.dto.OrderReqDto;
import com.ijse.hello.entity.OrderEntity;
import com.ijse.hello.entity.ProductEntity;
import com.ijse.hello.service.OrderService;
import com.ijse.hello.service.ProductService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @PostMapping("/order")
    private ResponseEntity<OrderEntity> createOrder(@RequestBody OrderReqDto order)throws Exception{
        try {
            List<Long> productIds=order.getProductIds();
            OrderEntity newOrder=new OrderEntity();
            List<ProductEntity> orderedProducts=new ArrayList<>();
            productIds.forEach(productId->{
                ProductEntity product=productService.getProductById(productId);

                if (product!=null){
                    orderedProducts.add(product);
                    newOrder.setTotal_price(newOrder.getTotal_price()+product.getPrice());
                }

            });
            orderService.createOrder(newOrder);
            return ResponseEntity.status(201).body(newOrder);

        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }

    }

    private ResponseEntity<List<OrderEntity>> getAll()throws Exception{
        List<OrderEntity> orders=orderService.getAll();
        return ResponseEntity.status(201).body(orders);
    }
}
