package com.ebupt.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:55
 * @Description:
 */
public class ServiceQuotaList {
    private List<ServiceQuotaItem> ServiceQuota;

    @Override
    public String toString() {
        return "ServiceQuotaList{" +
                "ServiceQuota=" + ServiceQuota +
                '}';
    }
    @XmlElement(name = "ServiceQuota")
    public List<ServiceQuotaItem> getServiceQuota() {
        return ServiceQuota;
    }

    public void setServiceQuota(List<ServiceQuotaItem> serviceQuota) {
        ServiceQuota = serviceQuota;
    }
}
