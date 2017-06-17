package by.service;

import by.dao.impl.UserDatabaseDao;
import by.entity.ModelEntity;
import by.exception.DaoException;


public class UserService implements Service {
    private UserDatabaseDao userDatabaseDao = new UserDatabaseDao();

    public UserService() throws DaoException {
    }


    @Override
    public ModelEntity getById(int id) throws DaoException {
        return this.userDatabaseDao.getById(id);
    }


    @Override
    public void add(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void update(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {

    }


}
