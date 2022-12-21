package com.example.EcommerceWithSpringDataJpa.repository;

import com.example.EcommerceWithSpringDataJpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a INNER JOIN a.customer c WHERE c.id=:userId")
    List<Address> getUserAddresses(int userId);

}
