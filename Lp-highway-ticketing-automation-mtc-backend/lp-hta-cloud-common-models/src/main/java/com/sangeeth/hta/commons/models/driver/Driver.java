package com.sangeeth.hta.commons.models.driver;

import lombok.AllArgsConstructor;

import javax.persistence.*;

/**
 * @author dtsangeeth
 * @created 29 / 01 / 2021
 * @project lp-hta-cloud-common-models
 */
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String driverName;
    private String driverNIC;
    private String driverEmail;
    private String driverAddress;
    private String driverBloodGroup;
    private String driverGender;
    private String driverLicenceId;
    private String password;
    private String imgName;
    private String imgType;
    @Column(name = "imgByte", length = 1000)
    private byte[] imgByte;


    public Driver(){
        super();
    }

    public Driver(String driverName, String driverNIC, String driverEmail, String driverAddress, String driverBloodGroup, String driverGender, String driverLicenceId, String password, String imgName, String imgType, byte[] imgByte) {

        this.driverName = driverName;
        this.driverNIC = driverNIC;
        this.driverEmail = driverEmail;
        this.driverAddress = driverAddress;
        this.driverBloodGroup = driverBloodGroup;
        this.driverGender = driverGender;
        this.driverLicenceId = driverLicenceId;
        this.password = password;
        this.imgName = imgName;
        this.imgType = imgType;
        this.imgByte = imgByte;
    }

    public Driver(int id, String driverName, String driverNIC, String driverEmail, String driverAddress, String driverBloodGroup, String driverGender, String driverLicenceId, String password, String imgName, String imgType, byte[] imgByte) {
        this.id = id;
        this.driverName = driverName;
        this.driverNIC = driverNIC;
        this.driverEmail = driverEmail;
        this.driverAddress = driverAddress;
        this.driverBloodGroup = driverBloodGroup;
        this.driverGender = driverGender;
        this.driverLicenceId = driverLicenceId;
        this.password = password;
        this.imgName = imgName;
        this.imgType = imgType;
        this.imgByte = imgByte;
    }

    public String getDriverEmail() {
        return driverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverNIC() {
        return driverNIC;
    }

    public void setDriverNIC(String driverNIC) {
        this.driverNIC = driverNIC;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverBloodGroup() {
        return driverBloodGroup;
    }

    public void setDriverBloodGroup(String driverBloodGroup) {
        this.driverBloodGroup = driverBloodGroup;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public String getDriverLicenceId() {
        return driverLicenceId;
    }

    public void setDriverLicenceId(String driverLicenceId) {
        this.driverLicenceId = driverLicenceId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
