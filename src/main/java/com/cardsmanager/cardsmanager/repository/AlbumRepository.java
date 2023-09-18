package com.cardsmanager.cardsmanager.repository;

import com.cardsmanager.cardsmanager.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    // Basic CRUD Operations.
}
