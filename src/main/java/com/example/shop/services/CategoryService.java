package com.example.shop.services;

import com.example.shop.dto.ProductDto;
import com.example.shop.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    public String save(CategoryEntity categoryEntity);

    public void saveAll(List<CategoryEntity> categoryEntities);

    public boolean isExist(Long id);

    public ProductDto getCategoryById(Long id);
}
