package com.example.ticketone.controller;

import com.example.ticketone.entity.Artist;
import com.example.ticketone.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class ArtistController {

    private final ArtistRepository artistRepository;

    @GetMapping("get-all-artist")
    public List<Artist> getAll(){
        return artistRepository.findAll();
    }
}
