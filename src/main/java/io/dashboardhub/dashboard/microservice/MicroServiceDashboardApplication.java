package io.dashboardhub.dashboard.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroServiceDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceDashboardApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() throws Exception {
        return new RestTemplate();
    }
}
