package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.EntityDto.CartDto;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/getAll")
    public List<CartDto> getAllCart(){
        return cartService.getAllCarts();
    }

    @GetMapping("/getAllCart/{userId}")
    public MessageResponse getCartDataByUserId(@PathVariable Long userId){
        return cartService.getCartDataByUserId(userId);
    }
    @GetMapping("/getAll/{id}")
    public MessageResponse getAllCart(@PathVariable Long id){
        return cartService.getByIdCarts(id);
    }

    @PostMapping("/saveCart")
    public CartDto saveCart(@RequestBody CartDto cartDto){
        if(cartDto.getId()!=null){
            return cartService.updateCart(cartDto);
        }else{
            return cartService.saveCart(cartDto);
        }
    }

    @DeleteMapping("/deleteCart/{id}")
    public MessageResponse deleteCart(@PathVariable Long id){
        return cartService.deleteCart(id);
    }


}
