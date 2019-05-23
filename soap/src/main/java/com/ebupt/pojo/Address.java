package com.ebupt.pojo;


import java.io.Serializable;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:26
 * @Description:
 */
public class Address implements Serializable{

    private String businessPhoneNumber;
    private String city;
    private String SERVAREANO;
    private String comment;
    private String country;
    private String department;
    private String email;
    private String familyName;
    private String faxNumber;
    private String givenName;
    private String homePhoneNumber;
    private String location;
    private String mobilePhoneNumber;
    private String namePrefix;
    private String postalCode;
    private String roomNumber;
    private String street;
    private String url;

    @Override
    public String toString() {
        return "Address{" +
                "businessPhoneNumber='" + businessPhoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", SERVAREANO='" + SERVAREANO + '\'' +
                ", comment='" + comment + '\'' +
                ", country='" + country + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", familyName='" + familyName + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", givenName='" + givenName + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", location='" + location + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", namePrefix='" + namePrefix + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", street='" + street + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSERVAREANO() {
        return SERVAREANO;
    }

    public void setSERVAREANO(String SERVAREANO) {
        this.SERVAREANO = SERVAREANO;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
