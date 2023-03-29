package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.EntityDto.CartDto;
import com.Shop.Ecommerce.EntityDto.ProductDto;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


        @Autowired
        ProductService productService;
        @GetMapping("/getAll")
        public List<ProductDto> getAllProducts(){
            return productService.getAllProducts();
        }

        @GetMapping("/getAll/{id}")
        public MessageResponse getAllCart(@PathVariable Long id){
            return productService.getByIdProduct(id);
        }

        @PostMapping("/saveCart")
        public ProductDto saveCart(@RequestBody ProductDto productDto){
            if(productDto.getId()!=null){
                return productService.updateProduct(productDto);
            }else{
                return productService.saveProduct(productDto);
            }
        }

        @DeleteMapping("/deleteCart/{id}")
        public MessageResponse deleteCart(@PathVariable Long id){
            return productService.deleteProduct(id);
        }
}
