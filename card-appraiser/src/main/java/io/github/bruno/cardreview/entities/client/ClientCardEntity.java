package io.github.bruno.cardreview.entities.client;

import java.math.BigDecimal;

public class ClientCardEntity {

    private String name;

    private String cardFlag;
    private BigDecimal limitReleased;

    public String getName() {
        return name;
    }

    public String getCardFlag() {
        return cardFlag;
    }

    public BigDecimal getLimitReleased() {
        return limitReleased;
    }

    @Override
    public String toString() {
        return "ClientCardEntity{" +
                "name='" + name + '\'' +
                ", cardFlag='" + cardFlag + '\'' +
                ", limitReleased=" + limitReleased +
                '}';
    }
}
