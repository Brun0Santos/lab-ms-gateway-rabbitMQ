package io.github.bruno.mscards.controllers;

import io.github.bruno.mscards.dto.CardClientDto;
import io.github.bruno.mscards.dto.CardDto;
import io.github.bruno.mscards.entities.CardClientEntity;
import io.github.bruno.mscards.entities.CardEntity;
import io.github.bruno.mscards.services.CardClientService;
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

    @Autowired
    private CardClientService clientService;

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
    public Optional<List<CardDto>> listCards(@PathVariable("income") Integer income) {
        return cardService.listCardsByIncome(income);
    }

    @GetMapping(params = "cpf")
    private ResponseEntity<Optional<List<CardClientDto>>> cardsByClient(@RequestParam("cpf") String cpf) {
        Optional<List<CardClientDto>> cardsClient = clientService.cardsByClient(cpf);
        return ResponseEntity.ok().body(cardsClient);
    }
}
