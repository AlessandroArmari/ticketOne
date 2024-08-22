package com.example.ticketone.service;

import com.example.ticketone.entity.Artist;
import com.example.ticketone.utility.exception.custom.DbHibernateEx;
import com.example.ticketone.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<Artist> getAll() {
        try{

            //throw new RuntimeException("");
            throw new DbHibernateEx("ciao");
            //return artistRepository.findAll();


        } catch (DataAccessException dbEx) {
            throw new DbHibernateEx("erro accesso a db", dbEx);
        } catch (RuntimeException runEx) {
            runEx.printStackTrace();
            throw new RuntimeException("ciao", runEx);
        }

        //creare messageBuilder

        //creare Logger
    }
}
