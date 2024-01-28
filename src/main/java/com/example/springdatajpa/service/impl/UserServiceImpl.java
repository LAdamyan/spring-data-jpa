package com.example.springdatajpa.service.impl;

import com.example.springdatajpa.model.User;
import com.example.springdatajpa.repository.UserRepository;
import com.example.springdatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Custom method in service to find users by email or phone
    @Override
    public List<User> findByEmailOrPhone(String email, String phone) {
        return userRepository.findByEmailOrPhone(email, phone);
    }

    // Custom method in service to find users by name starting with a specific prefix
    @Override
    public List<User> findByNameStartingWith(String prefix) {
        return userRepository.findByNameStartingWith(prefix);
    }

    // Custom method in service to find users by name ending with a specific suffix
    @Override
    public List<User> findByNameEndingWith(String suffix) {
        return userRepository.findByNameEndingWith(suffix);
    }

    // Custom method in service to find users by name and order by surname in ascending order
    @Override
    public List<User> findByNameOrderBySurnameAsc(String name) {
        return userRepository.findByNameOrderBySurnameAsc(name);
    }

    // Custom method in service to check if a user with a specific email exists
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // Custom method in service to find users by a partial, case-insensitive match on their surname with pagination
    @Override
    public Page<User> findBySurnameContainingIgnoreCase(String partialSurname, Pageable pageable) {
        return userRepository.findBySurnameContainingIgnoreCase(partialSurname, pageable);
    }
    // Custom method to find the first 2 users whose names start with the specified prefix
    @Override
    public List<User> findFirst2ByNameStartsWithOrderBySurname(String firstNameStartsWith) {
        return userRepository.findFirst2ByNameStartsWithOrderBySurname(firstNameStartsWith);
    }
    // Custom method to find users by a custom condition
    @Override
    public List<User> findUsersByCustomCondition(String customName) {
        return userRepository.findUsersByCustomCondition(customName);
    }
}
