package com.cardsmanager.cardsmanager.entity;

import javax.persistence.*;


@Entity
@Table(name = "Cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "card_name", nullable = false)
    private String cardName;

    @Column(name = "card_description")
    private String cardDescription;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Card() {
    }

    // Parameterized constructor
    public Card(String cardName, String cardDescription) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    // Getters Setters

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }
}