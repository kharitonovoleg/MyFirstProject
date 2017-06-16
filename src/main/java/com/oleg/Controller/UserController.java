package com.oleg.Controller;

import com.oleg.dao.DaoException;
import com.oleg.dao.impl.UserDatabaseDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UserController")
public class UserController extends HttpServlet  {

    UserDatabaseDao userDatabaseDao = new UserDatabaseDao();

    public UserController() throws DaoException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        com.oleg.entity.User user = new com.oleg.entity.User();
        user.setNickname(nickname);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setPassword(password);
        user.setEmail(email);

        try {
            userDatabaseDao.add(user);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
