package io.github.bruno.cardreview.dto;

import java.math.BigDecimal;

public class CardDto {
    private Integer id;
    private String name;
    private String cardFlag;
    private BigDecimal basicLimit;

    public CardDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCardFlag() {
        return cardFlag;
    }

    public BigDecimal getBasicLimit() {
        return basicLimit;
    }

}
