package com.example.ticketone.specification;

import com.example.ticketone.entity.Artist;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SpecificationBuilder {

    public <T> Specification<T> build(Map<String, String> params) {


        Specification<T> specification = Specification.where(null);

        for (String key : params.keySet()) {

            String dbField = key.split("\\.")[0];
            String value = params.get(key);

            //.equals
            if (key.contains(".equals"))
                specification = specification.and((root, query, cb) -> cb.equal(root.get(dbField), value));

            //.like
            if (key.contains(".like"))
                specification =  specification.and((root, query, cb) -> cb.like(root.get(dbField), "%" + value + "%"));


            if (key.contains(".in"))
                specification =  specification.and((root, query, cb) -> cb.in(root.get(dbField)));

        }

        return specification;
    }


}
