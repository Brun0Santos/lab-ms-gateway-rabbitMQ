package io.github.bruno.mscards.repositories;

import io.github.bruno.mscards.entities.CardClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardClientRepository extends JpaRepository<CardClientEntity, Integer> {
    List<CardClientEntity> findByCpf(String cpf);
}
