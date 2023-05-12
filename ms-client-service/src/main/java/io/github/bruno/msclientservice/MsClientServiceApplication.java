package io.github.bruno.msclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClientServiceApplication.class, args);
	}

}
