package com.example.shop.services;

import com.example.shop.dto.ProductDto;
import com.example.shop.entities.ProductEntity;
import com.example.shop.repositories.ProductRepository;
import com.example.shop.utils.ObjectMapper;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        ProductEntity productEntity = ObjectMapper.toProductEntity(productDto);
        ProductEntity save = productRepository.save(productEntity);
        return productDto;
    }

    @Override
    public void saveAll(List<ProductDto> productDtos) {
        productDtos.forEach(this::save);
    }

    @Override
    public boolean isExist(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductDto> getAllProductCategory(Long idCategory) {
        List<ProductEntity> products = productRepository.findByCategory_Id(idCategory);
        return products.stream().map(this::toProductDto).collect(Collectors.toList());
    }

    private ProductDto toProductDto(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }
}
