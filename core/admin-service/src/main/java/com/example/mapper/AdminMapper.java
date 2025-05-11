package com.example.mapper;

import com.example.dto.AdminDto;
import com.example.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toAdmin(AdminDto adminDto);

    AdminDto toAdminDto(Admin admin);

    @Mapping(target = "id", ignore = true)
    void updateAdminFromDto(Admin admin, AdminDto adminDto);
}
