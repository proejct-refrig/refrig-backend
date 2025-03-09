package com.example.refrig.api.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseWrapperDto<T> {
    private T data;
    private String code;
    private String message;
    private List<ErrorResponse.FieldError> errorList;

    // 에러 상황에 대한 DTO를 만들 때
    public static ResponseWrapperDto<ErrorResponse> of(ErrorResponse errorResponse) {
        return ResponseWrapperDto.<ErrorResponse>builder()
                .code(errorResponse.getCode())
                .message(errorResponse.getMessage())
                .errorList(errorResponse.getErrors())
                .build();
    }

    // 일반 성공 응답에 대한 DTO를 만들 때
    public static <T> ResponseWrapperDto<T> of(T body) {
        return ResponseWrapperDto.<T>builder()
                .data(body)
                .build();
    }


    // 객체를 JSON 문자열로 직렬화
    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize ResponseWrapperDto to JSON", e);
        }
    }
}
