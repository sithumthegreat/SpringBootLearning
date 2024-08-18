package com.ijse.hello.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false)
    private LocalDateTime orderDateTime;
    @Column(nullable = false)
    private Double total_price;

    protected void onCreate(){
        this.orderDateTime=LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
        name = "order_product",
        joinColumns =@JoinColumn(name="orderId"),
        inverseJoinColumns =@JoinColumn(name = "id") 
    )
    private List<ProductEntity> orderedProducts;

}
