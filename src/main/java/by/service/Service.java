package by.service;

import by.entity.ModelEntity;
import by.exception.DaoException;


public interface Service <T extends ModelEntity>{

    T getById(int id) throws DaoException; //замена на Сервис экз

    void add(T model) throws DaoException;

    void update(T model) throws DaoException;

    void delete(int id) throws DaoException;

}
