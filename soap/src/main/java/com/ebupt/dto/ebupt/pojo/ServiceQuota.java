package com.ebupt.dto.ebupt.pojo;


import javax.xml.bind.annotation.XmlElement;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:29
 * @Description:
 */
public class ServiceQuota {
//    private ServiceCodeEnum ServiceCode;
    private String ServiceCode;
    private LongValue Quota;

//    @Override
//    public String toString() {
//        return "ServiceQuota{" +
//                "ServiceCode=" + ServiceCode +
//                ", Quota=" + Quota +
//                '}';
//    }

    @Override
    public String toString() {
        return "ServiceQuota{" +
                "ServiceCode='" + ServiceCode + '\'' +
                ", Quota=" + Quota +
                '}';
    }


//    @XmlElement(name = "ServiceCode")
//    public ServiceCodeEnum getServiceCode() {
//        return ServiceCode;
//    }
//
//    public void setServiceCode(ServiceCodeEnum serviceCode) {
//        ServiceCode = serviceCode;
//    }
    @XmlElement(name = "ServiceCode")
    public String getServiceCode() {
        return ServiceCode;
    }

    public void setServiceCode(String serviceCode) {
        ServiceCode = serviceCode;
    }

    @XmlElement(name = "Quota")
    public LongValue getQuota() {
        return Quota;
    }

    public void setQuota(LongValue quota) {
        Quota = quota;
    }
}
