package com.sangeeth.hta.lphtavehicleservice.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sangeeth.hta.commons.models.vehicle.Vehicle;
import com.sangeeth.hta.lphtavehicleservice.factory.VehicleFactory;
import com.sangeeth.hta.lphtavehicleservice.services.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-vehicle-service
 */
@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehicleServiceController {


    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/{type}")
    public ResponseEntity<String> saveVehicle(@PathVariable("type") String type ,@RequestBody String vehicle){

        Vehicle req = VehicleFactory.getVehicle(type , vehicle);
        if (req != null) {
            try {
                Vehicle veh = vehicleService.saveVehicle(req);
                if (veh == null){
                    return ResponseEntity.
                            status(HttpStatus.UNAUTHORIZED)
                            .body("Inactive Vehicle id : "+veh.getVehicleId()+". JPA db error " );
                }else {
                    return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(veh));
                }
            }catch (JpaSystemException exceptio){
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid Vehicle id : "+req.getVehicleId()+". JPA db error " );
            }
        }else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Vehicle Object or Vehicle Type !" );
        }

    }
}
