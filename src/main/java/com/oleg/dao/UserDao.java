package com.oleg.dao;

import com.oleg.first.User;
import java.sql.SQLException;

public interface UserDao extends ItemDao<User> {

    User getById(int id) throws SQLException;

    void add(User user) throws SQLException;

    void update(User user) throws SQLException;

    void delete(int id) throws SQLException;
}