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
@DiscriminatorValue("Bus")
public class Bus extends Vehicle {

    private int pasengerVolume;
    private String rootNumber;
    private int wheelCount;
    private String busType;
    private String economicalType;

    public Bus(String vehicleId, String vehicleBrand ,  String vehicleColor,
               String vehicleCategory, int manifestYear , int pasengerVolume, String rootNumber ,
               int wheelCount , String busType, String economicalType){
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.vehicleCategory = vehicleCategory;
        this.vehicleColor = vehicleColor;
        this.manifestYear = manifestYear;
        this.pasengerVolume = pasengerVolume;
        this.rootNumber = rootNumber;
        this.wheelCount = wheelCount;
        this.busType = busType;
        this.economicalType = economicalType;
    }

    public Bus() {

    }


}
