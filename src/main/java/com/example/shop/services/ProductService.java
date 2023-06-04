package com.example.shop.services;

import com.example.shop.dto.ProductDto;
import com.example.shop.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    public ProductDto save(ProductDto productDto);

    public void saveAll(List<ProductDto> productDtos);

    public boolean isExist(Long id);

    public Optional<ProductEntity> getProductById(Long id);

    public List<ProductDto> getAllProductCategory(Long idCategory);
}
