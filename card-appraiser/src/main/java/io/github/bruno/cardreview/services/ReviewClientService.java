package io.github.bruno.cardreview.services;

import feign.FeignException;
import io.github.bruno.cardreview.entities.CustomerSituation;
import io.github.bruno.cardreview.exceptions.UnexpectedException;
import io.github.bruno.cardreview.exceptions.UserNotFoundException;
import io.github.bruno.cardreview.feign.ConsumersFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewClientService {
    @Autowired
    private ConsumersFeign consumersFeign;

    public CustomerSituation getCustomerStatus(String cpf) {
        try {
            return new CustomerSituation(consumersFeign.consumerClient(cpf), consumersFeign.consumerCards(cpf));
        } catch (FeignException.NotFound ex) {
            throw new UserNotFoundException();
        } catch (FeignException.ServiceUnavailable ex) {
            throw new UnexpectedException();
        }
    }
}
