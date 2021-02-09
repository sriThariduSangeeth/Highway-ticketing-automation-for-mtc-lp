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
@DiscriminatorValue("Truck")
public class Truck extends Vehicle {

    private int wheelCount;
    private String engineCap;
    private int cargoVolume;
    private String economicalType;

    public Truck(String vehicleId, String vehicleBrand , String vehicleColor,
                 String vehicleCategory, int manifestYear, int wheelCount, String engineCap, int cargoVolume, String economicalType) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.vehicleCategory = vehicleCategory;
        this.vehicleColor = vehicleColor;
        this.manifestYear = manifestYear;
        this.wheelCount = wheelCount;
        this.engineCap = engineCap;
        this.cargoVolume = cargoVolume;
        this.economicalType = economicalType;
    }
    public Truck(){}
}
