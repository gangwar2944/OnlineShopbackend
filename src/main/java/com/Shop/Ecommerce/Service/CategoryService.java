package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.EntityDto.CartDto;
import com.Shop.Ecommerce.EntityDto.CategoryDto;
import com.Shop.Ecommerce.Response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDto> getAllCategoris();

    MessageResponse getCategoriesById(Long id);

    CategoryDto updateCategory(CategoryDto cartDto);

    CategoryDto saveCategory(CategoryDto cartDto);

    MessageResponse deleteCategory(Long id);
}
