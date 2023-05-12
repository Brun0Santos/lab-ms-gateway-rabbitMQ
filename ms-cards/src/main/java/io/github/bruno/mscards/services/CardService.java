package io.github.bruno.mscards.services;

import io.github.bruno.mscards.dto.CardDto;
import io.github.bruno.mscards.entities.CardEntity;
import io.github.bruno.mscards.repositories.CardRepository;
import jakarta.transaction.Transactional;
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

    public Optional<List<CardDto>> listCardsByIncome(Integer income) {
        Optional<List<CardEntity>> listCards = Optional.of(cardRepository.findAll());
        Optional<List<CardEntity>> cardsToLessThanEqual = Optional.of(listCards.get().stream()
                .filter(card -> card.getIncome().compareTo(BigDecimal.valueOf(income)) <= 0).toList());
        return Optional.of(cardsToLessThanEqual.get().stream().map(CardDto::toMapper).toList());
    }
}
