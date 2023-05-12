package io.github.bruno.mscards.services;

import io.github.bruno.mscards.entities.CardEntity;
import io.github.bruno.mscards.repositories.CardRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public void saveCard(CardEntity card) {
        cardRepository.save(card);
    }

    public Optional<List<CardEntity>> listCardsByIncome(Integer income) {
        Optional<List<CardEntity>> cardsToLessThanEqual = Optional.of(cardRepository.findAll());
        return Optional.of(cardsToLessThanEqual.get().stream()
                .filter(card -> card.getIncome().compareTo(BigDecimal.valueOf(income)) <= 0).toList());
    }
}
