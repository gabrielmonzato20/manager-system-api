package com.coursedash.client.config.util;

import org.hibernate.annotations.SourceType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ecripted {
    public static void main(String[] args) {
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hasg = encode.encode("@ngul@r");
        System.out.println(hasg);
    }
    
}
