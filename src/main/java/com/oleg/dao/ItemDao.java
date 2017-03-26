package com.oleg.dao;

import com.oleg.first.Model;
import java.sql.SQLException;

public interface ItemDao<T extends Model> {

    T getById(int id) throws MyException;

     void add(T model) throws MyException;

    void update(T model) throws MyException;

    void delete(int id) throws MyException;

}
