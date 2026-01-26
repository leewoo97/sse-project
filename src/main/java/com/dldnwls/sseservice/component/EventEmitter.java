package com.dldnwls.sseservice.component;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class EventEmitter extends SseEmitter {
    public EventEmitter() {
        super(36000000L);
    }

    public void send(String label, Object data){
        try{
            this.send(SseEmitter.event().name(label).data(data));
        } catch (IOException e) {
            this.completeWithError(e);
        }
    }

}
