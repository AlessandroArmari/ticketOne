package com.example.ticketone.utility.error;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MessageErrorBuilder {

    private final static String DB_HIB_EX = "Undefined Error while accessing database";

    private final static String RUN_TIME_EX = "Undefined Error";


    public String dbHubEx() {
        return DB_HIB_EX;
    }

    public String runTimeEx() {
        return RUN_TIME_EX;
    }
}

