package com.example.EcommerceWithSpringDataJpa.controller;

import com.example.EcommerceWithSpringDataJpa.entity.User;
import com.example.EcommerceWithSpringDataJpa.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    @Produces({MediaType.APPLICATION_JSON})
    public Object users(@QueryParam("email") Optional<String> email){
        if(email.isPresent())
            return userService.getByEmail(email.get());

        return userService.getAll();
    }

    @GetMapping("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ResponseBody
    public User usersBy(@PathVariable("id") String id){
            return userService.getByID(Integer.parseInt(id));
    }


}
