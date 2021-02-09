package com.sangeeth.hta.lphtavehicleservice.services;

import com.sangeeth.hta.commons.models.vehicle.Vehicle;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-vehicle-service
 */
@Service
public interface VehicleService {

    Vehicle saveVehicle( Vehicle vehicle) throws JpaSystemException;
}
