package com.cardsmanager.cardsmanager.repository;

import com.cardsmanager.cardsmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Provides basic CRUD operations.
}

