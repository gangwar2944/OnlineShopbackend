package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.EntityDto.OrderDto;
import com.Shop.Ecommerce.Response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<OrderDto> getAllOrders();

    MessageResponse getByIdOrder(Long id);

    OrderDto updateOrder(OrderDto orderDto);

    OrderDto saveOrder(OrderDto orderDto);

    MessageResponse deleteOrder(Long id);
}
