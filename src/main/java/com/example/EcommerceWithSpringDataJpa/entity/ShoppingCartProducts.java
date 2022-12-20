package com.example.EcommerceWithSpringDataJpa.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ShoppingCartProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @NotNull
    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    @OneToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public ShoppingCartProducts(int productQuantity, Product product, User user) {
        this.productQuantity = productQuantity;
        this.product = product;
        this.user = user;
    }
}
