package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmailOrPhone(String email, String phone);

    List<User> findByNameStartingWith(String prefix);

    List<User> findByNameEndingWith(String suffix);

    List<User> findByNameOrderBySurnameAsc(String name);

    boolean existsByEmail(String email);

    Page<User> findBySurnameContainingIgnoreCase(String partialSurname, Pageable pageable);

    List<User> findFirst2ByNameStartsWithOrderBySurname(String firstNameStartsWith);

    @Query("SELECT u FROM User u WHERE u.name = :customName")
    List<User> findUsersByCustomCondition(@Param("customName") String customName);

}