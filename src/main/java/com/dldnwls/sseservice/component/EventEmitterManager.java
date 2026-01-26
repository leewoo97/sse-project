package com.dldnwls.sseservice.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class EventEmitterManager {

    private final Set<EventEmitter> emitters = ConcurrentHashMap.newKeySet();

    @Scheduled(fixedRate = 15000)
    public void heartbeat() {
        for(EventEmitter emitter : emitters) {
            try {
                System.out.println("Listen to my Heartbeat Waiting for you!!");
                emitter.send(SseEmitter.event().comment("ping"));
            } catch (Exception e) {
                emitter.complete();
                emitters.remove(emitter);
            }
        }
    }

    public EventEmitter create() {
        try {
            EventEmitter emitter = new EventEmitter();
            emitters.add(emitter);

            emitter.onCompletion(() -> emitters.remove(emitter));
            emitter.onTimeout(() -> emitters.remove(emitter));
            emitter.onError(e -> emitters.remove(emitter));

            emitter.send("connect","open");
            return emitter;
        } catch (Exception e){
            throw new RuntimeException("EventEmitter 생성 중 오류 발생", e);
        }
    }
}
