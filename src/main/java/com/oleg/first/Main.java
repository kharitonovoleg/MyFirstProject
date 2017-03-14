package com.oleg.first;


import com.oleg.dao.impl.NewsDatabaseDao;
import com.oleg.dao.impl.UserDatabaseDao;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {


        Connection con = null;
        UserDatabaseDao udbd = new UserDatabaseDao(con);
        NewsDatabaseDao ndbd = new NewsDatabaseDao(con);

        User user1 = new User("148", "fn", "sn", "132", "111");
        //udbd.add(user1);
        System.out.println(udbd.getById(4));
        //System.out.println(udbd.getById(2));
        System.out.println(ndbd.getById(1));

    }

}
