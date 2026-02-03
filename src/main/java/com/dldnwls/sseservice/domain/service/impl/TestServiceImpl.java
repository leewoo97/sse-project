package com.dldnwls.sseservice.domain.service.impl;

import com.dldnwls.sseservice.component.EventEmitter;
import com.dldnwls.sseservice.domain.dto.RequestDto;
import com.dldnwls.sseservice.domain.dto.ResponseDto;
import com.dldnwls.sseservice.domain.service.TestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Async
    @Override
    public void getList(EventEmitter emitter, RequestDto requestDto) {
        try {
            //캐시 설정(캐시를 설정하면 유니크값을 가져옵니다.)
            //캐시를 조회해서 유니크 값을 얻었다고 가정
            int uk = 1234;

            //로딩율 조회(유니크값을 통해 로딩율을 확인할 수 있습니다.)
            for (int i = 1; i <= 10; i++) {
                System.out.println("조회할 유니크값 : " + uk);
                emitter.send("현재 로딩율", i);
                Thread.sleep(1000);
            }

            //결과값 조회
            List<ResponseDto> responseList = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                responseList.add(new ResponseDto());
            }
            System.out.println("결과값 출력 : " + responseList.toString());
            emitter.send("결과값", responseList);
            emitter.complete();
        } catch (Exception e) {
            emitter.send("error", e.getMessage());
            emitter.completeWithError(e);
        }
    }
}
