package com.example.ecommercewithspringdatajpa.service.user;

import com.example.ecommercewithspringdatajpa.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User getByID(Integer id);
    User getByEmail(String email);

    String getUserNameByID(Integer id);
}
