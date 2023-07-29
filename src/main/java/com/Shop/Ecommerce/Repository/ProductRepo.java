package com.Shop.Ecommerce.Repository;

import com.Shop.Ecommerce.Entity.Category;
import com.Shop.Ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findByCategoryId(Long catId);

}
