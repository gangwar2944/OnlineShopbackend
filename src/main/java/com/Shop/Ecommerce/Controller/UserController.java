package com.Shop.Ecommerce.Controller;


import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getData")
    public MessageResponse getUser(){

       return userService.getUserList();
    }

}
