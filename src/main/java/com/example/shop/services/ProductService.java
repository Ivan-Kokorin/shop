package com.example.shop.services;

import com.example.shop.dto.ProductDto;
import com.example.shop.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public String save(ProductDto productDto);
    public String update(ProductDto productDto);

    public void saveAll(List<ProductDto> productDtos);

    public boolean isExist(String id);

    public ProductDto getProductById(String id);

    public List<ProductDto> getAllProductCategory(Long idCategory);
}
