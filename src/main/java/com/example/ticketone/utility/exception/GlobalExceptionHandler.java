package com.example.ticketone.utility.exception;

import com.example.ticketone.utility.error.MyError;
import com.example.ticketone.utility.exception.custom.DbHibernateEx;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DbHibernateEx.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MyError> handleDbHibernateException(DbHibernateEx dbEx, HttpServletRequest request) {
        return ResponseEntity.internalServerError().body(MyError.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(dbEx.getMessage())
                .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleGeneralException(Exception ex, HttpServletRequest request) {
        return new Error("GENERAL_ERROR", ex);
    }

}
