package com.example.springdatajpa.service;

import com.example.springdatajpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User saveUser(User user);

    void deleteUser(Long id);

    List<User> findByEmailOrPhone(String email, String phone);

    List<User> findByNameStartingWith(String prefix);

    List<User> findByNameEndingWith(String suffix);

    List<User> findByNameOrderBySurnameAsc(String name);

    boolean existsByEmail(String email);
    Page<User> findBySurnameContainingIgnoreCase(String partialSurname, Pageable pageable);
    List<User> findFirst2ByNameStartsWithOrderBySurname(String firstNameStartsWith);
    List<User> findUsersByCustomCondition(String customName);
}