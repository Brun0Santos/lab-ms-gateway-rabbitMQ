package io.github.bruno.mscards.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_card_client")
public class CardClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_card")
    private CardEntity card;
    private BigDecimal basicLimit;

    public CardClientEntity() {
    }

    public CardClientEntity(Integer id, String cpf, CardEntity card, BigDecimal basicLimit) {
        this.id = id;
        this.cpf = cpf;
        this.card = card;
        this.basicLimit = basicLimit;
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public CardEntity getCard() {
        return card;
    }

    public BigDecimal getBasicLimit() {
        return basicLimit;
    }
}
