package com.ijse.hello.entity;

import java.time.LocalDateTime;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false)
    private LocalDateTime orderDateTime;
    @Column(nullable = false)
    private double price;

    @PrePersist
    protected void onCreate(){
        this.orderDateTime=LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name="orderId"),
        inverseJoinColumns=@JoinColumn(name="id")
        
    )
    private List<ProductEntity> orderedProducts;

}
