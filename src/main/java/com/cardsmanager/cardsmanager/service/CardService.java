package com.cardsmanager.cardsmanager.service;

import com.cardsmanager.cardsmanager.entity.Card;
import com.cardsmanager.cardsmanager.repository.CardRepository;
import com.cardsmanager.cardsmanager.service.exception.CardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card getCardById(Long id){
        return cardRepository.getById(id);
    }

    // Example method to get all cards from the database
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Example method to save a new card
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }


    // Update card by ID
    public Card updateCard(Long id, Card updatedCardData) throws CardNotFoundException {
        // Find the card by ID
        Optional<Card> optionalCard = cardRepository.findById(id);

        if (optionalCard.isPresent()) {
            Card existingCard = optionalCard.get();

            // Update the card's properties with the new data
            existingCard.setCardName(updatedCardData.getCardName());
            existingCard.setCardDescription(updatedCardData.getCardDescription());

            // Save the updated card
            return cardRepository.save(existingCard);
        } else {
            // Handle the case where the card with the given ID is not found
            throw new CardNotFoundException("Card with ID " + id + " not found.");
        }
    }

    // Delete Card by ID
    // Delete card by ID
    public void deleteCard(Long id) throws CardNotFoundException {
        // Find the card by ID
        Optional<Card> optionalCard = cardRepository.findById(id);

        if (optionalCard.isPresent()) {
            // If the card exists, delete it
            cardRepository.deleteById(id);
        } else {
            // Handle the case where the card with the given ID is not found
            throw new CardNotFoundException("Card with ID " + id + " not found.");
        }
    }
}
