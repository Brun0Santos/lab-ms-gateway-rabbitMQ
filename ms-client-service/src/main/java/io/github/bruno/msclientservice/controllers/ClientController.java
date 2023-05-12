package io.github.bruno.msclientservice.controllers;

import io.github.bruno.msclientservice.entities.ClientEntity;
import io.github.bruno.msclientservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/status")
    public String messageStatus() {
        return "Service OK!!!";
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<ClientEntity>> findUser(@PathVariable("cpf") String cpf) {
        Optional<ClientEntity> byClient = clientService.getByClient(cpf);
        return ResponseEntity.ok().body(byClient);
    }

    @PostMapping
    public ResponseEntity<ClientEntity> saveUser(@RequestBody ClientEntity user) {
        clientService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
