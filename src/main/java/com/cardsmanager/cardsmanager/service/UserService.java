package com.cardsmanager.cardsmanager.service;

import com.cardsmanager.cardsmanager.entity.User;
import com.cardsmanager.cardsmanager.repository.UserRepository;
import com.cardsmanager.cardsmanager.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Example method to get all users from the database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Example method to save a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get user by ID
    public User getUserById(Long userId) throws UserNotFoundException {
        // Find the user by ID
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            // If the user exists, return it
            return optionalUser.get();
        } else {
            // Handle the case where the user with the given ID is not found
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
    }

    // Update user by ID
    public User updateUser(Long userId, User updatedUserData) throws UserNotFoundException {
        // Find the user by ID
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            // If the user exists, update its properties with the new data
            User existingUser = optionalUser.get();
            existingUser.setUsername(updatedUserData.getUsername());
            existingUser.setEmail(updatedUserData.getEmail());
            // Update other properties as needed

            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            // Handle the case where the user with the given ID is not found
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
    }

    // Delete user by ID
    public void deleteUser(Long userId) throws UserNotFoundException {
        // Find the user by ID
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            // If the user exists, delete it
            userRepository.deleteById(userId);
        } else {
            // Handle the case where the user with the given ID is not found
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
    }

    // Add other methods as needed for your application
}
