package com.example.ticketone.utility.error;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MyError {

    private HttpStatus httpStatus;
    private String internalCode;
    private String message;

}
