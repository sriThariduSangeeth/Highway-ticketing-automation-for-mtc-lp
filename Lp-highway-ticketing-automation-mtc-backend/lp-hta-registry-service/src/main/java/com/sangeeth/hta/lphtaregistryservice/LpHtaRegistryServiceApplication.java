package com.sangeeth.hta.lphtaregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LpHtaRegistryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpHtaRegistryServiceApplication.class, args);
    }

}
