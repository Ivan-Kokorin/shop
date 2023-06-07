package com.example.shop.services;

import com.example.shop.controllers.MyInternalServerException;
import com.example.shop.controllers.MyResourceNotFoundException;
import com.example.shop.controllers.RequestStatus;
import com.example.shop.dto.ProductDto;
import com.example.shop.entities.ProductEntity;
import com.example.shop.repositories.ProductRepository;
import com.example.shop.utils.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public String save(ProductDto productDto) {
        ProductEntity productEntity = ObjectMapper.toProductEntity(productDto);
        if (isExist(productEntity.getNumberSerial())) {
            throw new MyInternalServerException("This product already exist");
        } else {
            productRepository.save(productEntity);
            return RequestStatus.OK.getStatus() + " successful add product";
        }
    }

    @Override
    public String update(ProductDto productDto) {
        ProductEntity productEntity = ObjectMapper.toProductEntity(productDto);
        if (isExist(productEntity.getNumberSerial())) {
            ProductEntity productEntityById = productRepository.findById(productEntity.getNumberSerial()).get();
            System.out.println("Product from DB: " + productEntityById);
            System.out.println("Product from DTO: " + productEntity);
            productEntity = enrichmentDtoEntity(productEntity, productEntityById);
            System.out.println("Product arter enrichment: " + productEntity);
            productRepository.save(productEntity);
            return RequestStatus.OK.getStatus() + " successful update product";
        } else {
            throw new MyResourceNotFoundException("The product with this id was not found");
        }
    }

    private ProductEntity enrichmentDtoEntity(ProductEntity productEntity, ProductEntity productEntityById) {
        if (productEntity.getAmount() == 0) {
            productEntity.setAmount(productEntityById.getAmount());
        }
        if (productEntity.getBrand() == null || productEntity.getBrand().equals("")) {
            productEntity.setBrand(productEntityById.getBrand());
        }
        if (productEntity.getPrice() == 0) {
            productEntity.setPrice(productEntityById.getPrice());
        }
        if (productEntity.getCategory().getId() == null) {
            productEntity.setCategory(productEntityById.getCategory());
        }
        if (productEntity.getProperties() == null) {
            productEntity.setProperties(productEntityById.getProperties());
        }
        return productEntity;
    }

    @Override
    public void saveAll(List<ProductDto> productDtos) {
        productDtos.forEach(this::save);
    }

    @Override
    public boolean isExist(String id) {
        return productRepository.existsById(id);
    }

    @Override
    public ProductDto getProductById(String id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            return ObjectMapper.toProductDto(optionalProductEntity.get());
        } else {
            throw new MyResourceNotFoundException("The product with this id was not found");
        }
    }

    @Override
    public List<ProductDto> getAllProductCategory(Long idCategory) {
        if (categoryService.isExist(idCategory)) {
            List<ProductEntity> products = productRepository.findByCategory_Id(idCategory);
            return products.stream().map(ObjectMapper::toProductDto).collect(Collectors.toList());
        } else {
            throw new MyResourceNotFoundException("The category with this id was not found");
        }
    }
}
