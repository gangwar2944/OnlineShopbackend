package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.EntityDto.OrderDto;
import com.Shop.Ecommerce.EntityDto.ProductDto;
import com.Shop.Ecommerce.Repository.OrderRepo;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.OrderService;
import com.Shop.Ecommerce.unit.PathUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(PathUrl.BASE_URL)
public class OrderController {

    @Autowired
    OrderService orderService;
    @GetMapping(PathUrl.GET_ALL_ORDER)
    public List<OrderDto> getAllOrder(){
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
