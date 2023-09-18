package com.cardsmanager.cardsmanager.service;

import com.cardsmanager.cardsmanager.entity.Album;
import com.cardsmanager.cardsmanager.repository.AlbumRepository;
import com.cardsmanager.cardsmanager.service.exception.AlbumNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    // Example method to get all albums from the database
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    // Example method to save a new album
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    // Get album by ID
    public Album getAlbumById(Long albumId) throws AlbumNotFoundException {
        // Find the album by ID
        Optional<Album> optionalAlbum = albumRepository.findById(albumId);

        if (optionalAlbum.isPresent()) {
            // If the album exists, return it
            return optionalAlbum.get();
        } else {
            // Handle the case where the album with the given ID is not found
            throw new AlbumNotFoundException("Album with ID " + albumId + " not found.");
        }
    }

    // Update album by ID
    public Album updateAlbum(Long albumId, Album updatedAlbumData) throws AlbumNotFoundException {
        // Find the album by ID
        Optional<Album> optionalAlbum = albumRepository.findById(albumId);

        if (optionalAlbum.isPresent()) {
            // If the album exists, update its properties with the new data
            Album existingAlbum = optionalAlbum.get();
            existingAlbum.setAlbumName(updatedAlbumData.getAlbumName());
            existingAlbum.setAlbumDescription(updatedAlbumData.getAlbumDescription());
            // Update other properties as needed

            // Save the updated album
            return albumRepository.save(existingAlbum);
        } else {
            // Handle the case where the album with the given ID is not found
            throw new AlbumNotFoundException("Album with ID " + albumId + " not found.");
        }
    }
    // Delete album by ID
    public void deleteAlbum(Long albumId) throws AlbumNotFoundException {
        // Find the album by ID
        Optional<Album> optionalAlbum = albumRepository.findById(albumId);

        if (optionalAlbum.isPresent()) {
            // If the album exists, delete it
            albumRepository.deleteById(albumId);
        } else {
            // Handle the case where the album with the given ID is not found
            throw new AlbumNotFoundException("Album with ID " + albumId + " not found.");
        }
    }

    // Add other methods as needed for your application
}
