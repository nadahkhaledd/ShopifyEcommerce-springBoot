package com.example.ecommerceWithSpringDataJpa.service.user;

import com.example.ecommerceWithSpringDataJpa.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User getByID(Integer id);
    User getByEmail(String email);

    String getUserNameByID(Integer id);
}
