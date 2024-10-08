package com.example.ticketone.entity;

import com.example.ticketone.entity.typologic.Country;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //relations
    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private List<Tour> tours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="country_id", nullable = false)
    private Country country;

}
