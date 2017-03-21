package com.oleg.dao.impl;

import com.oleg.dao.AbstractDAO;
import com.oleg.first.ConnectorDB;
import com.oleg.first.Event;
import java.sql.*;

public class EventDatabaseDao extends AbstractDAO<Event> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    Connection con = ConnectorDB.getConnection();

    public EventDatabaseDao() throws SQLException {

        getByIdStmt = con.prepareStatement("SELECT * FROM event WHERE id=?");
        updateStmt = con.prepareStatement("UPDATE event SET eventName=?, text=?, type=?, city=?, street=?, " +
                "mobilePhone=?, phone=?, eventStartTime=?, date=? WHERE id=?");
        addStmt = con.prepareStatement("INSERT INTO event (eventName, text, type, city, street, mobilePhone, " +
                "phone, eventStartTime, date) VALUES (?,?,?,?,?,?,?,?,?)");
        deleteStmt = con.prepareStatement("DELETE FROM event WHERE id=?");
    }

    private Event getEvent(ResultSet rs) throws SQLException {

        Event event = new Event();

        event.setId(rs.getInt("id"));
        event.setEventName(rs.getString("eventName"));
        event.setText(rs.getString("text"));
        event.setType(rs.getString("type"));
        event.setCity(rs.getString("city"));
        event.setStreet(rs.getString("street"));
        event.setMobilePhone(rs.getString("mobilePhone"));
        event.setPhone(rs.getString("phone"));
        event.setEventStartTime(rs.getTime("eventStartTime"));
        event.setDate(rs.getDate("date"));
        return event;
    }

    public Event getById(int id) throws SQLException {
        Event event = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                event = getEvent(rs);
            }
            return event;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating event. Object is empty");
        }
        throw new SQLException("Error creating event. Object is empty");
    }

    public void update(Event event) {
        try {
            updateStmt.setInt(10, event.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error update event");
        }
    }

    public void add(Event event) {
        try {
            addStmt.setString(1, event.getEventName());
            addStmt.setString(2, event.getText());
            addStmt.setString(3, event.getType());
            addStmt.setString(4, event.getCity());
            addStmt.setString(5, event.getStreet());
            addStmt.setString(6, event.getMobilePhone());
            addStmt.setString(7, event.getPhone());
            addStmt.setTime(8, event.getEventStartTime());
            addStmt.setDate(9, (Date) event.getDate());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error add event");
        }
    }

    public void delete(int id) {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error delete event");
        }
    }
}
