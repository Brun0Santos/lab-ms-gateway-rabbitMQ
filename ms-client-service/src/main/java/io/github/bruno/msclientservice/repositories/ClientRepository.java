package io.github.bruno.msclientservice.repositories;

import io.github.bruno.msclientservice.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findByCpf(String cpf);
}
