package io.github.bruno.cardreview.controllers;

import io.github.bruno.cardreview.dto.CardApprovedDto;
import io.github.bruno.cardreview.entities.CustomerSituation;
import io.github.bruno.cardreview.dto.EvaluationDataDto;
import io.github.bruno.cardreview.services.ReviewClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card-review")
public class CardReviewController {

    @Autowired
    ReviewClientService reviewClientService;

    @GetMapping("/status")
    public String messageStatus() {
        return "Server is running...";
    }

    @GetMapping("/customer-situation/{cpf}")
    public ResponseEntity<Optional<CustomerSituation>> consultStatusByClient(@PathVariable String cpf) {
        Optional<CustomerSituation> customerStatus = Optional.ofNullable(reviewClientService.getCustomerStatus(cpf));
        return ResponseEntity.ok().body(customerStatus);
    }

    @PostMapping
    public List<CardApprovedDto> accountEvaluation(@RequestBody EvaluationDataDto dataEvaluation) {
        List<CardApprovedDto> cardApprovedDto = reviewClientService.dataReview(dataEvaluation);
        return ResponseEntity.ok().body(cardApprovedDto).getBody();
    }
}
