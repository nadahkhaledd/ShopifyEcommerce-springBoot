package com.example.EcommerceWithSpringDataJpa.entity;

import com.example.EcommerceWithSpringDataJpa.enums.CustomerStatus;
import com.example.EcommerceWithSpringDataJpa.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@DiscriminatorValue("1")
public class Customer extends User {
     private CustomerStatus status=CustomerStatus.DEACTIVATED;
     private int passwordAttempts=0;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Rate> Rates;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private Set<ShoppingCartProducts> shoppingCartProducts;


    public Customer(int id, String firstName, String lastName, String email, String password, Gender gender, Date dateOfBirth, CustomerStatus status, int passwordAttempts) {
        super(id, firstName, lastName, email, password, gender, dateOfBirth);
        this.status = status;
        this.passwordAttempts = passwordAttempts;
        this.addresses = new ArrayList<>();
    }

    public Customer(int id, String firstname, String lastname, String email, String password, Gender gender, Date dateOfBirth, CustomerStatus status, int passwordAttempts, List<Address> addresses) {
        super(id, firstname, lastname, email, password, gender, dateOfBirth);
        this.status = status;
        this.passwordAttempts = passwordAttempts;
        this.addresses = addresses;
    }

    public Customer(String firstname, String lastname, String email, String password, Gender gender, Date dateOfBirth, CustomerStatus status, int passwordAttempts, List<Address> addresses) {
        super(firstname, lastname, email, password, gender, dateOfBirth);
        this.status = status;
        this.passwordAttempts = passwordAttempts;
        this.addresses = addresses;
    }

    public Customer(int id, String firstName, String lastName, String email, String password, Gender gender, Date dateOfBirth, CustomerStatus status) {
        super(id, firstName, lastName, email, password, gender, dateOfBirth);
        this.status = status;
    }

}
