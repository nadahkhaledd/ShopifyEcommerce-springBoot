package com.example.EcommerceWithSpringDataJpa.entity;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private Long id;

    @NotBlank
    @NotNull
    @Column(nullable = false, length = 45)
    private String name;

    @NotBlank
    @NotNull
    @Column(name = "image_path", nullable = false, length = 300)
    private String imagePath;

    @NotNull
    @Column(nullable = false)
    @Min(1)
    private double price;

    @ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    private String description = "";

    @NotNull
    @Column(name = "available_quantity", nullable = false)
    @Min(0)
    private int availableQuantity;

    @Transient
    private double rate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderDetails> orderDetails;

    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE},mappedBy = "product",fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Rate> rates;

    public Product() {
        this.rate = 0;
    }

    public Product(String name, String imagePath, double price, Category category, int availableQuantity) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.category = category;
        this.availableQuantity = availableQuantity;
        this.rate = 0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
