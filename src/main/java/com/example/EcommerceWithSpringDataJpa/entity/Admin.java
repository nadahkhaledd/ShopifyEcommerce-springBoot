package com.example.EcommerceWithSpringDataJpa.entity;


import com.example.EcommerceWithSpringDataJpa.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Setter
@Getter
@DiscriminatorValue("0")
public class Admin extends  User{
    public Admin(String email){
        this.setEmail(email);
    }


}