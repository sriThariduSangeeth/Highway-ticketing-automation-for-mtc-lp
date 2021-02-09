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
@DiscriminatorValue("Lorry")
public class Lorry extends Vehicle {

    private int numbreOfDoor;
    private int wheelCount;
    private String engineCap;
    private int cargoVolume;
    private String economicalType;

    public Lorry(String vehicleId, String vehicleBrand ,  String vehicleColor,
                 String vehicleCategory, int manifestYear,int numbreOfDoor, int wheelCount, String engineCap, int cargoVolume, String economicalType) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.vehicleCategory = vehicleCategory;
        this.vehicleColor = vehicleColor;
        this.manifestYear = manifestYear;
        this.numbreOfDoor = numbreOfDoor;
        this.wheelCount = wheelCount;
        this.engineCap = engineCap;
        this.cargoVolume = cargoVolume;
        this.economicalType = economicalType;
    }
    public Lorry(){}
}
