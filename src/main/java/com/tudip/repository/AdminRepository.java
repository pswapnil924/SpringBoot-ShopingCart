package com.tudip.repository;

import com.tudip.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("select a from Admin a where a.userEmail= ?1 and a.userPwd= ?2")
    Admin loginAdmin(String userEmail, String userPwd);
}
