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

    private final static String DB_HIB_EX = "Error while accessing database";

    public String dbHubEx() {return DB_HIB_EX;}

}
