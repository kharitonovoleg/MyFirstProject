package com.oleg.Controller;

import com.oleg.dao.DaoException;
import com.oleg.dao.impl.UserDatabaseDao;
import com.oleg.entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Login")
public class Login extends HttpServlet  {

    UserDatabaseDao userDatabaseDao = new UserDatabaseDao();

    public Login() throws DaoException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
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
}
