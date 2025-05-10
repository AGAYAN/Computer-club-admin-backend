package com.example.controller;

import com.example.dto.AdminDto;
import com.example.model.Admin;
import com.example.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/createAdmin")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Admin> createAdmin(AdminDto adminDto) {
        Admin admin = adminService.createAdmin(adminDto);
        return ResponseEntity.ok(admin);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long adminId) {
        Admin admin = adminService.getAdminById(adminId);
        return ResponseEntity.ok(admin);
    }

    @PatchMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdminById(@PathVariable Long adminId,
                                                 @RequestBody @Valid AdminDto adminDto) {
        Admin updateAdmin = adminService.updateAdminById(adminId, adminDto);
        return ResponseEntity.ok(updateAdmin);
    }

    @DeleteMapping("/{adminId}")
    public void deleteAdminById(@PathVariable Long adminId) {
        adminService.deleteAdminById(adminId);
    }
}
