package io.github.bruno.mscards.dto;

import io.github.bruno.mscards.entities.CardEntity;
import io.github.bruno.mscards.enums.CardFlag;

import java.math.BigDecimal;

public class CardDto {
    private String name;
    private CardFlag cardFlag;
    private BigDecimal basicLimit;

    public CardDto() {
    }

    public CardDto(String name, CardFlag cardFlag, BigDecimal basicLimit) {
        this.name = name;
        this.cardFlag = cardFlag;
        this.basicLimit = basicLimit;
    }

    public String getName() {
        return name;
    }

    public CardFlag getCardFlag() {
        return cardFlag;
    }

    public BigDecimal getBasicLimit() {
        return basicLimit;
    }

    public static CardDto toMapper(CardEntity cardEntity) {
        return new CardDto(cardEntity.getName(), cardEntity.getCardFlag(), cardEntity.getBasicLimit());
    }
}
