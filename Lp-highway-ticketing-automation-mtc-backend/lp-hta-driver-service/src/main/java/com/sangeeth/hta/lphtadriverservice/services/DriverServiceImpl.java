package com.sangeeth.hta.lphtadriverservice.services;

import com.sangeeth.hta.commons.models.driver.Driver;
import com.sangeeth.hta.lphtadriverservice.repository.DriverServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-driver-service
 */
@Service
public class DriverServiceImpl implements DriverServices{

    @Autowired
    private DriverServiceRepository driverServiceRepository;

    @Override
    public Driver addNewDriver(Driver driver) {
        return driverServiceRepository.save(driver);
    }
}
