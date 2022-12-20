package com.example.EcommerceWithSpringDataJpa.service.customer;

import com.example.EcommerceWithSpringDataJpa.dto.UpdateUserDTO;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;
import com.example.EcommerceWithSpringDataJpa.enums.CustomerStatus;
import com.example.EcommerceWithSpringDataJpa.exception.UserNotFoundException;
import com.example.EcommerceWithSpringDataJpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer register(Customer customer) {
        customer.setPasswordAttempts(0);
        customer.setStatus(CustomerStatus.DEACTIVATED);
        customer.setRates(new ArrayList<>());
        customer.setAddresses(new ArrayList<>());
        customer.setShoppingCartProducts(new HashSet<>());

        return customerRepository.save(customer);
    }

    @Override
    public void activate(Integer id) {
         customerRepository.activate(id, CustomerStatus.ACTIVATED);

    }

    @Override
    public Customer getByID(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public Customer update(Integer id, UpdateUserDTO customer) {
        customerRepository.update(id, customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getPassword(), customer.getGender(), customer.getDateOfBirth());
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
