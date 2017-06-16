package com.oleg.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EventController")
public class EventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = "";
        String eventName = request.getParameter("eventName");
        String text = request.getParameter("texr");
        String type = request.getParameter("type");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String mobilePhone = request.getParameter("mobilePhone");
        String phone = request.getParameter("phone");
        //Time eventStartTime = Time.valueOf(request.getParameter("eventStartTime"));

        String d = request.getParameter("date");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yy");
        try {
            Date date = simpleDateFormat.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
