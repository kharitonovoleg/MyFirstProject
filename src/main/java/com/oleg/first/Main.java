package com.oleg.first;

import com.oleg.dao.impl.NewsDatabaseDao;
import com.oleg.dao.impl.UserDatabaseDao;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection con = ConnectorDB.getConnection();

        UserDatabaseDao userDatabaseDao = new UserDatabaseDao(con);
        NewsDatabaseDao newsDatabaseDao = new NewsDatabaseDao(con);

        //User user1 = new User("148", "fn", "sn", "132", "111");
        //userDatabaseDao.add(user1);
        System.out.println(userDatabaseDao.getById(1));
        System.out.println(userDatabaseDao.getById(2));
        System.out.println(userDatabaseDao.getById(3));

        userDatabaseDao.closeConnection(con);

        System.out.println(newsDatabaseDao.getById(4));
        System.out.println(userDatabaseDao.getById(2));

    }
}
