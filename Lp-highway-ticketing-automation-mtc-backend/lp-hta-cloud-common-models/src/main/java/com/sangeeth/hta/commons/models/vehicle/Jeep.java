package com.sangeeth.hta.commons.models.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author dtsangeeth
 * @created 09 / 02 / 2021
 * @project lp-hta-cloud-common-models
 */
@Entity
@PrimaryKeyJoinColumn(name = "vehicleId")
@DiscriminatorValue("Jeep")
public class Jeep extends Vehicle {

    private int numbreOfDoor;
    private String engineCap;
    private String economicalType;
    private int pasengerVolume;

    public Jeep(String vehicleId, String vehicleBrand ,  String vehicleColor,
                String vehicleCategory, int manifestYear, int numbreOfDoor, String engineCap, String economicalType, int pasengerVolume) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.vehicleCategory = vehicleCategory;
        this.vehicleColor = vehicleColor;
        this.manifestYear = manifestYear;
        this.numbreOfDoor = numbreOfDoor;
        this.engineCap = engineCap;
        this.economicalType = economicalType;
        this.pasengerVolume = pasengerVolume;
    }
    public Jeep(){}
}
