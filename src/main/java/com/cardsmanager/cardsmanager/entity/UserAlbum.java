package com.cardsmanager.cardsmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserAlbums")
public class UserAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_album_id")
    private Long userAlbumId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    // Constructors

    public UserAlbum() {
    }

    public UserAlbum(Long userAlbumId, User user, Album album) {
        this.userAlbumId = userAlbumId;
        this.user = user;
        this.album = album;
    }

    // Getter Setter

    public Long getUserAlbumId() {
        return userAlbumId;
    }

    public void setUserAlbumId(Long userAlbumId) {
        this.userAlbumId = userAlbumId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
