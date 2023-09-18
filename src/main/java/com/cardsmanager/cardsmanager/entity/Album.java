package com.cardsmanager.cardsmanager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "album_name", nullable = false)
    private String albumName;

    @Column(name = "album_description")
    private String albumDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "AlbumCards",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Album() {
    }

    // Parameterized constructor
    public Album(String albumName, String albumDescription, User user, List<Card> cards) {
        this.albumName = albumName;
        this.albumDescription = albumDescription;
        this.user = user;
        this.cards = cards;
    }

    // Getters and setters


    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}