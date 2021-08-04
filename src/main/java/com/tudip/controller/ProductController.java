package com.tudip.controller;

import java.util.List;

import com.tudip.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tudip.model.Product;
import com.tudip.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/check")
	public String check() {
		return "Welcome";
	}
	
	@PostMapping(path = "/addProduct")
	public String insertProduct(@RequestBody Product product) {
		String result;
		result = productService.addProduct(product) > 0 ? "Product Added" : "Try Again!!!";
		return result;
	}
	
	@GetMapping(path = "/searchProduct")
	public List<ProductDto> searchProduct(@RequestParam("name") String productName){
		return productService.searchProduct(productName);
	}
	
	@GetMapping(path = "/filterByPrice")
	public List<ProductDto> filterByPrice
(@RequestParam("name") String productName,@RequestParam("maxPrice") float productPrice1,@RequestParam("minPrice") float productPrice2){
		return productService.filterByPrice(productName, productPrice1, productPrice2);
	}
	
	@GetMapping(path = "/filterByName")
	public List<ProductDto> filterByName(@RequestParam("name") String productName){
		return productService.filterByName(productName);
	}
	
	@PutMapping(path = "/updateProductInStock")
	public String updateProductInStock(@RequestParam("stock") int productInStock, @RequestParam("id") int productId) {
		String result;
		result = productService.updateProductInStock(productInStock, productId) > 0 ? "Product Stock Updated" : "Try Again!!!";
		return result;
	}

	@GetMapping(path = "/checkProductStock")
	public List<Object[]> checkProductStock(){
		return productService.checkProductStock();
	}

	@DeleteMapping(path = "/deleteProduct")
	public String deleteProduct(@RequestParam("status") boolean status, @RequestParam("id") int productId){
		String result;
		result = productService.changeProductStockStatus(status, productId) > 0 ? "Status Updated" : "Try Again!!!";
		return result;
	}
}
