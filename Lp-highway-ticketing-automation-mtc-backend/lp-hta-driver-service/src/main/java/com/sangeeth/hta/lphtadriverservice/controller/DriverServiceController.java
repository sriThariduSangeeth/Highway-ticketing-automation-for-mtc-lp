package com.sangeeth.hta.lphtadriverservice.controller;

import com.google.api.services.drive.model.File;
import com.sangeeth.hta.commons.models.driver.Driver;
import com.sangeeth.hta.lphtadriverservice.services.DriverServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/upload")
    public String addPhoto(@RequestParam ("profileImg") MultipartFile driverfile , @RequestParam ("driver") String driverpro)throws IOException {

        InputStream inputStream = null;
        if (driverfile == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }

//        try {
//            inputStream = file.getInputStream();
//            String originalName = file.getOriginalFilename();
//            String name = file.getName();
//            String contentType = file.getContentType();
//            long size = file.getSize();
//            log.info("inputStream: " + inputStream);
//            log.info("originalName: " + originalName);
//            log.info("name: " + name);
//            log.info("contentType: " + contentType);
//            log.info("size: " + size);
//            return "ok";
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return null;
    }

    @PostMapping("/")
    public ResponseEntity<String> addNewDriver(@RequestBody Driver driver){
        return null;
    }

    @GetMapping("/{id}")
    public String getDriverUsingId(@PathVariable("id") String id){
        return  null;
    }
}
