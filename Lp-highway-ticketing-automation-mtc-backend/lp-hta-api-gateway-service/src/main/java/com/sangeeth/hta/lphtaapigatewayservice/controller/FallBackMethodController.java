package com.sangeeth.hta.lphtaapigatewayservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dtsangeeth
 * @created 09 / 01 / 2021
 * @project lp-spring-cloud-api-gateway
 */
@RestController
public class FallBackMethodController {

    @RequestMapping("/vehicleserviceFallBack")
    public String projectServiceFallBack(){
        return "Project Service is taking longer than Expected." +
                " Please try again later";
    }

//    @RequestMapping("/taskServiceFallBack")
//    public String taskServiceFallBack(){
//        return "Task Service is taking longer than Expected." +
//                " Please try again later";
//    }
}
