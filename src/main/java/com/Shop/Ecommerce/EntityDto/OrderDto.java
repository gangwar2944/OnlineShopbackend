package com.Shop.Ecommerce.EntityDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long OrderId;
    private Long productId;
    private Integer amount;
    private AddressDto address;
    private double price;
    private Integer totalDiscountPrice;
    private String status;
    private Integer totalItem;
    private LocalDateTime createdAt;
    private Long userId;
    private List<OrderItemDto> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;

    private AddressDto shippingAddress;

    private PaymentDetailDto paymentDetail = new PaymentDetailDto();

}
