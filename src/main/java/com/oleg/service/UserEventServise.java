package com.oleg.service;


import com.oleg.dao.DaoException;
import com.oleg.dao.impl.UserEventDatabaseDao;
import com.oleg.entity.Model;

public class UserEventServise implements Service {

    private UserEventDatabaseDao userEventDatabaseDao = new UserEventDatabaseDao();

    public UserEventServise() throws DaoException {
    }

    @Override
    public Model getById(int id) throws DaoException {
        return this.userEventDatabaseDao.getById(id);
    }

    @Override
    public void add(Model model) throws DaoException {

    }

    @Override
    public void update(Model model) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        userEventDatabaseDao.delete(id);
    }
}
