package com.sangeeth.hta.lphtavehicleservice.repository;

import com.sangeeth.hta.commons.models.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaSystemException;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-vehicle-service
 */
public interface VehicleServiceRepository extends JpaRepository<Vehicle, String> {

    Vehicle save(Vehicle vehicle) throws JpaSystemException;
}
