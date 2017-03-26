package com.oleg.dao;

import com.oleg.first.Model;

public abstract class AbstractDAO<T extends Model> {

    public abstract T getById(int id);

    public abstract void update(T model);

    public abstract void delete(int id);

    public abstract void add(T model);

    public abstract void closeConnection();

    public abstract void closeStatement();

    public abstract void exitProgram();

}
