package io.github.bruno.cardreview.dto;

import java.math.BigDecimal;

public class CardApprovedDto {
    private String card;
    private String flag;
    private BigDecimal approvedLimit;

    public CardApprovedDto() {
    }

    public CardApprovedDto(String card, String flag, BigDecimal approvedLimit) {
        this.card = card;
        this.flag = flag;
        this.approvedLimit = approvedLimit;
    }

    public String getCard() {
        return card;
    }

    public String getFlag() {
        return flag;
    }

    public BigDecimal getApprovedLimit() {
        return approvedLimit;
    }

}
