package by.service;


import by.dao.impl.UsersBaseDatabaseDao;
import by.entity.ModelEntity;
import by.exception.DaoException;

public class UserBaseService implements Service {

    private UsersBaseDatabaseDao usersBaseDatabaseDao = new UsersBaseDatabaseDao();

    public UserBaseService() throws DaoException {
    }

    @Override
    public ModelEntity getById(int id) throws DaoException {
        return this.usersBaseDatabaseDao.getById(id);
    }

    @Override
    public void add(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void update(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        usersBaseDatabaseDao.delete(id);
    }
}
