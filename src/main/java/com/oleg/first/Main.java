package com.oleg.first;

import com.oleg.dao.impl.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();
        NewsDatabaseDao newsDatabaseDao = new NewsDatabaseDao();
        EventDatabaseDao eventDatabaseDao = new EventDatabaseDao();
        UserBaseDatabaseDao userBaseDatabaseDao = new UserBaseDatabaseDao();
        UserEventDatabaseDao userEventDatabaseDao = new UserEventDatabaseDao();

        System.out.println(userDatabaseDao.getById(1));
        System.out.println(eventDatabaseDao.getById(1));
        System.out.println(newsDatabaseDao.getById(1));
        System.out.println(userBaseDatabaseDao.getById(1));
        System.out.println(userEventDatabaseDao.getById(1));

        userDatabaseDao.exitProgram();
    }
}
