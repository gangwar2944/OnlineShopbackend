package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.EntityDto.CartDto;
import com.Shop.Ecommerce.EntityDto.CategoryDto;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.CartService;
import com.Shop.Ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getAll")
    public List<CategoryDto> getAllCart(){
        return categoryService.getAllCategoris();
    }

    @GetMapping("/getAll/{id}")
    public MessageResponse getAllCart(@PathVariable Long id){
        return categoryService.getCategoriesById(id);
    }

    @PostMapping("/saveCart")
    public CategoryDto saveCart(@RequestBody CategoryDto categoryDto){
        if(categoryDto.getId()!=null){
            return categoryService.updateCategory(categoryDto);
        }else{
            return categoryService.saveCategory(categoryDto);
        }
    }

    @DeleteMapping("/deleteCart/{id}")
    public MessageResponse deleteCart(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }


}
