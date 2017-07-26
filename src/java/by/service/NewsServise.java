package by.service;


import by.entity.ModelEntity;
import by.exception.DaoException;
import by.dao.impl.NewsDatabaseDao;

public class NewsServise implements Service {

    private NewsDatabaseDao newsDatabaseDao = new NewsDatabaseDao();

    public NewsServise() throws DaoException {
    }

    @Override
    public ModelEntity getById(int id) throws DaoException {
        return this.newsDatabaseDao.getById(id);
    }

    @Override
    public void add(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void update(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        newsDatabaseDao.delete(id);
    }
}
