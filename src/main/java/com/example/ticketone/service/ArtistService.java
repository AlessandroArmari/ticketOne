package com.example.ticketone.service;

import com.example.ticketone.entity.Artist;
import com.example.ticketone.specification.SpecificationBuilder;
import com.example.ticketone.utility.error.MessageErrorBuilder;
import com.example.ticketone.utility.exception.custom.DbHibernateEx;
import com.example.ticketone.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final MessageErrorBuilder messageErrorBuilder;
    private final SpecificationBuilder specificationBuilder;

    public Page<Artist> getAll(Map<String, String> params, Pageable pageable) {
        try {

            Specification<Artist> specification = specificationBuilder.build(params);

            Page<Artist> artists = artistRepository.findAll(specification, pageable);


            return artists;


        } catch (DbHibernateEx dbHibEx) {
            throw new DbHibernateEx(messageErrorBuilder.dbHubEx(), dbHibEx);
        } catch (RuntimeException runEx) {
            throw new RuntimeException(messageErrorBuilder.runTimeEx(), runEx);
        }

        //aggiungere db

        //vedere perchè non funziona la in()

        //migliorare logger
    }
}
