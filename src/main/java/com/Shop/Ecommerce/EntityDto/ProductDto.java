package com.Shop.Ecommerce.EntityDto;

import com.Shop.Ecommerce.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String description;
    private String image;
    private Set<CategoryDto> categories;

    private String size;
    private String color;
    private Double price;
    private Set<CartDto> cart;
    private Order orders;
}
