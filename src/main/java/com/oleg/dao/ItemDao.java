package com.oleg.dao;

import com.oleg.entity.Model;

public interface ItemDao <T extends Model> {

    T getById(int id) throws DaoException;

     void add(T model) throws DaoException;

    void update(T model) throws DaoException;

    void delete(int id) throws DaoException;

}
