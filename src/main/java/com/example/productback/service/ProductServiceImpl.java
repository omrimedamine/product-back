package com.example.productback.service;

import com.example.productback.dto.ProductDto;
import com.example.productback.exception.ProductNotFoundException;
import com.example.productback.model.Product;
import com.example.productback.repository.ProductRepository;
import com.example.productback.service.mapping.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return ProductMapper.INSTANCE.toProductDtos(productRepository.findAll());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = findProductById(id);
        return ProductMapper.INSTANCE.toProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product productSaved = productRepository.save(ProductMapper.INSTANCE.toProduct(productDto));
        return ProductMapper.INSTANCE.toProductDto(productSaved);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = findProductById(id);

        if (productDto.getCode() != null) {
            product.setCode(productDto.getCode());
        }
        if (productDto.getName() != null) {
            product.setName(productDto.getName());
        }
        if (productDto.getDescription() != null) {
            product.setDescription(productDto.getDescription());
        }
        if (productDto.getImage() != null) {
            product.setImage(productDto.getImage());
        }
        if (productDto.getCategory() != null) {
            product.setCategory(productDto.getCategory());
        }
        if (productDto.getPrice() != null) {
            product.setPrice(productDto.getPrice());
        }
        if (productDto.getQuantity() != null) {
            product.setQuantity(productDto.getQuantity());
        }
        if (productDto.getInternalReference() != null) {
            product.setInternalReference(productDto.getInternalReference());
        }
        if (productDto.getShellId() != null) {
            product.setShellId(productDto.getShellId());
        }
        if (productDto.getQuantity() != null) {
            product.setQuantity(productDto.getQuantity());
        }
        if (productDto.getRating() != null) {
            product.setRating(productDto.getRating());
        }

        Product productSaved = productRepository.save(product);
        return ProductMapper.INSTANCE.toProductDto(productSaved);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Product findProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }
}
