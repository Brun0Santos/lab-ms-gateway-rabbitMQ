package io.github.bruno.cardreview.entities;

import io.github.bruno.cardreview.entities.client.ClientCardEntity;
import io.github.bruno.cardreview.entities.client.ClientDataEntity;

import java.util.List;

public class CustomerSituation {
    private ClientDataEntity client;
    private List<ClientCardEntity> clientCards;

    public CustomerSituation(){
    }

    public CustomerSituation(ClientDataEntity client, List<ClientCardEntity> clientCards) {
        this.client = client;
        this.clientCards = clientCards;
    }

    public ClientDataEntity getClient() {
        return client;
    }

    public List<ClientCardEntity> getClientCards() {
        return clientCards;
    }
}
