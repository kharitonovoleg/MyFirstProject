package com.oleg.service;


import com.oleg.dao.DaoException;
import com.oleg.dao.impl.UserBaseDatabaseDao;
import com.oleg.entity.Model;

public class UserBaseService implements Service {

    UserBaseDatabaseDao userBaseDatabaseDao = new UserBaseDatabaseDao();

    public UserBaseService() throws DaoException {
    }

    @Override
    public Model getById(int id) throws DaoException {
        return this.userBaseDatabaseDao.getById(id);
    }

    @Override
    public void add(Model model) throws DaoException {

    }

    @Override
    public void update(Model model) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        userBaseDatabaseDao.delete(id);
    }
}
