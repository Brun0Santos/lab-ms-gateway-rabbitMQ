package io.github.bruno.cardreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CardReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardReviewApplication.class, args);
	}

}
