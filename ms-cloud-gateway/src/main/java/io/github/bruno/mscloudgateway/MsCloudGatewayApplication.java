package io.github.bruno.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient

public class MsCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCloudGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator router(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/clients/**").uri("lb://microservice-clients"))
                .route(r -> r.path("/cards/**").uri("lb://microservice-cards"))
                .route(r -> r.path("/card-review/**").uri("lb://microservice-card-review"))
                .build();
    }
}
