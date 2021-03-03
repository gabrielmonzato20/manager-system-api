package com.coursedash.client.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursedash.client.propreties.ApiProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RefreshTokenProcess implements ResponseBodyAdvice<OAuth2AccessToken> {
    @Autowired
    private ApiProperties apiProperties;

    
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // TODO Auto-generated method stub
        return returnType.getMethod()
        .getName()
        .equals("postAccessToken");
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType,
            MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response) {
        
        HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();
        HttpServletResponse resp = ((ServletServerHttpResponse) response).getServletResponse();
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body ;
        String refreshToken=body.getRefreshToken().getValue();
        addRefreshTokenToCokkie(refreshToken,req,resp);
        removeRefreshTokenBody(token);
        return token;
    }

    private void removeRefreshTokenBody(DefaultOAuth2AccessToken token) {
    token.setRefreshToken(null);
    }

    private void addRefreshTokenToCokkie(String refreshToken, 
    HttpServletRequest req, HttpServletResponse resp) {
    Cookie refrashToken = new Cookie("refreshToken",refreshToken);
    refrashToken.setHttpOnly(true);
    refrashToken.setSecure(apiProperties.getSecurity().isEnableHttps());
    refrashToken.setPath(req.getContextPath()+"/oauth/token");
    refrashToken.setMaxAge(2592000);
    resp.addCookie(refrashToken);
    
    }
    
}

