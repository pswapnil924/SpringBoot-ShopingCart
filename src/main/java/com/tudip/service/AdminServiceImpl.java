package com.tudip.service;

import com.tudip.converter.AdminConverter;
import com.tudip.dto.AdminDto;
import com.tudip.model.Admin;
import com.tudip.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    AdminConverter adminConverter;

    public int registerAdmin(Admin admin){
        Admin admin1 =  adminRepository.save(admin);
        return admin1.getUserId();
    }

    public List<AdminDto> checkAdmin(){
        return adminConverter.entityToDto(adminRepository.findAll());
    }

    public AdminDto loginAdmin(String userEmail, String userPwd){
        AdminDto adminDto = new AdminDto();
        BeanUtils.copyProperties(adminRepository.loginAdmin(userEmail, userPwd), adminDto);
        return adminDto;

    }
}

