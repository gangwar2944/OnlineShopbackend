package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.Entity.CartItem;

import java.util.Optional;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public  CartItem updateCartItem(Long id,CartItem cartItem);

    public void removeCartItem(Long userId,Long cartItemId);

    public CartItem findbyCartItem(Long cartItemId,Long userId);

    public Optional<CartItem> isCartItemExist(Long cartItemId, Long userId);

}
