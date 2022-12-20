package com.example.EcommerceWithSpringDataJpa.service.user;

import com.example.EcommerceWithSpringDataJpa.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User getByID(Integer id);
    User getByEmail(String email);

    String getUserNameByID(Integer id);
}
