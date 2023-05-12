package io.github.bruno.mscards.repositories;

import io.github.bruno.mscards.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity, Integer> {
    List<CardEntity> findByIncomeLessThanEqual(BigDecimal income);
}
