package com.cardsmanager.cardsmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "AlbumCards")
public class AlbumCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_card_id")
    private Long albumCardId;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    // Constructors

    public AlbumCard() {
    }

    public AlbumCard(Long albumCardId, Album album, Card card) {
        this.albumCardId = albumCardId;
        this.album = album;
        this.card = card;
    }

    // Getters Setters

    public Long getAlbumCardId() {
        return albumCardId;
    }

    public void setAlbumCardId(Long albumCardId) {
        this.albumCardId = albumCardId;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
