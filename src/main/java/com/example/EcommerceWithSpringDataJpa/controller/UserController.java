package com.example.EcommerceWithSpringDataJpa.controller;

import com.example.EcommerceWithSpringDataJpa.entity.User;
import com.example.EcommerceWithSpringDataJpa.service.user.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    @Produces({MediaType.APPLICATION_JSON})
    public Object users(@QueryParam("email") Optional<String> email, @QueryParam("id") Optional<Integer> id){
        if(email.isPresent())
            return userService.getByEmail(email.get());
        else if(id.isPresent())
            return userService.getByID(id.get());
        return userService.getAll();
    }




}
