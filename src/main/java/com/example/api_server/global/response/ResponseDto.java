package com.example.api_server.global.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"success","data", "errorCode", "errorMessage"})
public class ResponseDto<T> {
    private boolean success;  // 성공 여부
    private T data; // 성공 시 반환할 데이터
    private String errorCode; // 실패 시 에러 코드
    private String errorMessage; // 실패 시 에러 메시지

    // 성공 응답
    public static <T> ResponseDto<T> success(T data) {
        return ResponseDto.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    // 실패 응답
    public static <T> ResponseDto<T> error(String errorCode, String errorMessage) {
        return ResponseDto.<T>builder()
                .success(false)
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
    }
}
