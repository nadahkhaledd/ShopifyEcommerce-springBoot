package com.example.EcommerceWithSpringDataJpa.repository;

import com.example.EcommerceWithSpringDataJpa.entity.Admin;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;
import com.example.EcommerceWithSpringDataJpa.enums.CustomerStatus;
import com.example.EcommerceWithSpringDataJpa.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("FROM User where email NOT LIKE '%shopify.com'")
    @Override
    List<Customer> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE User set firstName=:firstName, lastName=:lastName," +
            " email=:email, password=:password, gender=:gender, dateOfBirth=:dateOfBirth" +
            " WHERE id=:id")
    void update(Integer id, String firstName, String lastName, String email,
                String password, Gender gender, Date dateOfBirth);

    @Query("FROM User WHERE email=:email")
    Optional<Customer> findByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE User SET status=:status WHERE id=:id")
    void activate(Integer id, CustomerStatus status);
}
