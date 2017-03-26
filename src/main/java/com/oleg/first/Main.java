package com.oleg.first;

import com.oleg.dao.MyException;
import com.oleg.dao.impl.*;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws MyException, SQLException {

        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();

        System.out.println(userDatabaseDao.getById(1));

        userDatabaseDao.exitProgram();
    }
}
