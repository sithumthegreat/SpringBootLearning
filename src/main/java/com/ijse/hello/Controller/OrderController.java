package com.ijse.hello.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.dto.OrderDto;
import com.ijse.hello.entity.Order;
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
    private ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto){
        try {
            List<Long> productIds=orderDto.getProductIds();
            Order order=new Order();
            List<ProductEntity> orderedProducts=new ArrayList<>();
            
            productIds.forEach(productId->{
                //get productbyID
                ProductEntity product=productService.getProductById(productId);
                
                
                if (product!=null){
                    //add it to the new Order
                    orderedProducts.add(product);
                    order.setPrice(order.getPrice()+product.getPrice());
                    //calculate total price

                }
               
                
            }
                
            );
            order.setOrderedProducts(orderedProducts);
            orderService.createOrder(order);
            return ResponseEntity.status(201).body(order);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(400).body(null);
        }
        

    }

    @GetMapping("/order")
    private ResponseEntity<List<Order>> getAllOrders()throws Exception{
        List<Order> orders=orderService.getAll();
        return ResponseEntity.status(201).body(orders);

    }
  

}
