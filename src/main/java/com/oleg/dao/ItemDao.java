package com.oleg.dao;

import com.oleg.first.Model;
import java.sql.SQLException;

public interface ItemDao<T extends Model> {

    T getById(int id) throws SQLException;

     void add(T model) throws SQLException;

    void update(T model) throws SQLException;

    void delete(int id) throws SQLException;

}
