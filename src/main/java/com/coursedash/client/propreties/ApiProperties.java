package com.coursedash.client.propreties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("client")
public class ApiProperties {

    private final Security security = new Security();

    private String origin="";

    public String getOrigin() {
        return this.origin;
    }



    public static class Security{ 


        private Boolean enableHttps;

        public Boolean isEnableHttps() {
            return this.enableHttps;
        }



    
    
    }


    public Security getSecurity() {
        return this.security;
    }
    
}
