package com.oleg.service;


import com.oleg.dao.DaoException;
import com.oleg.dao.impl.NewsDatabaseDao;
import com.oleg.entity.Model;

public class NewsServise implements Service {

    private NewsDatabaseDao newsDatabaseDao = new NewsDatabaseDao();

    public NewsServise() throws DaoException {
    }

    @Override
    public Model getById(int id) throws DaoException {
        return this.newsDatabaseDao.getById(id);
    }

    @Override
    public void add(Model model) throws DaoException {

    }

    @Override
    public void update(Model model) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        newsDatabaseDao.delete(id);
    }
}
