package com.ebupt.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yushibo
 * @Date: 2019/5/14 15:32
 * @Description: 获取网络信息的通用工具
 */
public class NetworkUtil {

    /**
     * 获取url对应的域名或IP
     * @url
     * @return
     */
    public static String getDomain(String url) {
        String result = "";
        int j = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i<url.length(); i++) {
            if (url.charAt(i) == '/') {
                j++;
                if (j == 2){
                    startIndex = i;
                }else if (j == 3){
                    endIndex = i;
                }
            }
        }
        result = url.substring(startIndex + 1, endIndex);
        return result;
    }

    public static String getIpReal(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");

        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();

    }
}
