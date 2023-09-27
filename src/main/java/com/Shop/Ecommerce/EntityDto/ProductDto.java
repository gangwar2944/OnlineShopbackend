package com.Shop.Ecommerce.EntityDto;

import com.Shop.Ecommerce.Entity.Order;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String description;
    private String image;
    private Long categoryId;
    private String title;
    private String size;
    private String color;
    private Double price;
    private Set<CartDto> cart;
    private Order orders;

}
