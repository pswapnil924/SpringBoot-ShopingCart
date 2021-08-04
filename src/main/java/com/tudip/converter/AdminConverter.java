package com.tudip.converter;

import com.tudip.dto.AdminDto;
import com.tudip.model.Admin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminConverter {

    public AdminDto entityToDto(Admin admin){

        AdminDto adminDto = new AdminDto();
        adminDto.setUserId(admin.getUserId());
        adminDto.setUserName(admin.getUserName());
        return adminDto;
    }

    public List<AdminDto> entityToDto(List<Admin> admin){
        return admin.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }
}
