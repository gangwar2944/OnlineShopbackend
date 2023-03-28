package com.Shop.Ecommerce.Repository;

import com.Shop.Ecommerce.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {
}
