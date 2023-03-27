package com.Shop.Ecommerce.Service;


import com.Shop.Ecommerce.Response.MessageResponse;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    MessageResponse getUserList();

}
