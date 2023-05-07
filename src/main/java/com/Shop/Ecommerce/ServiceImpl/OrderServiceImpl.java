package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.Order;
import com.Shop.Ecommerce.EntityDto.OrderDto;
import com.Shop.Ecommerce.EntityDto.ProductDto;
import com.Shop.Ecommerce.Repository.OrderRepo;
import com.Shop.Ecommerce.Response.HttpStatus;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> all = orderRepo.findAll();
        List<OrderDto> collect = all.stream().map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());

        return collect;
    }

    @Override
    public MessageResponse getByIdOrder(Long id) {
        Optional<Order> order = orderRepo.findById(id);
        if(order.isPresent()){
            return new MessageResponse("this is record", HttpStatus.FOUND,modelMapper.map(order, ProductDto.class));
        }else{
            return new MessageResponse("data not found from this id",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Order order = orderRepo.findById(orderDto.getOrderId()).get();
        Order product = modelMapper.map(orderDto,Order.class);
        Order save = orderRepo.save(product);
        return modelMapper.map(save, OrderDto.class);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Order product = modelMapper.map(orderDto,Order.class);
        Order save = orderRepo.save(product);
        return modelMapper.map(save, OrderDto.class);
    }

    @Override
    public MessageResponse deleteOrder(Long id) {
        Optional<Order> byId = orderRepo.findById(id);
        if(byId.isPresent()){
            orderRepo.deleteById(id);
            return new MessageResponse("item remove successfully", HttpStatus.SUCCESS);
        }else{
            return new MessageResponse("there are no item is present in db from this id",HttpStatus.NOT_FOUND);
        }
    }
}
