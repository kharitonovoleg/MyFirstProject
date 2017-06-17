package by.service;


import by.dao.impl.UserEventDatabaseDao;
import by.entity.ModelEntity;
import by.exception.DaoException;

public class UserEventServise implements Service {

    private UserEventDatabaseDao userEventDatabaseDao = new UserEventDatabaseDao();

    public UserEventServise() throws DaoException {
    }

    @Override
    public ModelEntity getById(int id) throws DaoException {
        return this.userEventDatabaseDao.getById(id);
    }

    @Override
    public void add(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void update(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        userEventDatabaseDao.delete(id);
    }
}
