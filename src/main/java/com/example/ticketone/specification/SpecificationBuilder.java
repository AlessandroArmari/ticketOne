package com.example.ticketone.specification;

import com.example.ticketone.entity.Artist;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class SpecificationBuilder {



    protected void equalsMethod(String dbField, String value, Specification<?> specification) {
        specification.and((root, query, cb) -> cb.equal(root.get(dbField), value));
    }

    protected void likeMethod(String dbField, String value, Specification<?> specification) {
        specification.and((root, query, cb) -> cb.like(root.get(dbField), "%" + value + "%"));
    }


}
