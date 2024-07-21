package com.ijse.hello.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReqDto {
    private String name;
    private String description;
    private Double price;
    
    private Long categoryId;

}
