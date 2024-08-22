package com.example.ticketone.utility.exception.custom;

import org.springframework.dao.DataAccessException;

public class DbHibernateEx extends DataAccessException {

    public DbHibernateEx(String msg) {
        super(msg);
    }

    public DbHibernateEx(String msg, Throwable cause) {
        super(msg, cause);
    }
}
