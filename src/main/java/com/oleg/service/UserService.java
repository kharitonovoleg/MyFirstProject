package com.oleg.service;

import com.oleg.dao.DaoException;

import com.oleg.dao.impl.UserDatabaseDao;
import com.oleg.entity.Model;


public class UserService implements Service {
    private UserDatabaseDao userDatabaseDao = new UserDatabaseDao();

    public UserService() throws DaoException {
    }


    @Override
    public Model getById(int id) throws DaoException {
        return this.userDatabaseDao.getById(id);
    }


    @Override
    public void add(Model model) throws DaoException {

    }

    @Override
    public void update(Model model) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {

    }


}
