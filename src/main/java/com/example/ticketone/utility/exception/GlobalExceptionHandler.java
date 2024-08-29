package com.example.ticketone.utility.exception;

import com.example.ticketone.utility.error.MyError;
import com.example.ticketone.utility.exception.custom.DbHibernateEx;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DbHibernateEx.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MyError> handleDbHibernateException(DbHibernateEx dbHibEx, HttpServletRequest request) {

        log.error(dbHibEx.getMessage());

        return ResponseEntity.internalServerError().body(
                MyError.builder()
                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .internalCode("codice da definire")
                        .message(dbHibEx.getMessage())
                        .timestamp(new Timestamp(System.currentTimeMillis()).toString())
                        .classAndLineWhereThrown(Arrays.stream(dbHibEx.getStackTrace()).map(elem -> String.format("Class: %s, Line: %s ", elem.getClassName(), elem.getLineNumber())).findFirst().orElse("no StackTrace found"))
                        .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleGeneralException(Exception ex, HttpServletRequest request) {
        return new Error("GENERAL_ERROR", ex);
    }

}
