package com.dldnwls.sseservice.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class ResponseDto {

    private Long id;
    private String name;
    private String status;
    private int progress;
    private boolean success;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    private List<String> messages;
    private List<Integer> scores;
    private Map<String, Object> extra;

    //더미 데이터로 생성자 채우기
    public ResponseDto() {
        this.id = 1L;
        this.name = "더미 작업";
        this.status = "COMPLETED";
        this.progress = 100;
        this.success = true;

        this.createdAt = LocalDateTime.now().minusSeconds(15);
        this.completedAt = LocalDateTime.now();

        this.messages = List.of(
                "요청 수신",
                "캐시 조회 완료",
                "데이터 처리 완료",
                "응답 생성 완료"
        );

        this.scores = List.of(88, 92, 95, 100);

        this.extra = Map.of(
                "server", "sse-service-01",
                "thread", Thread.currentThread().getName(),
                "elapsedMs", 15234,
                "debug", true
        );
    }
}
