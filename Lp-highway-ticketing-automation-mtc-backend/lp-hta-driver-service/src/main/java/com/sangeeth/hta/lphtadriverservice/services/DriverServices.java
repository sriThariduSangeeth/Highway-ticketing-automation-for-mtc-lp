package com.sangeeth.hta.lphtadriverservice.services;

import com.sangeeth.hta.commons.models.driver.Driver;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-driver-service
 */
@Service
public interface DriverServices {

    Driver addNewDriver(Driver driver);
}
