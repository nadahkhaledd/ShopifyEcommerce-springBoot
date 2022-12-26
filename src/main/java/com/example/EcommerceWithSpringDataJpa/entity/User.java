package com.example.EcommerceWithSpringDataJpa.entity;

import com.example.EcommerceWithSpringDataJpa.enums.CustomerStatus;
import com.example.EcommerceWithSpringDataJpa.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity(name="User")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @Column(nullable = false, length = 30)
    private String firstName;
    @NotNull
    @Column(nullable = false, length = 30)
    private String lastName;

    @Column
    private int passwordAttempts=0;
    @NotNull
    @Column(nullable = false, unique = true,length = 150)
    private String email;
    @NotNull
    @Column(nullable = false)
    private String password;
    @NotNull
    private Gender gender;
    @NotNull
    private Date dateOfBirth;

    @Column
    private CustomerStatus status;

    public User(String email){
        this.email = email;
    }

    public User(int id, String firstName, String lastName, String email, String password, Gender gender, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String firstName, String lastName, String email, String password, Gender gender, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

}