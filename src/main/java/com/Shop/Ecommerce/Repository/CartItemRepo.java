package com.Shop.Ecommerce.Repository;

import com.Shop.Ecommerce.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem,Long> {
}
