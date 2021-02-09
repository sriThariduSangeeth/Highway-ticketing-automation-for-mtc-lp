package com.sangeeth.hta.commons.models.vehicle;

import javax.persistence.*;

/**
 * @author dtsangeeth
 * @created 29 / 01 / 2021
 * @project lp-hta-cloud-common-models
 */
@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vehicleType",
        discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @Column(name = "vehicleId", unique = true, nullable = false)
    public String vehicleId;
    public String vehicleBrand;
    public String vehicleColor;
    public String vehicleCategory;
    public int manifestYear;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public int getManifestYear() {
        return manifestYear;
    }

    public void setManifestYear(int manifestYear) {
        this.manifestYear = manifestYear;
    }
}
