package com.swontech.s02.aop;

import com.swontech.s02.client.response.CustomResponse;
import io.jsonwebtoken.MalformedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
   private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

   /** ========================================
    * Method Not Supported Exception Handler
    * 컨트롤러의 메소드가 맞지않을 경우 예외를 발생시킨다.
   ======================================== */
   @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
   protected ResponseEntity<CustomResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
      logger.info("=======================================");
      logger.info("해당 컨트롤러는 '{}' 메소드를 지원하지 않습니다.", e.getMethod());
      logger.info("=======================================");
      final CustomResponse response = CustomResponse
              .create()
              .status(HttpStatus.METHOD_NOT_ALLOWED.value())
              .message(e.getMessage());
      return new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   protected ResponseEntity<CustomResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

      logger.info("valid에러");
//      List<FieldError> binding = new ArrayList<>();
//      final ErrorResponse response = ErrorResponse
//              .create()
//              .setCustomFieldErrors(e.getBindingResult().getAllErrors().forEach(c -> binding));
//
//              ;

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }
}
