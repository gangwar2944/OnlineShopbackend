package com.Shop.Ecommerce.EntityDto;

import com.Shop.Ecommerce.Entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String catName;
    private String title;
    private String img;

    private List<ProductDto> products;
}
