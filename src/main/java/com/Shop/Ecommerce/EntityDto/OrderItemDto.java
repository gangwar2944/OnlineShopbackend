package com.Shop.Ecommerce.EntityDto;

import com.Shop.Ecommerce.Entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private Long id;

    private Order order;

    private String size;

    private Integer price;

    private Integer discountedPrice;

    private Integer quantity;

    private Long userId;

    private LocalDateTime deliveryDate;
}
