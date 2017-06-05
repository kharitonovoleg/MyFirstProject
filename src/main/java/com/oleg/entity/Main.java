package com.oleg.entity;

import com.oleg.dao.DaoException;
import com.oleg.dao.impl.*;
import com.oleg.service.EventService;
import com.oleg.service.UserService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws DaoException, SQLException {

        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();
        EventDatabaseDao eventDatabaseDao = new EventDatabaseDao();

        UserService userService = new UserService();
        EventService eventService = new EventService();

        System.out.println(eventService.getById(1));
        System.out.println(userService.getById(1));

//        System.out.println(userDatabaseDao.getById(1));
//        System.out.println(eventDatabaseDao.getById(1));

        userDatabaseDao.close();
    }
}
