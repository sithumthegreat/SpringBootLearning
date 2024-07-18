package com.ijse.hello.Controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateProductController {
    @PutMapping("/updateProduct")
    public String updateProduct(){
        return "PUT request to updateProduct end point";
    }

}
