package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.User;
import com.Shop.Ecommerce.EntityDto.UserDto;
import com.Shop.Ecommerce.Repository.UserRepository;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

   @Autowired
   ModelMapper modelMapper;

    @Override
    public MessageResponse getUserList() {
        List<User> data = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        data.forEach(x->{
            userDtos.add(modelMapper.map(x,UserDto.class));
        });
        return new MessageResponse("All data list",HttpStatus.FOUND,userDtos);
    }

}
