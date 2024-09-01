package com.example.ticketone.specification;

import com.example.ticketone.entity.Artist;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ArtistSpecificationBuilder extends SpecificationBuilder {

    public Specification<Artist> build(Map<String, String> params) {

        Specification<Artist> specification = Specification.where(null);

        for (String key : params.keySet()) {

            //.equals
            if (key.contains(".equals"))
                equalsMethod(key.split("\\.")[0], params.get(key), specification);

            //.like
            if (key.contains(".like"))
                likeMethod(key.split("\\.")[0], params.get(key), specification);

        }
        return specification;
    }
}
