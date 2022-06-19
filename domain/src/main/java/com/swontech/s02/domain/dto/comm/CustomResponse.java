package com.swontech.s02.domain.dto.comm;
/**
 * 로직 수행 결과 Response를 정의한 클래스 파일
 * <p>
 *
 * </p>
 * @version : 1.0
 * @author  : MSH
 * @since   : 2022.03.24
 * ================================================
 * @lastmodify  : 2022.03.24 MSH
 *
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CustomResponse {

    @Getter
    @Builder
    private static class Body {
        // private LocalDateTime timestamp = LocalDateTime.now();
        // HTTP 상태코드
        private int status;
        // 결과 (success or fail)
        private String result;
        // 결과 메시지
        private String massage;
        // 결과 데이터
        private Object data;
        // 에러
        private Object error;

        // ArgsFieldError
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("errors")
        private List<CustomFieldError> customFieldErrorList;
    }

    @AllArgsConstructor
    @Getter
    private static class CustomFieldError {
        private String field;
        private Object value;
        private String reason;
    }

    /**
     * 데이터, 메시지, 상태코드를 포함한 Success Response
     * <p>
     *
     * </p>
     * @param {Obejct}타입의 로직 수행 결과 데이터
     * @param {String}타입의 로직 수행 결과 메시지
     * @param {HttpStatus}타입의 상태 코드
     */
    public ResponseEntity<?> success(Object data, String message, HttpStatus httpStatus) {
        Body body = Body.builder()
                .result("success")
                .status(httpStatus.value())
                .data(data)
                .massage(message)
                .error(Collections.emptyList())
                .build();
        return ResponseEntity.ok(body);
    }

    /**
     * 성공 메시지를 담은 Success Response
     * <p>
     *
     * </p>
     * @param {String}타입의 로직 수행 결과 메시지
     */
    public ResponseEntity<?> success(String message) {
        return success(Collections.emptyList(), message, HttpStatus.OK);
    }

    /**
     * 로직 수행 결과 데이터를 담은 Success Response
     * <p>
     *
     * </p>
     * @param {Object}타입의 로직 수행 결과 데이터
     */
    public ResponseEntity<?> success(Object data) {
        return success(data, null, HttpStatus.OK);
    }

    /**
     * 데이터, 메시지, 상태코드를 포함한 Fail Response
     * <p>
     *
     * </p>
     * @param {Obejct}타입의 로직 수행 결과 데이터
     * @param {String}타입의 로직 수행 결과 메시지
     * @param {HttpStatus}타입의 상태 코드
     */
    public ResponseEntity<?> fail(Object data, String message, HttpStatus status) {
        Body body = Body.builder()
                .status(status.value())
                .data(data)
                .result("fail")
                .massage(message)
                .error(Collections.emptyList())
                .build();
        return ResponseEntity.ok(body);
    }

    public ResponseEntity<?> fail(String message, HttpStatus status) {
        return fail(Collections.emptyList(), message, status);
    }
}
