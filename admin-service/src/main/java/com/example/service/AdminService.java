package com.example.service;

import com.example.dto.AdminDto;
import com.example.model.Admin;

public interface AdminService {
    Admin createAdmin(AdminDto adminDto);

    Admin getAdminById(Long adminId);

    Admin updateAdminById(Long adminId, AdminDto adminDto);

    void deleteAdminById(Long adminId);


}
