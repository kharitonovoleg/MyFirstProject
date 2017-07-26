package by.service;

import by.dao.impl.EventDatabaseDao;
import by.entity.ModelEntity;
import by.exception.DaoException;


public class EventService implements Service {

    private EventDatabaseDao eventDatabaseDao = new EventDatabaseDao();

    public EventService() throws DaoException {
    }

    @Override
    public ModelEntity getById(int id) throws DaoException {
        return this.eventDatabaseDao.getById(id);
    }

    @Override
    public void add(ModelEntity modelEntity) throws DaoException {
    }

    @Override
    public void update(ModelEntity modelEntity) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {
        eventDatabaseDao.delete(id);
    }
}
