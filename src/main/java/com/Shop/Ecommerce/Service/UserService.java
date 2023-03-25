package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.Entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<User> getUserList();
}
