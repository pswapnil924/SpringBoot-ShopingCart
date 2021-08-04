package com.tudip.repository;

import com.tudip.model.Buyer;
import com.tudip.model.Order;
import com.tudip.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("from Order where orderId= :id")
    List<Order> trackOrder(@Param("id") int orderId);

    @Query("from Order where buyer= :id")
    List<Order> oldOrder(@Param("id") Buyer buyer);

    @Modifying
    @Transactional
    @Query("update Order set orderStatus= :status where orderId= :id")
    void deliverOrder(@Param("status") OrderStatus orderStatus, @Param("id") int orderId);
}
