package com.cardsmanager.cardsmanager.repository;

import com.cardsmanager.cardsmanager.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    // Basic CRUD operations.
}
