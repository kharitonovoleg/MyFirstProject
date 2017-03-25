package com.oleg.dao;

import com.oleg.first.Model;
import java.sql.SQLException;

public interface ItemDao<T extends Model> {

    T getById(int id) throws Exception;

     void add(T model) throws Exception;

    void update(T model) throws Exception;

    void delete(int id) throws Exception;

}
