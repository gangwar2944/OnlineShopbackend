package com.Shop.Ecommerce.Repository;

import com.Shop.Ecommerce.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

    @Query(value = "SELECT * FROM shopdata.cart where user_id_id=:userId",nativeQuery = true)
    Optional<Cart> findByUserId(Long userId);

}
