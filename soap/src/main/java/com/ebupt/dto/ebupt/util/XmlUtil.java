package com.ebupt.dto.ebupt.util;

import com.ebupt.dto.ebupt.dto.ResponseEntity;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlUtil {

    public static String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息

            StringWriter out = new StringWriter();
            OutputFormat format = new OutputFormat();
            format.setIndent(true);
            format.setNewlines(true);
            format.setNewLineAfterDeclaration(false);
            XMLWriter writer = new XMLWriter(out, format);

            XMLFilterImpl nsfFilter = new XMLFilterImpl() {
                private boolean ignoreNamespace = false;
                private String rootNamespace = null;
                private boolean isRootElement = true;

                @Override
                public void startDocument() throws SAXException {
                    super.startDocument();
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                    if (this.ignoreNamespace) uri = "";
                    if (this.isRootElement) this.isRootElement = false;
                    else if (!uri.equals("") && !localName.contains("xmlns")) localName = localName + " xmlns=\"" + uri + "\"";

                    super.startElement(uri, localName, localName, atts);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (this.ignoreNamespace) uri = "";
                    super.endElement(uri, localName, localName);
                }

                @Override
                public void startPrefixMapping(String prefix, String url) throws SAXException {
                    if (this.rootNamespace != null) url = this.rootNamespace;
                    if (!this.ignoreNamespace) super.startPrefixMapping("", url);

                }
            };
            nsfFilter.setContentHandler(writer);
            marshaller.marshal(obj, nsfFilter);
            return out.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromXML(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // return (T) unmarshaller.unmarshal(new StringReader(xml));
//            SerializeUtil obj = new SerializeUtil();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XMLFilterImpl nsfFilter = new XMLFilterImpl() {
                private boolean ignoreNamespace = false;

                @Override
                public void startDocument() throws SAXException {
                    super.startDocument();
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                    if (this.ignoreNamespace) uri = "";
                    super.startElement(uri, localName, qName, atts);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (this.ignoreNamespace) uri = "";
                    super.endElement(uri, localName, localName);
                }

                @Override
                public void startPrefixMapping(String prefix, String url) throws SAXException {
                    if (!this.ignoreNamespace) super.startPrefixMapping("", url);
                }
            };
            nsfFilter.setParent(reader);
            InputSource input = new InputSource(new StringReader(xml));
            SAXSource source = new SAXSource(nsfFilter, input);
            return (T) unmarshaller.unmarshal(source);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        BusinessGroup businessGroup =  new BusinessGroup();
//
//        OutParameters outParameters = new OutParameters();
//        outParameters.setBusinessGroup(businessGroup);
//
//        GetBusinessGroupResponse getBusinessGroupResponse = new GetBusinessGroupResponse();
//        getBusinessGroupResponse.setOutParameters(outParameters);
//
//        ResponseBody responseBody = new ResponseBody();
//        responseBody.setGetBusinessGroupResponse(getBusinessGroupResponse);
//
//        ResponseEntity requestEntity = new ResponseEntity();
//        requestEntity.setBody(responseBody);
//        String s = toXML(requestEntity);
//        System.out.println(s);

        String zhongji =  "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><SOAP-ENV:Body><opns:getBusinessGroupResponse xmlns:opns=\"GenericBrokerBMP\"><out_parameters><resultCode>0000</resultCode><resultDesc>操作成功</resultDesc><getBusinessGroupReturn><rtsName>ims.chinamobile.com</rtsName><BG>bj-test</BG><name></name><BGLockFLG>0</BGLockFLG><contactAddress><businessPhoneNumber>01082325586</businessPhoneNumber><city>北京</city><SERVAREANO>10</SERVAREANO><comment>北京总公司</comment><country>中国</country><department>管理部</department><email>82325588@ebupt.com</email><familyName>EB</familyName><faxNumber>01082325588</faxNumber><givenName>EB</givenName><homePhoneNumber>01082325586</homePhoneNumber><location>789</location><mobilePhoneNumber>13800138000</mobilePhoneNumber><namePrefix>先生</namePrefix><postalCode>100191</postalCode><roomNumber>789</roomNumber><street>知春路</street><url>www.ebupt.com</url></contactAddress><serviceQuotaList><ServiceQuota><item><ServiceCode>GroupCalleBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCalleeWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerBlack List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>GroupCallerWhite List</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>InnerCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>OuterCall</ServiceCode><Quota><value>5</value></Quota></item><item><ServiceCode>RelativeNumbers</ServiceCode><Quota><value>5</value></Quota></item></ServiceQuota></serviceQuotaList><groupResourceQuotaEntryList><item><resourceName>BGUserNum</resourceName><assignedQuota><value>5</value></assignedQuota><usedQuota><value>0</value></usedQuota></item></groupResourceQuotaEntryList><CustomerManagerInformation><familyName>EB</familyName><givenName>EB</givenName><businessPhoneNumber>01082325586</businessPhoneNumber><mobilePhoneNumber>13800138000</mobilePhoneNumber><email>82325588@ebupt.com</email><faxNumber>100191</faxNumber><Address>知春路</Address><postalCode>知春路</postalCode></CustomerManagerInformation></getBusinessGroupReturn></out_parameters></opns:getBusinessGroupResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";
//
        ResponseEntity responseEntity = fromXML(zhongji, ResponseEntity.class);
        System.out.println(responseEntity);
    }
}