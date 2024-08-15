package com.example.ticketone.entity.typologic;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Country {

    @Id
    @OneToOne(mappedBy = "nation")
    private String nation;
}
