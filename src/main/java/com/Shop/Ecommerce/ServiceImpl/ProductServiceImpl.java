package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.Category;
import com.Shop.Ecommerce.Entity.Product;
import com.Shop.Ecommerce.EntityDto.CategoryDto;
import com.Shop.Ecommerce.EntityDto.ProductDto;
import com.Shop.Ecommerce.Repository.CategoryRepo;
import com.Shop.Ecommerce.Repository.ProductRepo;
import com.Shop.Ecommerce.Response.HttpStatus;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.CategoryService;
import com.Shop.Ecommerce.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductService productService;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProducts(Long catId) {
        List<Product> prodList;
        if (catId == 0) {
            prodList = productRepo.findAll();
        } else {
            prodList = productRepo.findByCategoryId(catId);
        }
        return prodList.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public MessageResponse getByIdProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isPresent()){
            return new MessageResponse("this is record", HttpStatus.FOUND,modelMapper.map(product,ProductDto.class));
        }else{
            return new MessageResponse("data not found from this id",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Category category = categoryRepo.findById(productDto.getCategoryId()).orElse(null);

        Product order = productRepo.findById(productDto.getId()).get();
        Product product = modelMapper.map(productDto,Product.class);
        product.setCategory(category);
        Product save = productRepo.save(product);
        return modelMapper.map(save,ProductDto.class);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        Category category = categoryRepo.findById(productDto.getCategoryId()).orElse(null);

        Product product = modelMapper.map(productDto,Product.class);
        product.setCategory(category);
        Product save = productRepo.save(product);
        return modelMapper.map(save,ProductDto.class);
    }

    @Override
    public MessageResponse deleteProduct(Long id) {
        Optional<Product> byId = productRepo.findById(id);
        if(byId.isPresent()){
            productRepo.deleteById(id);
            return new MessageResponse("item remove successfully", HttpStatus.SUCCESS);
        }else{
            return new MessageResponse("there are no item is present in db from this id",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<ProductDto> getAllProductsByCatgoryId(Long catId) {
        List<Product> byCategoryId = productRepo.findByCategoryId(catId);
        if(!byCategoryId.equals(null)){
            return byCategoryId.stream().map(cat -> this.modelMapper.map(cat, ProductDto.class)).collect(Collectors.toList());
        }else{
            return null;
        }
    }
}
