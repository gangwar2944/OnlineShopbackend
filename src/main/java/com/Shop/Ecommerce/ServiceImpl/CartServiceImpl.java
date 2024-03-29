package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.Cart;
import com.Shop.Ecommerce.Entity.User;
import com.Shop.Ecommerce.EntityDto.CartDto;
import com.Shop.Ecommerce.Repository.CartRepo;
import com.Shop.Ecommerce.Repository.UserRepository;
import com.Shop.Ecommerce.Response.HttpStatus;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepo cartRepo;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> all = cartRepo.findAll();
        List<CartDto> collect = all.stream().map(x -> this.modelMapper.map(x, CartDto.class)).collect(Collectors.toList());

        return collect;
    }

    @Override
    public CartDto saveCart(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto,Cart.class);
        Optional<User> byId = userRepository.findById(cartDto.getUserId());
        if(byId.isPresent()){
            Optional<Cart> cart2 = cartRepo.findByUserId(cart.getUserId().getId());
            if(cart2.isPresent()){
                cart2.get().setProducts(cart.getProducts());
                cart2.get().setQuantity(cart.getQuantity());
                cart2.get().setTotal(cart.getTotal());
                Cart save = cartRepo.save(cart2.get());
                return modelMapper.map(save,CartDto.class);
            }else{
                Cart save = cartRepo.save(cart);
                return modelMapper.map(save,CartDto.class);
            }
        }else{
            return null;
        }

    }

    @Override
    public CartDto updateCart(CartDto cartDto) {
        Cart cart = cartRepo.findById(cartDto.getId()).get();
        Cart cart1 = modelMapper.map(cartDto,Cart.class);
        Cart save = cartRepo.save(cart1);
        return modelMapper.map(save,CartDto.class);
    }

    @Override
    public MessageResponse deleteCart(Long cartId) {
        Optional<Cart> byId = cartRepo.findById(cartId);
        if(byId.isPresent()){
            cartRepo.deleteById(cartId);
           return new MessageResponse("item remove successfully", HttpStatus.FOUND);
        }else{
            return new MessageResponse("there are no item is present in db from this id",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public MessageResponse getByIdCarts(Long id) {
        Optional<Cart> cart = cartRepo.findById(id);
        if(cart.isPresent()){
            return new MessageResponse("this is record",HttpStatus.FOUND,modelMapper.map(cart,CartDto.class));
        }else{
            return new MessageResponse("data not found from this id",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public MessageResponse getCartDataByUserId(Long userId) {

        Optional<Cart> cart = cartRepo.findByUserId(userId);
        if(cart.isPresent()){
            return new MessageResponse("this is record",HttpStatus.FOUND,modelMapper.map(cart,CartDto.class));
        }else{
            return new MessageResponse("data not found from this id",HttpStatus.NOT_FOUND);
        }
    }
}
