package com.oleg.first;

import com.oleg.dao.DaoException;
import com.oleg.dao.impl.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws DaoException, SQLException {

        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();

        System.out.println(userDatabaseDao.getById(1));

        userDatabaseDao.closeDao();
    }
}
