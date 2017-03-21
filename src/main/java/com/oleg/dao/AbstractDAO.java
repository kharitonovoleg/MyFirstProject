package com.oleg.dao;

import com.oleg.first.Model;
import java.sql.SQLException;

public abstract class AbstractDAO<T extends Model> {

    public abstract T getById(int id) throws SQLException;

    public abstract void update(T model) throws SQLException;

    public abstract void delete(int id) throws SQLException;

    public abstract void add(T model) throws SQLException;

}
