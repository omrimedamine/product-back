package com.example.productback.service.mapping;

import com.example.productback.dto.ProductDto;
import com.example.productback.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductDto productDto);
    ProductDto toProductDto(Product product);
    List<Product> toProducts(List<ProductDto> productDtos);
    List<ProductDto> toProductDtos(List<Product> products);
}
