package com.sangeeth.hta.lphtatripservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient@EntityScan(basePackages = "com.sangeeth.hta.commons.models.trip")
public class LpHtaTripServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpHtaTripServiceApplication.class, args);
    }

}
