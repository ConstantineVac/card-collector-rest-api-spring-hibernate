package com.cardsmanager.cardsmanager.rest;

import com.cardsmanager.cardsmanager.entity.User;
import com.cardsmanager.cardsmanager.service.UserService;
import com.cardsmanager.cardsmanager.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to retrieve a user by ID
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) throws UserNotFoundException {
        return userService.getUserById(userId);
    }

    // Endpoint to create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Endpoint to update an existing user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) throws UserNotFoundException {
        return userService.updateUser(userId, user);
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
    }
}

