package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.EntityDto.OrderDto;
import com.Shop.Ecommerce.EntityDto.ProductDto;
import com.Shop.Ecommerce.Repository.OrderRepo;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @GetMapping("/getAll")
    public List<OrderDto> getAllProducts(){
        return orderService.getAllOrders();
    }

    @GetMapping("/getAll/{id}")
    public MessageResponse getAllCart(@PathVariable Long id){
        return orderService.getByIdOrder(id);
    }

    @PostMapping("/saveOrder")
    public OrderDto saveCart(@RequestBody OrderDto orderDto){
        if(orderDto.getOrderId()!=null){
            return orderService.updateOrder(orderDto);
        }else{
            return orderService.saveOrder(orderDto);
        }
    }

    @DeleteMapping("/deleteOrder/{id}")
    public MessageResponse deleteCart(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }
}
