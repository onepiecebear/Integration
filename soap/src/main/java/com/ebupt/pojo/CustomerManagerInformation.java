package com.ebupt.pojo;


/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:40
 * @Description:
 */
public class CustomerManagerInformation {

    private String familyName;
    private String givenName;
    private String businessPhoneNumber;
    private String mobilePhoneNumber;
    private String email;
    private String faxNumber;
    private String Address;
    private String postalCode;

    @Override
    public String toString() {
        return "CustomerManagerInformation{" +
                "familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", businessPhoneNumber='" + businessPhoneNumber + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
