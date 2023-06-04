package com.example.shop.services;

import com.example.shop.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public void save(ProductDto productDto);

    public void saveAll(List<ProductDto> productDtos);

    public boolean isExist(Long id);

    public List<ProductDto> getAllProduct();

    public ProductDto getProductById(Long id);

    public List<ProductDto> getAllProductCategory(Long idCategory);
}
