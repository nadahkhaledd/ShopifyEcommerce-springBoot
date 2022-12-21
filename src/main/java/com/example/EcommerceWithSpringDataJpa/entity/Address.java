package com.example.EcommerceWithSpringDataJpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String street ;
    @NotNull
    private int buildingNumber;
    @NotNull
    private String city;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "address")
    private List<Order> order;


    public Address(String street, int buildingNumber, String city) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.city = city;
    }

    public Address(String street, int buildingNumber, String city, Customer customer) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.customer = customer;
    }

}
