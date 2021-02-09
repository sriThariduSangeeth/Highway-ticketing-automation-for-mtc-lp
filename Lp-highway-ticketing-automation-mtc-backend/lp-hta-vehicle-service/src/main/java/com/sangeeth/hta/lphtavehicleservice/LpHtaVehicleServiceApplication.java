package com.sangeeth.hta.lphtavehicleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan(basePackages = "com.sangeeth.hta.commons.models.vehicle")
public class LpHtaVehicleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpHtaVehicleServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
