package by.dao;

import by.entity.ModelEntity;
import by.exception.DaoException;

public interface ItemDao <T extends ModelEntity> {

    T getById(int id) throws DaoException;

     void add(T model) throws DaoException;

    void update(T model) throws DaoException;

    void delete(int id) throws DaoException;

}
