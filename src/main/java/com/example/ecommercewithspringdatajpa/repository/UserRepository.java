package com.example.ecommercewithspringdatajpa.repository;

import com.example.ecommercewithspringdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.firstName FROM User u WHERE id=:id")
    Optional<String> findUserNameByID(@Param("id") Integer id);

    @Query("FROM User WHERE email=:email")
    Optional<User> findByEmail(@Param("email") String email);
}
