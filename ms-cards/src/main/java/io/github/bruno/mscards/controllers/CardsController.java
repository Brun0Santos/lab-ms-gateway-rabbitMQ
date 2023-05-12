package io.github.bruno.mscards.controllers;

import io.github.bruno.mscards.entities.CardEntity;
import io.github.bruno.mscards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public String messageStatus() {
        return "Service is running...";
    }

    @PostMapping
    public ResponseEntity<CardEntity> saveCard(@RequestBody CardEntity card) {
        cardService.saveCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @GetMapping("/{income}")
    public Optional<List<CardEntity>> listCards(@PathVariable("income") Integer income) {
        return cardService.listCardsByIncome(income);
    }
}
