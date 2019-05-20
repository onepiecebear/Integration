package com.ebupt.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Author: yushibo
 * @Date: 2019/5/14 15:56
 * @Description: 重写HttpServletRequestWrapper防止XSS攻击
 */

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        System.out.println("getParameterMap");
//        if(super.getParameterMap() == null){
//            System.out.println("getParameterMap()为空");
//
//        }
//        Map<String, String[]>  map  = super.getParameterMap();
//        for (String[] vs : map.values()) {
//            for (int i = 0; i < vs.length; i++) {
//                System.out.println("value= " + vs[i]);
//            }
//
//        }
//        System.out.println("getParameterMap():"+super.getParameterMap());
        return super.getParameterMap();
    }

    @Override
    public Enumeration<String> getParameterNames() {
        System.out.println("getParameterNames");
//        Enumeration<String> en =  super.getParameterNames();
//        while(en.hasMoreElements())
//        {
//            System.out.println("getParameterNames():"+en.nextElement());
//        }
        return super.getParameterNames();
    }

    @Override
    public String[] getParameterValues(String name) {
        System.out.println("getParameterValues");
        System.out.println("getParameterValues --- name ："+name);
        String[] value =super.getParameterValues(name);
        if(value != null){
            for (int i = 0; i < value.length; i++) {
                System.out.println("htmlEscape前:"+value[i]);
                value[i] = HtmlUtils.htmlEscape(value[i]);
                System.out.println("htmlEscape后:"+value[i]);

            }
        }

        return value;
    }

    @Override
    public String getParameter(String name) {
        System.out.println("getParameter");
//        // 过滤getParameter参数检查是否有特殊字符
//        String value = super.getParameter(name);
//        System.out.println("value:" + value);
//        if (!StringUtils.isEmpty(value)) {
//            // 将中文转换为字符编码格式，将特殊字符变为html源代码保存
//            value = HtmlUtils.htmlEscape(value);
//            System.out.println("newValue:" + value);
//        }
        return super.getParameter(name);
    }

}

