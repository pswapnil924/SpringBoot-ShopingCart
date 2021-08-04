package com.tudip.service;

import java.util.List;

import com.tudip.dto.ProductDto;
import com.tudip.model.Product;

public interface ProductService {
	
	int addProduct(Product product);
	
	List<ProductDto> searchProduct(String productName);
	
	List<ProductDto> filterByPrice(String productName, float productPrice1, float productPrice2);
	
	List<ProductDto> filterByName(String productName);
	
	int updateProductInStock(int productInStock, int productId);

	List<Object[]> checkProductStock();

	int changeProductStockStatus(boolean status, int productId);
}
