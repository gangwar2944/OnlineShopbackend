package com.Shop.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String image;

    @ManyToMany
    private Set<Category> categories;

    private String size;
    private String color;
    private Double price;

    @ManyToMany
    private Set<Cart> cart;

    @ManyToOne
    @JoinColumn(name = "fk_order",nullable = false)
    private Order orders;
}
