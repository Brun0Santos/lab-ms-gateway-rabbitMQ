package io.github.bruno.mscards.dto;

import io.github.bruno.mscards.entities.CardClientEntity;

import java.math.BigDecimal;

public class CardClientDto {
    private String nome;
    private String cardFlag;
    private BigDecimal limitReleased;

    public CardClientDto() {
    }

    public CardClientDto(String nome, String cardFlag, BigDecimal limitReleased) {
        this.nome = nome;
        this.cardFlag = cardFlag;
        this.limitReleased = limitReleased;
    }

    public String getNome() {
        return nome;
    }

    public String getCardFlag() {
        return cardFlag;
    }

    public BigDecimal getLimitReleased() {
        return limitReleased;
    }

    public static CardClientDto toMapper(CardClientEntity cardClient) {
        return new CardClientDto(cardClient.getCard().getName(), cardClient.getCard().getCardFlag().toString(),
                cardClient.getBasicLimit());
    }
}
