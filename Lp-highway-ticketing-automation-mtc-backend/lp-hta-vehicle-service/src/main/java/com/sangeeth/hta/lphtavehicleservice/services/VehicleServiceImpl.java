package com.sangeeth.hta.lphtavehicleservice.services;

import com.sangeeth.hta.commons.models.vehicle.Car;
import com.sangeeth.hta.commons.models.vehicle.Vehicle;
import com.sangeeth.hta.lphtavehicleservice.factory.VehicleFactory;
import com.sangeeth.hta.lphtavehicleservice.repository.VehicleServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-vehicle-service
 */
@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleServiceRepository vehicleServiceRepository;

    @Override
    public Vehicle saveVehicle( Vehicle vehicle) throws JpaSystemException {
        return vehicleServiceRepository.save(vehicle);
    }
}
