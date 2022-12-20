package com.example.EcommerceWithSpringDataJpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rate_id")
    private int id;
    private int rate;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    private String description;


    public Rate(int rate,String description,Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
        this.description=description;
        this.rate=rate;
    }

}
