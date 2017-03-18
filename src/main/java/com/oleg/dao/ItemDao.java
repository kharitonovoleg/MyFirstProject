package com.oleg.dao;

import com.oleg.first.Model;
import java.sql.SQLException;

public interface ItemDao <T extends Model> {

    public T getById(int id) throws SQLException;

    public void add(T model) throws SQLException;

    public void update(T model) throws SQLException;

    public void delete(int id) throws SQLException;

}
