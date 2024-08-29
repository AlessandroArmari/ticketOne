package com.example.ticketone.service;

import com.example.ticketone.entity.Artist;
import com.example.ticketone.utility.error.MessageErrorBuilder;
import com.example.ticketone.utility.exception.custom.DbHibernateEx;
import com.example.ticketone.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final MessageErrorBuilder messageErrorBuilder;

    public List<Artist> getAll() {
        try {

            throw new DbHibernateEx("ciao");
            //return artistRepository.findAll();


        } catch (DbHibernateEx dbHibEx) {
            throw new DbHibernateEx(messageErrorBuilder.dbHubEx(), dbHibEx);
        } catch (RuntimeException runEx) {
            throw new RuntimeException("ciao", runEx);
        }



        //creare Logger --> sistemare file logger
    }
}
