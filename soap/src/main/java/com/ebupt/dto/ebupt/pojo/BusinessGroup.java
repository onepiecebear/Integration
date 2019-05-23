package com.ebupt.dto.ebupt.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:50
 * @Description:
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="getBusinessGroupReturn" )
public class BusinessGroup {
    private String rtsName;
    private String BG;
    private String name;
    private String BGLockFLG;
    private Address contactAddress;
    private com.ebupt.dto.ebupt.pojo.CustomerManagerInformation CustomerManagerInformation;
    private ServiceQuotaList serviceQuotaList;
    private List<GroupResourceQuotaEntryItem> groupResourceQuotaEntryList;

    @Override
    public String toString() {
        return "BusinessGroup{" +
                "rtsName='" + rtsName + '\'' +
                ", BG='" + BG + '\'' +
                ", name='" + name + '\'' +
                ", BGLockFLG='" + BGLockFLG + '\'' +
                ", contactAddress=" + contactAddress +
                ", CustomerManagerInformation=" + CustomerManagerInformation +
                ", serviceQuotaList=" + serviceQuotaList +
                ", groupResourceQuotaEntryList=" + groupResourceQuotaEntryList +
                '}';
    }

//    public List<GroupResourceQuotaEntry> getGroupResourceQuotaEntryList() {
//        return groupResourceQuotaEntryList;
//    }
//
//    public void setGroupResourceQuotaEntryList(List<GroupResourceQuotaEntry> groupResourceQuotaEntryList) {
//        this.groupResourceQuotaEntryList = groupResourceQuotaEntryList;
//    }


    public List<GroupResourceQuotaEntryItem> getGroupResourceQuotaEntryList() {
        return groupResourceQuotaEntryList;
    }

    public void setGroupResourceQuotaEntryList(List<GroupResourceQuotaEntryItem> groupResourceQuotaEntryList) {
        this.groupResourceQuotaEntryList = groupResourceQuotaEntryList;
    }

    public String getRtsName() {
        return rtsName;
    }

    public void setRtsName(String rtsName) {
        this.rtsName = rtsName;
    }


    public String getBG() {
        return BG;
    }

    public void setBG(String BG) {
        this.BG = BG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBGLockFLG() {
        return BGLockFLG;
    }

    public void setBGLockFLG(String BGLockFLG) {
        this.BGLockFLG = BGLockFLG;
    }

    public Address getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(Address contactAddress) {
        this.contactAddress = contactAddress;
    }

    public ServiceQuotaList getServiceQuotaList() {
        return serviceQuotaList;
    }

    public void setServiceQuotaList(ServiceQuotaList serviceQuotaList) {
        this.serviceQuotaList = serviceQuotaList;
    }

    public com.ebupt.dto.ebupt.pojo.CustomerManagerInformation getCustomerManagerInformation() {
        return CustomerManagerInformation;
    }

    public void setCustomerManagerInformation(com.ebupt.dto.ebupt.pojo.CustomerManagerInformation customerManagerInformation) {
        CustomerManagerInformation = customerManagerInformation;
    }
}
