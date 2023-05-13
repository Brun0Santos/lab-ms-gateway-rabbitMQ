package io.github.bruno.cardreview.services;

import feign.FeignException;
import io.github.bruno.cardreview.util.CalcUtil;
import io.github.bruno.cardreview.dto.CardApprovedDto;
import io.github.bruno.cardreview.dto.CardDto;
import io.github.bruno.cardreview.dto.EvaluationDataDto;
import io.github.bruno.cardreview.entities.CustomerSituation;
import io.github.bruno.cardreview.entities.client.ClientCardEntity;
import io.github.bruno.cardreview.exceptions.UnexpectedException;
import io.github.bruno.cardreview.exceptions.UserNotFoundException;
import io.github.bruno.cardreview.feign.ConsumersFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<CardApprovedDto> dataReview(EvaluationDataDto data) {
        List<ClientCardEntity> clientCards = consumersFeign.consumerCards(data.getCpf());
        List<CardDto> dataCards = consumersFeign.consumerDataCards(data.getIncome());
        return dataCards.stream().map(cards -> {
            return new CardApprovedDto(cards.getName(), cards.getCardFlag(), CalcUtil.incomeCalculation(cards.getBasicLimit()));
        }).toList();
    }
}

