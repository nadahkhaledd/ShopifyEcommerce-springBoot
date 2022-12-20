package com.example.EcommerceWithSpringDataJpa.service.admin;

import com.example.EcommerceWithSpringDataJpa.dto.UpdateUserDTO;
import com.example.EcommerceWithSpringDataJpa.entity.Admin;
import com.example.EcommerceWithSpringDataJpa.entity.User;
import com.example.EcommerceWithSpringDataJpa.enums.CustomerStatus;
import com.example.EcommerceWithSpringDataJpa.exception.UserNotFoundException;
import com.example.EcommerceWithSpringDataJpa.repository.AdminRepository;
import com.example.EcommerceWithSpringDataJpa.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService{
    private final AdminRepository adminRepository;
    private final IUserService userService;

    @Autowired
    public AdminService(AdminRepository adminRepository, IUserService userService){
        this.adminRepository = adminRepository;
        this.userService = userService;
    }


    @Override
    public Admin save(Admin admin) {
        admin.setPasswordAttempts(0);
        admin.setStatus(CustomerStatus.ACTIVATED);

       return adminRepository.save(admin);
    }

    @Override
    public Admin getByID(Integer id) {
        return adminRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Admin getByEmail(String email) {
        return adminRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public Admin update(Integer id, UpdateUserDTO admin) {
        adminRepository.update(id, admin.getFirstName(), admin.getLastName(),
                admin.getEmail(), admin.getPassword(), admin.getGender(), admin.getDateOfBirth());
        return adminRepository.findById(id).get();
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    @Override
    public void deleteByID(Integer id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void deactivateCustomer(Integer id) {
        adminRepository.deactivateCustomer(id, CustomerStatus.DEACTIVATED);
    }
}
