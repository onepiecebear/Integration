package com.ebupt.dto.ebupt.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Author: yushibo
 * @Date: 2019/5/22 14:56
 * @Description:
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="SOAP-ENV:Body")
public class ResponseBody implements Serializable{

    @XmlElement(name = "opns:getBusinessGroupResponse")
    private GetBusinessGroupResponse getBusinessGroupResponse;

    public GetBusinessGroupResponse getGetBusinessGroupResponse() {
        return getBusinessGroupResponse;
    }

    public void setGetBusinessGroupResponse(GetBusinessGroupResponse getBusinessGroupResponse) {
        this.getBusinessGroupResponse = getBusinessGroupResponse;
    }
}
