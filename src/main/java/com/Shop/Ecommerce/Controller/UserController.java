package com.Shop.Ecommerce.Controller;


import com.Shop.Ecommerce.Entity.User;
import com.Shop.Ecommerce.Service.UserService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getData")
    public List<User> getUser(){

        return userService.getUserList();

    }
}
