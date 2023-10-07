package com.Shop.Ecommerce.Repository;

import com.Shop.Ecommerce.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address,Long> {

    List<Address> findByUserId(Long userId);

}
