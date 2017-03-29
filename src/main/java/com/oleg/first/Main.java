package com.oleg.first;

import com.oleg.dao.DaoException;
import com.oleg.dao.impl.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws DaoException, SQLException {

        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();
        EventDatabaseDao eventDatabaseDao = new EventDatabaseDao();

        System.out.println(userDatabaseDao.getById(1));
        System.out.println(eventDatabaseDao.getById(1));

        userDatabaseDao.close();
    }
}
