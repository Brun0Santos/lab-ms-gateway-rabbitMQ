package io.github.bruno.mscards.services;

import io.github.bruno.mscards.dto.CardClientDto;
import io.github.bruno.mscards.entities.CardClientEntity;
import io.github.bruno.mscards.repositories.CardClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardClientService {
    @Autowired
    CardClientRepository cardClientRepository;

    public Optional<List<CardClientDto>> cardsByClient(String cpf) {
        Optional<List<CardClientEntity>> cardByCpf = Optional.of(cardClientRepository.findByCpf(cpf));
        return Optional.of(cardByCpf.get().stream().map(CardClientDto::toMapper).toList());

    }
}
