package com.example.service.Impl;

import com.example.dto.AdminDto;
import com.example.exception.NotFoundException;
import com.example.mapper.AdminMapper;
import com.example.model.Admin;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;
    private final AdminRepository adminRepository;

    @Override
    public Admin createAdmin(AdminDto adminDto) {
        Admin admin = adminMapper.toAdmin(adminDto);
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long adminId) {
        return adminRepository.findById(adminId)
                .orElseThrow(() -> new NotFoundException("Нету такого админа по токим Id" + adminId));
    }

    @Override
    public Admin updateAdminById(Long adminId, AdminDto adminDto) {
        Admin existingAdmin = adminRepository.findById(adminId)
                .orElseThrow(() -> new NotFoundException("Нету такого админа по токим Id" + adminId));

        adminMapper.updateAdminFromDto(existingAdmin, adminDto);

        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.findById(adminId)
                .orElseThrow(() -> new NotFoundException("Нету такого админа по токим Id" + adminId));

        adminRepository.deleteById(adminId);
    }

}
