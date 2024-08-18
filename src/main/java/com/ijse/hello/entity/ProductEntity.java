package com.ijse.hello.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String Description;

    @Column(nullable = false)
    private Double price;

    
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
     
    @JsonIgnore
    @ManyToMany(mappedBy="orderedProducts")
    private List<OrderEntity> orders;
    
   

}
