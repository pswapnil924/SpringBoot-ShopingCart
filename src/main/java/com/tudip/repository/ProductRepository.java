package com.tudip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tudip.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("from Product where productName= :name")
	List<Product> searchProduct(@Param("name") String productName);
	
	@Query("from Product where productName= :name and productPrice between :maxPrice and :minPrice")
	List<Product> filterByPrice(@Param("name") String productName, @Param("maxPrice") float productPrice1,@Param("minPrice") float productPrice2);
	
	@Query("from Product where productName like :name%")
	List<Product> filterByName(@Param("name") String productName);
	
	@Modifying
	@Transactional
	@Query("update Product set productInStock= :stock where productId= :id")
	int updateProductInStock(@Param("stock") int productInStock, @Param("id") int productId);

	@Query(value = "select product_id, product_in_stock from product_info", nativeQuery = true)
	List<Object[]> checkProductStock();

	@Modifying
	@Transactional
	@Query(value = "update Product set isProductOutOfStock= ?1 where productId= ?2")
	int changeProductStockStatus(boolean status, int productId);
}
