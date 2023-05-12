package io.github.bruno.msclientservice.services;

import io.github.bruno.msclientservice.entities.ClientEntity;
import io.github.bruno.msclientservice.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void saveUser(ClientEntity user) {
        clientRepository.save(user);
    }

    public Optional<ClientEntity> getByClient(String cpf) {
        Optional<ClientEntity> byClient = clientRepository.findByCpf(cpf);
        return Optional.of(byClient.orElseThrow());
    }
}
