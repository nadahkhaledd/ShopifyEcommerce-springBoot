package com.example.EcommerceWithSpringDataJpa.dto;

import com.example.EcommerceWithSpringDataJpa.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@AllArgsConstructor
@Getter
public class UpdateUserDTO {

    String firstName;
    String lastName;
    String email;
    String password;
    Gender gender;
    Date dateOfBirth;


}
