package com.Shop.Ecommerce.EntityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String catName;

    private Set<ProductDto> products;
}
