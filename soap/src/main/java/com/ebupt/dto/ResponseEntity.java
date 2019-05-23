package com.ebupt.dto;

import com.sun.xml.internal.messaging.saaj.soap.Envelope;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.net.ResponseCache;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "body"
    })
@XmlRootElement(name = "SOAP-ENV:Envelope")
public class ResponseEntity implements Serializable{
    @XmlAttribute(name="xmlns:SOAP-ENV")
    private String soapenv="http://schemas.xmlsoap.org/soap/envelope/";
    @XmlAttribute(name="xmlns:xsi")
    private String xsi="http://www.w3.org/2001/XMLSchema-instance";
    
    @XmlAttribute(name="xmlns:xsd")
    private String xsd="http://www.w3.org/2001/XMLSchema";
    
    
    
//    @XmlElement(required = true,name="soapenv:Header")
//    protected RequestHeader header;
    //required = true值为空时，是否展示
    @XmlElement(required = true,name="SOAP-ENV:Body")
    private ResponseBody body;


    public String getSoapenv() {
        return soapenv;
    }

    public void setSoapenv(String soapenv) {
        this.soapenv = soapenv;
    }

    public String getXsi() {
        return xsi;
    }

    public void setXsi(String xsi) {
        this.xsi = xsi;
    }

    public String getXsd() {
        return xsd;
    }

    public void setXsd(String xsd) {
        this.xsd = xsd;
    }

    public ResponseBody getBody() {
        return body;
    }

    public void setBody(ResponseBody body) {
        this.body = body;
    }
}