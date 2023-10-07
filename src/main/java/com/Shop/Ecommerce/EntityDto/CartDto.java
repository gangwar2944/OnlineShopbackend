package com.Shop.Ecommerce.EntityDto;


import com.Shop.Ecommerce.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Integer total;
}
