package com.example.shop.services;

import com.example.shop.dto.ProductDto;
import com.example.shop.entities.CategoryEntity;
import com.example.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String save(CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public void saveAll(List<CategoryEntity> categoryEntities) {

    }

    @Override
    public boolean isExist(Long id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public ProductDto getCategoryById(Long id){
        return null;
    }
}
