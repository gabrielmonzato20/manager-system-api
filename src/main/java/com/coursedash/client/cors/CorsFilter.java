package com.coursedash.client.cors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursedash.client.propreties.ApiProperties;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
    @Autowired
    private ApiProperties apiProperties;
private String origAlow = apiProperties.getOrigin();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

            HttpServletRequest req  = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader("Acess-Control-Allow-Origin", origAlow);
            resp.setHeader("Acess-Control-Allow-Credentials", Boolean.TRUE.toString());
            if("OPTIONS".equals(req.getMethod()) && 
            origAlow.equals(req.getHeader("Origin"))){
                resp.setHeader("Acess-Control-Allow-Methods", 
                "POST,GET,OPTIONS,DELETE,PUT,PATCH");
                resp.setHeader("Acess-Control-Allow-Headers", "Authorization,Content-Type,Accept");
                resp.setHeader("Acess-Control-Max-Age", "3600");
                resp.setStatus(HttpServletResponse.SC_OK);
            }else{
                chain.doFilter(request, response);
            }

    }


    
}
