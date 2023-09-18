package com.cardsmanager.cardsmanager.rest;

import com.cardsmanager.cardsmanager.entity.Album;
import com.cardsmanager.cardsmanager.service.AlbumService;
import com.cardsmanager.cardsmanager.service.exception.AlbumNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // Endpoint to retrieve all albums
    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    // Endpoint to retrieve an album by ID
    @GetMapping("/{albumId}")
    public Album getAlbumById(@PathVariable Long albumId) throws AlbumNotFoundException {
        return albumService.getAlbumById(albumId);
    }

    // Endpoint to create a new album
    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

    // Endpoint to update an existing album
    @PutMapping("/{albumId}")
    public Album updateAlbum(@PathVariable Long albumId, @RequestBody Album album) throws AlbumNotFoundException {
        return albumService.updateAlbum(albumId, album);
    }

    // Endpoint to delete an album by ID
    @DeleteMapping("/{albumId}")
    public void deleteAlbum(@PathVariable Long albumId) throws AlbumNotFoundException {
        albumService.deleteAlbum(albumId);
    }
}
