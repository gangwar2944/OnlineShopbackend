package com.Shop.Ecommerce.Repository;

import com.Shop.Ecommerce.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {
}
