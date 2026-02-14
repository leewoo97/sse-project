package com.dldnwls.sseservice.domain.controller;

import com.dldnwls.sseservice.component.EventEmitter;
import com.dldnwls.sseservice.component.EventEmitterManager;
import com.dldnwls.sseservice.domain.dto.RequestDto;
import com.dldnwls.sseservice.domain.service.TestService;
// import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/sse")
@RequiredArgsConstructor
@RestController
public class TestController {

    private final EventEmitterManager eventEmitterManager;
    private final TestService testService;

    // @Operation(summary = "내부네트워크 조회")
    @GetMapping(produces = "text/event-stream")
    public EventEmitter getList(RequestDto request) {
        System.out.println("들어오는 파라미터 : " + request.toString());
        EventEmitter emitter = eventEmitterManager.create();
        testService.getList(emitter, request);
        return emitter;
    }


}
