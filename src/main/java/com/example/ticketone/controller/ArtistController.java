package com.example.ticketone.controller;

import com.example.ticketone.entity.Artist;
import com.example.ticketone.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("get-all-artist")
    public Page<Artist> getAll(@RequestParam Map<String, String> params, Pageable pageable) {

        return artistService.getAll(params, pageable);
    }
}
