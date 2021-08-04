package com.tudip.controller;

import com.tudip.dto.AdminDto;
import com.tudip.model.Admin;
import com.tudip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/check")
    public String check(){
        return "Welcome";
    }

    @PostMapping(path = "/register")
    public String registerAdmin(@RequestBody Admin admin){
        String result;
        result = adminService.registerAdmin(admin) > 0 ? "Admin Registered" : "Try Again!!!";
        return result;
    }

    @GetMapping(path = "/getAdmin")
    public List<AdminDto> getAdmin(){
        return adminService.checkAdmin();
    }

    @GetMapping(path = "/login")
    public AdminDto loginAdmin(@RequestBody Admin admin){
        String userEmail = admin.getUserEmail();
        String userPwd = admin.getUserPwd();
        return adminService.loginAdmin(userEmail, userPwd);
    }
}
