package com.Shop.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String catName;
//    @ManyToMany
//    private Set<Product> products;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> posts = new ArrayList<>();

}
