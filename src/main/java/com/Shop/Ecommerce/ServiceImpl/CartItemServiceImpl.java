package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.CartItem;
import com.Shop.Ecommerce.Service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem updateCartItem(Long id, CartItem cartItem) {
        return null;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) {

    }

    @Override
    public CartItem findbyCartItem(Long cartItemId, Long userId) {
        return null;
    }

    @Override
    public Optional<CartItem> isCartItemExist(Long cartItemId, Long userId) {
        return Optional.empty();
    }
}
