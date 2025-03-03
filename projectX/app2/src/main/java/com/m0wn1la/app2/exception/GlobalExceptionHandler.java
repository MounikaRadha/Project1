package com.m0wn1la.app2.exception;

import com.m0wn1la.app2.dto.APIErrorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CheatingException.class})
    public ResponseEntity<Object> handleGlobalException(CheatingException exception) {
        APIErrorDTO apiErrorDTO = new APIErrorDTO();
        apiErrorDTO.setCode("internal err as your are trying to cheat by trying to modify others data");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiErrorDTO);
    }

    @ExceptionHandler({InvalidDetailsByUserException.class})
    public ResponseEntity<Object> handleGlobalException(InvalidDetailsByUserException exception) {
        APIErrorDTO apiErrorDTO = new APIErrorDTO();
        apiErrorDTO.setCode(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiErrorDTO);
    }

}
