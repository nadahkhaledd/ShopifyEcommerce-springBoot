package com.example.EcommerceWithSpringDataJpa.service.customer;

import com.example.EcommerceWithSpringDataJpa.dto.UpdateUserDTO;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;

import java.util.List;

public interface ICustomerService {

    Customer register(Customer customer);

    void activate(Integer id);

    Customer getByID(Integer id);

    Customer getByEmail(String email);

    Customer update(Integer id, UpdateUserDTO customer);

    List<Customer> getAll();
}
