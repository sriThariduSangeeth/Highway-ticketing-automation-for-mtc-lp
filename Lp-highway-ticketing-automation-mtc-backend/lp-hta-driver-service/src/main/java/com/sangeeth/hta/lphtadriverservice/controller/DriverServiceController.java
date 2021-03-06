package com.sangeeth.hta.lphtadriverservice.controller;

import com.sangeeth.hta.commons.models.driver.Driver;
import com.sangeeth.hta.lphtadriverservice.services.DriverServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-driver-service
 */
@Slf4j
@RestController
@RequestMapping("driver")
@CrossOrigin(origins = "http://localhost:4200")
public class DriverServiceController {

    @Autowired
    private DriverServices driverServices;

    @PostMapping("")
    public ResponseEntity<?> addNewDriver(@RequestBody String driver){
        Driver driver1 = new Driver();
//        return ResponseEntity.status(HttpStatus.OK).body(driverServices.addNewDriver(driver1));
        return ResponseEntity.ok().body("dcsdcv");
    }

    @GetMapping("/{id}")
    public String getDriverUsingId(@PathVariable("id") String id){
        return  null;
    }
}
