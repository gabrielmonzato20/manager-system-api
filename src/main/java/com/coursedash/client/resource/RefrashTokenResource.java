package com.coursedash.client.resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursedash.client.config.property.ApiProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class RefrashTokenResource {

@Autowired
private ApiProperties apiProperties;

    @DeleteMapping("/revoke")
    public void deleteToken(HttpServletRequest req , HttpServletResponse resp){
        Cookie  refrashToken  = new Cookie("refrashToken",null);
        refrashToken.setHttpOnly(Boolean.TRUE);
        refrashToken.setSecure(apiProperties.getSecurity().isEnableHttps());
        refrashToken.setPath(req.getContextPath()+"/oauth/token");
        refrashToken.setMaxAge(0);
        resp.addCookie(refrashToken);
        resp.setStatus(HttpStatus.NO_CONTENT.value());
    }
    
}
