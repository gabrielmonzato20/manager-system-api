package com.coursedash.client.event;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;
import javassist.SerialVersionUID;


public class EventCreatead  extends ApplicationEvent{

    private final static long  serialVersionUID = 1L;
    private HttpServletResponse response;
    private Long code;

	
    public EventCreatead(Object obj,HttpServletResponse httpServletResponse , Long code ){
        super(obj);
        this.response = httpServletResponse;
        this.code =code ;
    }

    
    public HttpServletResponse getResponse() {
        return this.response;
    }

  

    public Long getCode() {
        return this.code;
    }
}
    

