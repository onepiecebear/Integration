package com.ebupt.test;

import com.ebupt.dto.GetBusinessGroupResponse;
import com.ebupt.dto.OutParameters;
import com.ebupt.dto.ResponseBody;
import com.ebupt.dto.ResponseEntity;
import com.ebupt.pojo.BusinessGroup;
import com.ebupt.pojo.GroupResourceQuotaEntry;
import com.ebupt.pojo.GroupResourceQuotaEntryItem;
import com.sun.xml.internal.messaging.saaj.soap.Envelope;

import javax.xml.bind.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 23:00
 * @Description:
 */
public class JAXBTest {
    public static void main(String[] args) throws Exception {
//        JAXBContext ctx = JAXBContext.newInstance(BusinessGroup.class);
//        Marshaller marshaller = ctx.createMarshaller();
//        Object businessGroup =  getServiceQuotaList();
//        StringWriter stringWriter = new StringWriter();
//        marshaller.marshal(businessGroup,stringWriter);
//        System.out.println("XML输出:"+stringWriter.toString());

        JAXBContext ctx1 = JAXBContext.newInstance(ResponseEntity.class);
        Marshaller marshaller = ctx1.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息

        BusinessGroup businessGroup =  getBusinessGroup();

        OutParameters outParameters = new OutParameters();
        outParameters.setBusinessGroup(businessGroup);

        GetBusinessGroupResponse getBusinessGroupResponse = new GetBusinessGroupResponse();
        getBusinessGroupResponse.setOutParameters(outParameters);

        ResponseBody responseBody = new ResponseBody();
        responseBody.setGetBusinessGroupResponse(getBusinessGroupResponse);

        ResponseEntity requestEntity = new ResponseEntity();
        requestEntity.setBody(responseBody);


        StringWriter stringWriter1 = new StringWriter();
        marshaller.marshal(requestEntity,stringWriter1);
        System.out.println("XML输出:"+stringWriter1.toString());






        String content = "<getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhiteList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhiteList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>BGUserNum</resourceName><assignedQuota><value>5</value></assignedQuota><usedQuota><value>0</value></usedQuota></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn>";
//        JAXBContext ctx1 = JAXBContext.newInstance(BusinessGroup.class);
//
//        Unmarshaller um = ctx1.createUnmarshaller();
//
//        BusinessGroup sclass = (BusinessGroup) um.unmarshal(new StringReader(content));
//
//        System.out.println(sclass.toString());
//        JAXBContext ctx1 = JAXBContext.newInstance(BusinessGroup.class);
//
//        Unmarshaller um = ctx1.createUnmarshaller();
//
//        BusinessGroup sclass = (BusinessGroup) um.unmarshal(new StringReader(content1));
//
//        System.out.println(sclass.toString());

//        String content = "<getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>BGUserNum</resourceName><assignedQuota><value>5</value></assignedQuota><usedQuota><value>0</value></usedQuota></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn>";
        String content1 = "<getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG></getBusinessGroupReturn>";
            String content2 = "<getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn>";

            String content3 =  "<getBusinessGroupReturn><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhiteList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList></getBusinessGroupReturn>";
//                              <getBusinessGroupReturn><serviceQuotaList><serviceQuota><item><quota><value>123456789</value></quota></item><item><quota><value>38383888</value></quota></item></serviceQuota></serviceQuotaList></getBusinessGroupReturn>
                String content4 =  "<getBusinessGroupReturn><groupResourceQuotaEntryList><item><resourceName>wqeqwe</resourceName></item><item><resourceName>sdasdad</resourceName></item></groupResourceQuotaEntryList></getBusinessGroupReturn>";

        //        BusinessGroup b = JAXB.unmarshal(content1, BusinessGroup.class);
//        System.out.println(b.toString());

        String content5 =  "<getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhiteList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhiteList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>BGUserNum</resourceName><assignedQuota><value>5</value></assignedQuota><usedQuota><value>0</value></usedQuota></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn>";
        //String content6 =  "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><SOAP-ENV:Body><opns:getBusinessGroupResponse xmlns:opns=\"GenericBrokerBMP\"><out_parameters><resultCode>0000</resultCode><resultDesc>操作成功</resultDesc><getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>BGUserNum</resourceName><assignedQuota><value>5</value></assignedQuota><usedQuota><value>0</value></usedQuota></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn></out_parameters></opns:getBusinessGroupResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";


        String zhongji =  "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><SOAP-ENV:Body><opns:getBusinessGroupResponse xmlns:opns=\"GenericBrokerBMP\"><out_parameters><resultCode>0000</resultCode><resultDesc>操作成功</resultDesc><getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>BGUserNum</resourceName><assignedQuota><value>5</value></assignedQuota><usedQuota><value>0</value></usedQuota></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn></out_parameters></opns:getBusinessGroupResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";
//                         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><SOAP-ENV:Body><opns:getBusinessGroupResponse xmlns:opns="GenericBrokerBMP"><out_parameters><getBusinessGroupReturn><groupResourceQuotaEntryList><item><resourceName>wqeqwe</resourceName></item><item><resourceName>sdasdad</resourceName></item></groupResourceQuotaEntryList></getBusinessGroupReturn></out_parameters></opns:getBusinessGroupResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>
//                         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><body><getBusinessGroupResponse xmlns:opns="GenericBrokerBMP"><outParameters><businessGroup><groupResourceQuotaEntryList><item><resourceName>wqeqwe</resourceName></item><item><resourceName>sdasdad</resourceName></item></groupResourceQuotaEntryList></businessGroup></outParameters></getBusinessGroupResponse></body></SOAP-ENV:Envelope>

        JAXBContext ctx2 = JAXBContext.newInstance(ResponseEntity.class);

        Unmarshaller um = ctx2.createUnmarshaller();
//        StringReader stringReader = new StringReader(zhongji);
//        String read = read(zhongji);
//        System.out.println("read："+read);
//        System.out.println("stringReader："+stringReader.toString());
        ResponseEntity sclass1 = (ResponseEntity) um.unmarshal(new StringReader(zhongji));
        System.out.println("------------------------------------------------------------");
        System.out.println("对象："+sclass1.toString());

        }
    public static String read(String content) throws Exception
    {
        StringReader in=new StringReader(content);
        int s;
        String sb = "";
        while((s=in.read())!=-1)
        {
            sb+=(char)s;
        }
        in.close();
        return sb;
    }

