package com.sangeeth.hta.lphtaapigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class LpHtaApiGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpHtaApiGatewayServiceApplication.class, args);
    }

}
