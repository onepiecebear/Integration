package com.ebupt.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

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
    public String getParameter(String name) {
        // 过滤getParameter参数检查是否有特殊字符
        String value = super.getParameter(name);
        System.out.println("value:" + value);
        if (!StringUtils.isEmpty(value)) {
            // 将中文转换为字符编码格式，将特殊字符变为html源代码保存
            value = HtmlUtils.htmlEscape(value);
            System.out.println("newValue:" + value);
        }
        return value;
    }

}

