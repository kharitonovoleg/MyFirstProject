package com.oleg.first;

import com.oleg.dao.DaoException;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorDB {

    public static Connection getConnection() throws DaoException {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("database");
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new DaoException("Connection error");
        }
    }
}
