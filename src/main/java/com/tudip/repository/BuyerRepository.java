package com.tudip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tudip.model.Buyer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer>{

    @Query("select b from Buyer b where b.userEmail= :email and b.userPwd= :pwd")
    Buyer loginBuyer(@Param("email") String userEmail, @Param("pwd") String userPwd);

    @Modifying
    @Transactional
    @Query("update Buyer set isUserBlocked = true where userId= ?1")
    int blockBuyer(int userId);

    @Modifying
    @Transactional
    @Query("update Buyer set isUserBlocked= false where userId= ?1")
    int unBlockBuyer(int userId);

    @Query(value = "select is_user_blocked from user_info where user_email= ?1", nativeQuery = true)
    boolean buyerStatus(String userEmail);
}
