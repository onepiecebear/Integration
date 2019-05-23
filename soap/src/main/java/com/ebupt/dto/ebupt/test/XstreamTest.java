package com.ebupt.dto.ebupt.test;

import com.ebupt.dto.ebupt.pojo.*;
import com.ebupt.dto.ebupt.reflect.ReflectUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;
import java.util.List;

public class XstreamTest {

	public static void main(String[] args) {
		//采用非注解方式将对象转xml
		String resultXml9 = beanToXml();
		System.out.println(resultXml9);
		System.out.println("-------------------------------------------------------------------");
		//String resultXml="<getBusinessGroupReturn><rtsName>10084</rtsName><BG>东信北邮</BG><name/><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>18940979902</businessPhoneNumber><city>四川</city><SERVAREANO>999</SERVAREANO><comment>sss</comment><country>海南</country><department>444</department><email>12345@qq.com</email><familyName>3333</familyName><faxNumber>222</faxNumber><givenName>123</givenName><homePhoneNumber>1111</homePhoneNumber><location>1233</location><mobilePhoneNumber>123333</mobilePhoneNumber><namePrefix>小姐</namePrefix><postalCode>12333</postalCode><roomNumber>123</roomNumber><street>E-102</street><url>www.123.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>CloseGroup</ServiceCode><Quota><value>0</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>RelativeNumbers</resourceName><assignedQuota><value>111</value></assignedQuota><usedQuota/></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>张</familyName><givenName>三</givenName><businessPhoneNumber>12345</businessPhoneNumber><mobilePhoneNumber>18940979902</mobilePhoneNumber><email>18940979902@163.com</email><faxNumber>12345</faxNumber><Address>1233345</Address><postalCode>1233345</postalCode></CustomerManagerInformation></getBusinessGroupReturn>";
//        System.out.println("*******************************************************************");
//        String customerxml="<CustomerManagerInformation><familyName>张</familyName><givenName>三</givenName><businessPhoneNumber>12345</businessPhoneNumber><mobilePhoneNumber>18940979902</mobilePhoneNumber><email>18940979902@163.com</email><faxNumber>12345</faxNumber><Address>1233345</Address><postalCode>1233345</postalCode></CustomerManagerInformation>";
//        Object bank = xmlToBean(customerxml);
//		System.out.println(bank.toString());


//        System.out.println("*******************************************************************");
//        String s = "<groupResourceQuotaEntryList><item><resourceName>RelativeNumbers</resourceName><assignedQuota><value>111</value></assignedQuota><usedQuota/></item></groupResourceQuotaEntryList>";
//                    <groupResourceQuotaEntryList><item><resourceName>RelativeNumbers
// Object o = xmlToBean(s);
//        System.out.println(o.toString());


//        String s1 = "<serviceQuotaList><ServiceQuota><item><ServiceCode>CloseGroup</ServiceCode><Quota><value>0</value></Quota></item></ServiceQuota></serviceQuotaList>";
//        Object o1 = xmlToBean(s1);
//        System.out.println(o1.toString());


//        String s2 = "<getBusinessGroupReturn><rtsName>10084</rtsName><BG>东信北邮</BG><name/><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>18940979902</businessPhoneNumber><city>四川</city><SERVAREANO>999</SERVAREANO><comment>sss</comment><country>海南</country><department>444</department><email>12345@qq.com</email><familyName>3333</familyName><faxNumber>222</faxNumber><givenName>123</givenName><homePhoneNumber>1111</homePhoneNumber><location>1233</location><mobilePhoneNumber>123333</mobilePhoneNumber><namePrefix>小姐</namePrefix><postalCode>12333</postalCode><roomNumber>123</roomNumber><street>E-102</street><url>www.123.com</url></contactAddress><CustomerManagerInformation><familyName>张</familyName><givenName>三</givenName><businessPhoneNumber>12345</businessPhoneNumber><mobilePhoneNumber>18940979902</mobilePhoneNumber><email>18940979902@163.com</email><faxNumber>12345</faxNumber><Address>1233345</Address><postalCode>1233345</postalCode></CustomerManagerInformation></getBusinessGroupReturn>";
//        Object o2 = xmlToBean(s2);
//        System.out.println(o2.toString());


        String s = "<getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhiteList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlackList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhiteList</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>BGUserNum</resourceName><assignedQuota><value>5</value></assignedQuota><usedQuota><value>0</value></usedQuota></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn>";
        Object ol = xmlToBean(s);
        System.out.println(ol.toString());
    }

	private static Object xmlToBean(String resultXml) {
		//创建xstream对象
		XStream xStream = new XStream(new DomDriver());
		//将别名与xml名字对应
//		xStream.alias("CustomerManagerInformation",CustomerManagerInformation.class);
//        xStream.aliasField("姓名", Person.class,"name");//为类的字段节点重命名
        xStream.processAnnotations(ReflectUtils.getClasssFromPackage("com.ebupt.pojo"));

        //将字符串类型的xml转换为对象
		return xStream.fromXML(resultXml);
	}

	private static String beanToXml() {


//        Object o = getServiceQuotaList();
//        Object o = groupResourceQuotaEntryList();
        Object o = getBusinessGroup();
        //创建xstream对象
		XStream xStream = new XStream(new DomDriver());
		//给指定类起别名
//		xStream.alias("ServiceQuotaList", ServiceQuotaList.class);
//		xStream.alias("item", ServiceQuota.class);
//        xStream.alias("item", GroupResourceQuotaEntry.class);
//        xStream.aliasField("姓名", Person.class,"name");//为类的字段节点重命名
        xStream.processAnnotations(ReflectUtils.getClasssFromPackage("com.ebupt.pojo"));
		//将对象转换成xml字符串
		String xml = xStream.toXML(o);

		return xml;
	}


    public static Object getBusinessGroup(){
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




	public static BusinessGroup getServiceQuotaList(){
        BusinessGroup businessGroup = new BusinessGroup();
        ServiceQuota serviceQuota = new ServiceQuota();
        LongValue longValue = new LongValue();
        longValue.setValue(123456789);
        serviceQuota.setQuota(longValue);
//        serviceQuota.setServiceCode(ServiceCodeEnum.AlarmCall);


        ServiceQuota serviceQuota1 = new ServiceQuota();
        LongValue longValue1 = new LongValue();
        longValue1.setValue(38383888);
        serviceQuota1.setQuota(longValue1);
//        serviceQuota1.setServiceCode(ServiceCodeEnum.IdlestHuntingGroup);

        ServiceQuotaList serviceQuotaList = new ServiceQuotaList();

        List<ServiceQuota> item = new ArrayList<ServiceQuota>();
        item.add(serviceQuota);
        item.add(serviceQuota1);

        ServiceQuotaItem serviceQuotaItems = new ServiceQuotaItem();

        serviceQuotaItems.setItem(item);

        List<ServiceQuotaItem> quotaItems = new ArrayList<ServiceQuotaItem>();

        quotaItems.add(serviceQuotaItems);

        serviceQuotaList.setServiceQuota(quotaItems);

        businessGroup.setServiceQuotaList(serviceQuotaList);
        return businessGroup;
    }
}
