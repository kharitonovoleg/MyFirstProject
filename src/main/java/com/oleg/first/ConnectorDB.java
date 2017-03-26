package com.oleg.first;

import com.oleg.dao.MyException;

import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

    public static Connection getConnection() throws MyException {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("database");
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Connection error");
        }
        throw new MyException("Connection error");
    }
}
