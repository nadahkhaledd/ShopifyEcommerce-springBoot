package com.example.EcommerceWithSpringDataJpa.controller;

import com.example.EcommerceWithSpringDataJpa.dto.UpdateUserDTO;
import com.example.EcommerceWithSpringDataJpa.entity.Admin;
import com.example.EcommerceWithSpringDataJpa.entity.User;
import com.example.EcommerceWithSpringDataJpa.service.admin.IAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admins")
public class AdminController {

    private IAdminService adminService;

    public AdminController(IAdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("")
    @Produces({MediaType.APPLICATION_JSON})
    public Object admins(@QueryParam("email") Optional<String> email){
        if(email.isPresent())
            return adminService.getByEmail(email.get());

        return adminService.getAll();
    }

    @GetMapping("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ResponseBody
    public User adminBy(@PathVariable("id") String id){
        return adminService.getByID(Integer.parseInt(id));
    }

    @GetMapping("/deactivate/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> deactivateCustomer(@PathVariable("id") String id){
        adminService.deactivateCustomer(Integer.parseInt(id));
        return new ResponseEntity<>("customer deactivated successfully", HttpStatus.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") String id)
    {
        adminService.deleteByID(Integer.parseInt(id));
        return new ResponseEntity<>("admin deleted successfully", HttpStatus.valueOf(200));
    }

    @PostMapping("/new")
    public ResponseEntity<Admin> save(@RequestBody Admin admin){
        Admin savedAdmin =  adminService.save(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.valueOf(201));
    }

    @PatchMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Admin> update( @PathVariable("id") Integer id, @RequestBody UpdateUserDTO userDTO){
        Admin admin =  adminService.update(id, userDTO);
        return new ResponseEntity<>(admin, HttpStatus.valueOf(200));
    }




}
