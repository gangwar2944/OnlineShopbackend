package com.Shop.Ecommerce.EntityDto;

import com.Shop.Ecommerce.Entity.Product;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long OrderId;
    private List<ProductDto> products;
    private Integer amount;
    private String address;
    private String pending;
}
