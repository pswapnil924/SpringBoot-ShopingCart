package com.tudip.converter;

import com.tudip.dto.ProductDto;
import com.tudip.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    public ProductDto entityToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setProductInStock(product.getProductInStock());
        productDto.setProductOutOfStock(product.isProductOutOfStock());
        productDto.setProductPrice(product.getProductPrice());
        return productDto;
    }

    public List<ProductDto> entityToDto(List<Product> product){
        return product.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }
}
