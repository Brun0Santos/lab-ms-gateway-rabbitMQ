package io.github.bruno.cardreview.controllers;

import io.github.bruno.cardreview.entities.CustomerSituation;
import io.github.bruno.cardreview.services.ReviewClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
