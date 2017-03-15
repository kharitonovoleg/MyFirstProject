package com.oleg.first;


import com.oleg.dao.impl.NewsDatabaseDao;
import com.oleg.dao.impl.UserDatabaseDao;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {


        Connection con = getConnection("jdbc:mysql://localhost:3306/first_project?verifyServerCertificate=" +
                "false&useSSL=true", "root", "admin");
        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();
        NewsDatabaseDao newsDatabaseDao = new NewsDatabaseDao(con);

        //User user1 = new User("148", "fn", "sn", "132", "111");
        //userDatabaseDao.add(user1);
        System.out.println(userDatabaseDao.getById(1));
        System.out.println(userDatabaseDao.getById(2));
        System.out.println(userDatabaseDao.getById(3));

        System.out.println(newsDatabaseDao.getById(4));
        System.out.println(userDatabaseDao.getById(2));

    }

}
