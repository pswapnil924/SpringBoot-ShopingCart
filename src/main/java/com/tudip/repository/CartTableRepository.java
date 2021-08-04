package com.tudip.repository;

import com.tudip.model.CartTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartTableRepository extends JpaRepository<CartTable, Integer> {

    @Query("from CartTable where cartId= ?1")
    CartTable getCartTableByCartId(int cartId);
}
