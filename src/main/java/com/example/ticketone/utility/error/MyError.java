package com.example.ticketone.utility.error;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MyError {

    private String httpStatus;
    private String internalCode;
    private String message;

    private String timestamp;
    private String classAndLineWhereThrown;
}
