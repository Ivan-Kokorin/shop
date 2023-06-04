package com.example.shop.services;

import com.example.shop.dto.ProductDto;
import com.example.shop.entities.ProductEntity;
import com.example.shop.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        Long idProd = productEntity.getId();
        if (isExist(idProd)) {
            ProductEntity saveProduct = productRepository.save(productEntity);
            return modelMapper.map(saveProduct, ProductDto.class);
        } else {
            return new ProductDto();
        }

    }

    @Override
    public void saveAll(List<ProductDto> productDtos) {
        for (ProductDto productDto : productDtos) {
            save(productDto);
        }
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
        List<ProductEntity> products = productRepository.findByCategory(idCategory);
        return products.stream().map(this::toProductDto).collect(Collectors.toList());
    }

    private ProductDto toProductDto(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }
}
