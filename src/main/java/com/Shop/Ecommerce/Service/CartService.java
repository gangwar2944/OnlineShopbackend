package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.Entity.Cart;
import com.Shop.Ecommerce.EntityDto.CartDto;
import com.Shop.Ecommerce.Response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<CartDto> getAllCarts();

    CartDto saveCart(CartDto cartDto);

    CartDto updateCart(CartDto cartDto);

    MessageResponse deleteCart(Long cartId);

     MessageResponse getByIdCarts(Long id);

    MessageResponse getCartDataByUserId(Long userId);



}
