package com.Shop.Ecommerce.EntityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long OrderId;
    private Long productId;
    private Integer amount;
    private AddressDto address;
    private String pending;
}