    public static BusinessGroup getBusinessGroup(){
        BusinessGroup businessGroup = new BusinessGroup();
        GroupResourceQuotaEntry groupResourceQuotaEntry  = new GroupResourceQuotaEntry();
        groupResourceQuotaEntry.setResourceName("wqeqwe");

        GroupResourceQuotaEntry groupResourceQuotaEntry1  = new GroupResourceQuotaEntry();
        groupResourceQuotaEntry1.setResourceName("sdasdad");

//        GroupResourceQuotaEntry[] groupResourceQuotaEntries = {groupResourceQuotaEntry,groupResourceQuotaEntry1};
        List<GroupResourceQuotaEntry> groupResourceQuotaEntries = new ArrayList<>();
        groupResourceQuotaEntries.add(groupResourceQuotaEntry);
        groupResourceQuotaEntries.add(groupResourceQuotaEntry1);

        GroupResourceQuotaEntryItem groupResourceQuotaEntryItem = new GroupResourceQuotaEntryItem();
        groupResourceQuotaEntryItem.setItem(groupResourceQuotaEntries);
        List<GroupResourceQuotaEntryItem> groupResourceQuotaEntryItems =new ArrayList<>();
        groupResourceQuotaEntryItems.add(groupResourceQuotaEntryItem);
        businessGroup.setGroupResourceQuotaEntryList(groupResourceQuotaEntryItems);
        return businessGroup;
    }


}
