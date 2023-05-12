package io.github.bruno.cardreview.services;

import io.github.bruno.cardreview.entities.CustomerSituation;
import io.github.bruno.cardreview.feign.ConsumersFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewClientService {
    @Autowired
    private ConsumersFeign consumersFeign;

    public CustomerSituation getCustomerStatus(String cpf) {
        return new CustomerSituation(consumersFeign.consumerClient(cpf), consumersFeign.consumerCards(cpf));

    }

}
