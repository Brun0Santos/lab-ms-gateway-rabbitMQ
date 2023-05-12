package io.github.bruno.mscards.entities;

import io.github.bruno.mscards.enums.CardFlag;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardFlag cardFlag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public CardEntity() {
    }

    public CardEntity(Integer id, String name, CardFlag cardFlag, BigDecimal income, BigDecimal basicLimit) {
        this.id = id;
        this.name = name;
        this.cardFlag = cardFlag;
        this.income = income;
        this.basicLimit = basicLimit;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CardFlag getCardFlag() {
        return cardFlag;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public BigDecimal getBasicLimit() {
        return basicLimit;
    }
}
