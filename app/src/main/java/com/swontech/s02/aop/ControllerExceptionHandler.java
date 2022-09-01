package com.swontech.s02.aop;

import com.swontech.s02.domain.common.exception.CustomException;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
   private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
   private final CustomResponse reponse;
   public ControllerExceptionHandler(CustomResponse response) {
      this.reponse = response;
   }

   /** ========================================
    * Method Not Supported Exception Handler
    * 컨트롤러의 메소드가 맞지않을 경우 예외를 발생시킨다.
   ======================================== */
//   @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//   public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//      logger.info("=======================================");
//      logger.error("해당 컨트롤러는 '{}' 메소드를 지원하지 않습니다.", e.getMethod());
//      logger.info("=======================================");
//      final CustomException = response
//              .create()
//              .status(HttpStatus.METHOD_NOT_ALLOWED.value())
//              .message(e.getMessage());
//      return new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
//   }

   /** ========================================
    * Method Args Not Valid Exception Handler
    * Validation에러시 예외를 발생시킨다.
    ======================================== */
//   @ExceptionHandler(MethodArgumentNotValidException.class)
//   public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//
//
//
//      logger.warn("valid에러");
////      List<FieldError> binding = new ArrayList<>();
////      final ErrorResponse response = ErrorResponse
////              .create()
////              .setCustomFieldErrors(e.getBindingResult().getAllErrors().forEach(c -> binding));
////
////              ;
//
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//   }
}
