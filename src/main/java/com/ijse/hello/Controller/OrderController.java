package com.ijse.hello.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/order")
    public String sayOrder(){
        return "Showing Order";
    }

}
