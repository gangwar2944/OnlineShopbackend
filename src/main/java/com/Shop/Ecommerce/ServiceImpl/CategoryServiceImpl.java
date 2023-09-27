package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.Category;
import com.Shop.Ecommerce.EntityDto.CategoryDto;
import com.Shop.Ecommerce.Repository.CategoryRepo;
import com.Shop.Ecommerce.Response.HttpStatus;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CategoryDto> getAllCategoris() {
        List<Category> all = categoryRepo.findAll();
        List<CategoryDto> collect = all.stream().map(x -> this.modelMapper.map(x, CategoryDto.class)).collect(Collectors.toList());

        return collect;
    }

    @Override
    public MessageResponse getCategoriesById(Long id) {
        Optional<Category> cart = categoryRepo.findById(id);
        if(cart.isPresent()){
            return new MessageResponse("this is record",HttpStatus.FOUND,modelMapper.map(cart,CategoryDto.class));
        }else{
            return new MessageResponse("data not found from this id",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public CategoryDto updateCategory(CategoryDto cartDto) {
        Optional<Category> cat = categoryRepo.findById(cartDto.getId());
        if(cat.isPresent()){
            Category cart1 = modelMapper.map(cartDto,Category.class);
            Category save = categoryRepo.save(cart1);
            return modelMapper.map(save,CategoryDto.class);
        }else{
            return null;
        }

    }

    @Override
    public CategoryDto saveCategory(CategoryDto cartDto) {
        Category cart = modelMapper.map(cartDto,Category.class);
        Category save = categoryRepo.save(cart);
        return modelMapper.map(save,CategoryDto.class);
    }

    @Override
    public MessageResponse deleteCategory(Long id) {
        Optional<Category> byId = categoryRepo.findById(id);
        if(byId.isPresent()){
            categoryRepo.deleteById(id);
            return new MessageResponse("item remove successfully", HttpStatus.FOUND);
        }else{
            return new MessageResponse("there are no item is present in db from this id",HttpStatus.NOT_FOUND);
        }
    }
}
