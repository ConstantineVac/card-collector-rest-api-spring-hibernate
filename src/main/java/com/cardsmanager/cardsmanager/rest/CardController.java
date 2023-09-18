package com.cardsmanager.cardsmanager.rest;

import com.cardsmanager.cardsmanager.entity.Card;
import com.cardsmanager.cardsmanager.service.CardService;
import com.cardsmanager.cardsmanager.service.exception.CardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    //@Autowired
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // Endpoint to retrieve all cards
    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    // Endpoint to retrieve a card by ID
    @GetMapping("/{cardId}")
    public Card getCardById(@PathVariable Long cardId) {
        return cardService.getCardById(cardId);
    }

    // Endpoint to create a new card
    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    // Endpoint to update an existing card
    @PutMapping("/{cardId}")
    public Card updateCard(@PathVariable Long cardId, @RequestBody Card card) throws CardNotFoundException {
        return cardService.updateCard(cardId, card);
    }

    // Endpoint to delete a card by ID
    @DeleteMapping("/{cardId}")
    public void deleteCard(@PathVariable Long cardId) throws CardNotFoundException {
        cardService.deleteCard(cardId);
    }
}
