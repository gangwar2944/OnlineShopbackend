package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.User;
import com.Shop.Ecommerce.Repository.UserRepository;
import com.Shop.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
