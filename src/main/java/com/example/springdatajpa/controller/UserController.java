package com.example.springdatajpa.controller;// src/main/java/com/example/demo/controller/UserController.java

import com.example.springdatajpa.model.User;
import com.example.springdatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/findByEmailOrPhone")
    public List<User> findByEmailOrPhone(@RequestParam(required = false) String email,
                                         @RequestParam(required = false) String phone) {
        return userService.findByEmailOrPhone(email, phone);
    }

    // Example: Find users by name starting with a specific prefix
    @GetMapping("/findByNameStartingWith")
    public List<User> findByNameStartingWith(@RequestParam String prefix) {
        return userService.findByNameStartingWith(prefix);
    }

    // Example: Find users by name ending with a specific suffix
    @GetMapping("/findByNameEndingWith")
    public List<User> findByNameEndingWith(@RequestParam String suffix) {
        return userService.findByNameEndingWith(suffix);
    }

    // Example: Find users by name and order by surname in ascending order
    @GetMapping("/findByNameOrderBySurnameAsc")
    public List<User> findByNameOrderBySurnameAsc(@RequestParam String name) {
        return userService.findByNameOrderBySurnameAsc(name);
    }

    // Example: Check if a user with a specific email exists
    @GetMapping("/existsByEmail")
    public boolean existsByEmail(@RequestParam String email) {
        return userService.existsByEmail(email);
    }

    @GetMapping("/findBySurnameContainingIgnoreCase")
    public Page<User> findBySurnameContainingIgnoreCase(@RequestParam String partialSurname, Pageable pageable) {
        return userService.findBySurnameContainingIgnoreCase(partialSurname, pageable);
    }
    // Example: Find the first 2 users whose names start with the specified prefix and order by surname
    @GetMapping("/findFirst2ByNameStartsWithOrderBySurname")
    public List<User> findFirst5ByNameStartsWithOrderBySurname(@RequestParam String firstNameStartsWith) {
        return userService.findFirst2ByNameStartsWithOrderBySurname(firstNameStartsWith);
    }
    // Example: Find users by a custom condition
    @GetMapping("/findUsersByCustomCondition")
    public List<User> findUsersByCustomCondition(@RequestParam String customName) {
        return userService.findUsersByCustomCondition(customName);
    }
}
