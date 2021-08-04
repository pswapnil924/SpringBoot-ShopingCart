package com.tudip.repository;

import com.tudip.model.CartItem;
import com.tudip.model.CartTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query("from CartItem where cartTable= :table")
    List<CartItem> itemInCart(@Param("table") CartTable cartTable);
}
