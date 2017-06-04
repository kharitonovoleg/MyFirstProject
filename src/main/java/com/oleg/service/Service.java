package com.oleg.service;

import com.oleg.dao.DaoException;
import com.oleg.first.Model;


public interface Service <T extends Model>{

    T getById(int id) throws DaoException; //замена на Сервис экз

    void add(T model) throws DaoException;

    void update(T model) throws DaoException;

    void delete(int id) throws DaoException;

}
