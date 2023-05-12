package io.github.bruno.cardreview.feign;

import io.github.bruno.cardreview.configs.CardsConsumerFeign;
import io.github.bruno.cardreview.configs.ClientConsumerFeign;
import io.github.bruno.cardreview.entities.client.ClientCardEntity;
import io.github.bruno.cardreview.entities.client.ClientDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConsumersFeign {
    @Autowired
    private ClientConsumerFeign clientConsumerFeign;

    @Autowired
    private CardsConsumerFeign cardsConsumerFeign;

    public ClientDataEntity consumerClient(String cpf) {
        return clientConsumerFeign.dataClientFeign(cpf).getBody();
    }

    public List<ClientCardEntity> consumerCards(String cpf) {
        return cardsConsumerFeign.dataCardClientFeign(cpf);
    }
}
