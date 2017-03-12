package com.oleg.first;

import java.sql.*;

public class DB_first_project {

    private static final String URL = "jdbc:mysql://localhost:3306/first_project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public DB_first_project() {
        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}