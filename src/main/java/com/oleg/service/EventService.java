package com.oleg.service;

import com.oleg.dao.DaoException;
import com.oleg.dao.impl.EventDatabaseDao;
import com.oleg.entity.Model;


public class EventService implements Service {

    EventDatabaseDao eventDatabaseDao = new EventDatabaseDao();

    public EventService() throws DaoException {
    }

    @Override
    public Model getById(int id) throws DaoException {
        return this.eventDatabaseDao.getById(id);
    }

    @Override
    public void add(Model model) throws DaoException {
    }

    @Override
    public void update(Model model) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        eventDatabaseDao.delete(id);
    }
}
