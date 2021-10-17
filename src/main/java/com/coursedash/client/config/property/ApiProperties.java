package com.coursedash.client.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("client")
@Component
public class ApiProperties {


    private final Security security = new Security();

    private String origin="";

    public String getOrigin() {
        return this.origin;
    }
    public void setOrigin(String origin){ 
        this.origin = origin; 
    }


    public static class Security{ 


        private Boolean enableHttps;

        public Boolean isEnableHttps() {
            return this.enableHttps;
        }

        public void setEnableHttps(Boolean enable) {
             this.enableHttps = enable;
        }
        
    
    
    }


    public Security getSecurity() {
        return this.security;
    }
    

}
