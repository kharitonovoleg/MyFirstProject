package by.controller;

import by.entity.UserEntity;
import by.exception.DaoException;
import by.dao.impl.UserDatabaseDao;
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

        UserEntity userEntity = new UserEntity();
        userEntity.setNickname(nickname);
        userEntity.setFirstName(firstName);
        userEntity.setSecondName(secondName);
        userEntity.setPassword(password);
        userEntity.setEmail(email);

        try {
            userDatabaseDao.add(userEntity);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
