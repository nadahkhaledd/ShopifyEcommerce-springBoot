package com.example.EcommerceWithSpringDataJpa.controller;

import com.example.EcommerceWithSpringDataJpa.dto.UpdateUserDTO;
import com.example.EcommerceWithSpringDataJpa.entity.Admin;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;
import com.example.EcommerceWithSpringDataJpa.entity.User;
import com.example.EcommerceWithSpringDataJpa.service.admin.IAdminService;
import com.example.EcommerceWithSpringDataJpa.service.customer.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private ICustomerService customerService;

    public CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("")
    @Produces({MediaType.APPLICATION_JSON})
    public Object customers(@QueryParam("email") Optional<String> email){
        if(email.isPresent())
            return customerService.getByEmail(email.get());

        return customerService.getAll();
    }

    @GetMapping("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ResponseBody
    public Customer customerBy(@PathVariable("id") String id){
        return customerService.getByID(Integer.parseInt(id));
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer){
        Customer saved =  customerService.register(customer);
        return new ResponseEntity<Customer>(saved, HttpStatus.valueOf(201));
    }

    @GetMapping("/activate/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> activate(@PathVariable("id") Integer id){
        customerService.activate(id);
        return new ResponseEntity<>("Customer activated successfully", HttpStatus.valueOf(200));
    }

    @PatchMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Customer> update( @PathVariable("id") Integer id, @RequestBody UpdateUserDTO userDTO){
        Customer customer =  customerService.update(id, userDTO);
        return new ResponseEntity<>(customer, HttpStatus.valueOf(200));
    }




}
