package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.Entity.Product;
import com.Shop.Ecommerce.EntityDto.CartDto;
import com.Shop.Ecommerce.EntityDto.ProductDto;
import com.Shop.Ecommerce.Response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    List<ProductDto> getAllProducts(Long catId);

    MessageResponse getByIdProduct(Long id);

    ProductDto updateProduct(ProductDto productDto);

    ProductDto saveProduct(ProductDto productDto);

    MessageResponse deleteProduct(Long id);

    List<ProductDto> getAllProductsByCatgoryId(Long catId);

//    public Page<Product> getAllProduct();
}
