package com.example.ticketone.service;

import com.example.ticketone.entity.Artist;
import com.example.ticketone.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<Artist> getAll() throws Exception {
        throw new Exception("ciao");
        //return artistRepository.findAll();
    }
}
