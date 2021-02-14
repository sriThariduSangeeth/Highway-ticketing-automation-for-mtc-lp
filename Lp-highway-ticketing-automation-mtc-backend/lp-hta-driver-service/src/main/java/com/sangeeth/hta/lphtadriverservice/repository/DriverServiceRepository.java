package com.sangeeth.hta.lphtadriverservice.repository;

import com.sangeeth.hta.commons.models.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dtsangeeth
 * @created 06 / 02 / 2021
 * @project lp-hta-driver-service
 */
public interface DriverServiceRepository extends JpaRepository<Driver,Integer> {

}
