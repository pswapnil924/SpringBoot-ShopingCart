package com.tudip.service;

import java.util.List;

import com.tudip.converter.ProductConverter;
import com.tudip.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudip.model.Product;
import com.tudip.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;

    public int addProduct(Product product) {
        Product product1 =  productRepository.save(product);
        return product1.getProductId();
    }

    public List<ProductDto> searchProduct(String productName){
        return productConverter.entityToDto(productRepository.searchProduct(productName));
    }

    public List<ProductDto> filterByPrice(String productName, float productPrice1, float productPrice2){
        return productConverter.entityToDto(productRepository.filterByPrice(productName, productPrice1, productPrice2));
    }

    public List<ProductDto> filterByName(String productName){
        return productConverter.entityToDto(productRepository.filterByName(productName));
    }

    public int updateProductInStock(int productInStock, int productId) {
        return productRepository.updateProductInStock(productInStock, productId);
    }

    public List<Object[]> checkProductStock(){
        return productRepository.checkProductStock();
    }

    public int changeProductStockStatus(boolean status, int productId){
        return productRepository.changeProductStockStatus(status,productId);
    }
}
