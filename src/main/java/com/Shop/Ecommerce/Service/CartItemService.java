package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.Entity.CartItem;

public interface CardItemService {

    public CartItem createCartItem(CartItem cartItem);

    public  CartItem updateCartItem(Long id,CartItem cartItem);

    public void removeCartItem(Long userId,Long cartItemId);
}
