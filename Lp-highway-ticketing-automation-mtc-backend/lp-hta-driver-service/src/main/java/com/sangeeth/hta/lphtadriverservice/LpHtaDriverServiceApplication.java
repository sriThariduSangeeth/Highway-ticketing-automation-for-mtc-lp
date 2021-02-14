package com.sangeeth.hta.lphtadriverservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = "com.sangeeth.hta.commons.models.driver")
public class LpHtaDriverServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpHtaDriverServiceApplication.class, args);
    }

}
