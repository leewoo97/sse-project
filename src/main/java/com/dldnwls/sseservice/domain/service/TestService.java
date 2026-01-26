package com.dldnwls.sseservice.domain.service;

import com.dldnwls.sseservice.component.EventEmitter;
import com.dldnwls.sseservice.domain.dto.RequestDto;

public interface TestService {

    void getList(EventEmitter emitter, RequestDto requestDto);

}
