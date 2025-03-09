package com.example.refrig.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String message; //에러 메시지
    private int status; //HTTP 상태 코드
    private String code; //에러 코드 (커스텀 에러코드)
    private List<FieldError> errors; // 구체적인 필드 오류

    public static ErrorResponse of(
            ErrorCode errorCode,
            BindingResult bindingResult, // 스프링 Validation 등을 통해 폼이나 dto 검증이 실패하면 검증오류 정보가 bindingResult에 쌓인다.
            List<FieldError> errors, // 상황에 따라 직접 정의한 필드 에러를 주입할 수 있는 용도.
            String customMessage //errorCode에 정의된 기본 메시지 대신 상황에 따라 다른 메시지를 사용하고 싶을 때 주입하는 파라미터
    ) {
        List<FieldError> resolvedErrors;

        if (bindingResult != null) {
            resolvedErrors = FieldError.of(bindingResult);
        } else if (errors != null) {
            resolvedErrors = errors;
        } else {
            resolvedErrors = Collections.emptyList();
        }

        return ErrorResponse.builder()
                .message(customMessage != null ? customMessage : errorCode.getMessage())
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .errors(resolvedErrors)
                .build();
    }


    // 중첩 클래스.
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldError {
        private String field; //에러 발생한 필드 이름
        private String value; //서버가 받은 잘못된 값
        private String reason; //에러 사유

        public static List<FieldError> of(BindingResult bindingResult) {
            // 스프링의 bindingResult.getFieldErrors 목록을 순회하며 우리 정의의 FieldError 객체로 변환.
            // 일관된 에러 응답 구조
            return bindingResult.getFieldErrors().stream()
                    .map(err -> new FieldError(
                            err.getField(),
                            err.getRejectedValue() == null ? "" : err.getRejectedValue().toString(),
                            err.getDefaultMessage() == null ? "" : err.getDefaultMessage()
                    ))
                    .collect(Collectors.toList());
        }

    }
}
