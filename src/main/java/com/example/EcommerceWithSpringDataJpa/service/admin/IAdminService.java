package com.example.EcommerceWithSpringDataJpa.service.admin;

import com.example.EcommerceWithSpringDataJpa.dto.UpdateUserDTO;
import com.example.EcommerceWithSpringDataJpa.entity.Admin;

import java.util.List;

public interface IAdminService {

    Admin save(Admin admin);

    Admin getByID(Integer id);

    Admin getByEmail(String email);

    Admin update(Integer id, UpdateUserDTO admin);

    List<Admin> getAll();

    void delete(Admin admin);

    void deleteByID(Integer id);

    void deactivateCustomer(Integer id);
}
