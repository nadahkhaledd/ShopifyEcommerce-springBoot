package com.example.EcommerceWithSpringDataJpa.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Category {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 300)
    private String imagePath;

    @OneToMany( orphanRemoval=true ,mappedBy = "category", fetch = FetchType.EAGER,cascade  = CascadeType.ALL)
    private List<Product> products;

    public Category(String name, String imagePath, List<Product> products) {
        this.name = name;
        this.imagePath = imagePath;
        this.products = products;
    }

    public Category(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.products = new ArrayList<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
