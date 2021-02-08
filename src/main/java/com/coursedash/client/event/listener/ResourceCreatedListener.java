package com.coursedash.client.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import com.coursedash.client.event.EventCreatead;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ResourceCreatedListener implements ApplicationListener<EventCreatead> {

    @Override
    public void onApplicationEvent(EventCreatead event) {
        HttpServletResponse response = event.getResponse();
        Long code = event.getCode();
        extracted(response, code);

    }

    private void extracted(HttpServletResponse response, Long code) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(code)
        .toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
    
}
