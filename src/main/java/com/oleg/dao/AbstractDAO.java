package com.oleg.dao;

import com.oleg.first.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO <T extends Model> {

    public abstract T getById(int id) throws SQLException;
    public abstract void update (T model) throws SQLException;
    public abstract void delete(int id) throws SQLException;
    public abstract void add(T model) throws SQLException;

    public void closeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection(Connection connection) throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
