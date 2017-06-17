package by.loginLogoutServlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String adminLogin = "root";
        String adminPassword = "root";

        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");


        if(adminLogin.equals(userLogin) && adminPassword.equals(userPassword)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("adminSession", "adminSession");
            httpSession.setMaxInactiveInterval(60 * 3);
            Cookie login = new Cookie("loginCookie", request.getParameter("login"));
            Cookie password = new Cookie("password", request.getParameter("password"));
            login.setMaxAge(60*1);
            password.setMaxAge(60*1);
            response.addCookie(login);
            response.addCookie(password);
            response.sendRedirect("select.jsp");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("start.jsp");
            PrintWriter out = response.getWriter();
            out.println("invalid name or password");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
