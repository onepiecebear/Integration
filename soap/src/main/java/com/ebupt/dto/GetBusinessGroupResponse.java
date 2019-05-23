package com.ebupt.dto;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @Author: yushibo
 * @Date: 2019/5/22 14:39
 * @Description:
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opns:getBusinessGroupResponse")
public class GetBusinessGroupResponse implements Serializable {

    @XmlAttribute(name="xmlns:opns")
    protected String opns ="GenericBrokerBMP";

    @XmlElement(name ="out_parameters")
    protected OutParameters outParameters;


    public String getOpns() {
        return opns;
    }

    public void setOpns(String opns) {
        this.opns= opns;
    }

    public OutParameters getOutParameters() {
        return outParameters;
    }

    public void setOutParameters(OutParameters outParameters) {
        this.outParameters = outParameters;
    }
}
