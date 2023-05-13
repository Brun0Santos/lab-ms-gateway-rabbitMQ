package io.github.bruno.cardreview.configs;

import io.github.bruno.cardreview.dto.CardDto;
import io.github.bruno.cardreview.entities.client.ClientCardEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Configuration
@FeignClient(value = "microservice-cards", path = "/cards")
public interface CardsConsumerFeign {

    @Bean
    @GetMapping(params = "cpf")
    List<ClientCardEntity> dataCardClientFeign(@RequestParam("cpf") String cpf);

    @GetMapping("/{income}")
    List<CardDto> dataCardFeign(@PathVariable("income") Integer income);
}
