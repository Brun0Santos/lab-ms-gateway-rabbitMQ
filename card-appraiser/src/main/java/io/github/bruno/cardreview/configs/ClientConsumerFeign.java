package io.github.bruno.cardreview.configs;

import io.github.bruno.cardreview.entities.client.ClientDataEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@FeignClient(value = "microservice-clients", path = "/clients")
public interface ClientConsumerFeign {

    @Bean
    @GetMapping("/{cpf}")
    ResponseEntity<ClientDataEntity> dataClientFeign(@PathVariable("cpf") String cpf);
}
