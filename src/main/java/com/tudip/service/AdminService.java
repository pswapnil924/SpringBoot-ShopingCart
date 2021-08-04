package com.tudip.service;

import com.tudip.dto.AdminDto;
import com.tudip.model.Admin;

import java.util.List;

public interface AdminService {

    int registerAdmin(Admin admin);

    List<AdminDto> checkAdmin();

    AdminDto loginAdmin(String userEmail, String userPwd);
}
