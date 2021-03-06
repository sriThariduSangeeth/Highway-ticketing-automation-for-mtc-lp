package com.sangeeth.hta.commons.models.driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * @author dtsangeeth
 * @created 04 / 03 / 2021
 * @project lp-hta-cloud-common-models
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverReqest {

    private String driverName;
    private String driverNIC;
    private String driverEmail;
    private String driverAddress;
    private String driverBloodGroup;
    private String driverGender;
    private String driverLicenceId;
    private String password;
}
