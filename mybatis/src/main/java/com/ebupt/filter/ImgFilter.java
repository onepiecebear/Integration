package com.ebupt.filter;

import com.ebupt.utils.NetworkUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yushibo
 * @Date: 2019/5/14 13:56
 * @Description: 图片防盗链
 */
@WebFilter(filterName = "imgFilter", urlPatterns = "/imgs/*")
public class ImgFilter implements Filter{

    @Value("${domain.name}")
    private String domainName;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String referer = request.getHeader("Referer");
        if (StringUtils.isEmpty(referer)) {
            System.out.println("isEmpty");
            request.getRequestDispatcher("/imgs/error.jpg").forward(request, response);
            return;
        }
        String domain = NetworkUtils.getDomain(referer);
        if (!domain.equals(domainName)) {
            request.getRequestDispatcher("/imgs/error.jpg").forward(request, response);
            return;
        }
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
