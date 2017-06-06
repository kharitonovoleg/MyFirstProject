package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.dao.DaoException;
import com.oleg.Connection.ConnectorDB;
import com.oleg.entity.Event;

import java.sql.*;

public class EventDatabaseDao implements ItemDao<Event> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public EventDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, eventName, text, type, city, street, mobilePhone, phone, " +
                    "eventStartTime, date FROM event WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE event SET eventName=?, text=?, type=?, city=?, street=?, " +
                    "mobilePhone=?, phone=?, eventStartTime=?, date=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO event (eventName, text, type, city, street, mobilePhone, " +
                    "phone, eventStartTime, date) VALUES (?,?,?,?,?,?,?,?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM event WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in EventDatabaseDao");
        }
    }

    private Event getEvent(ResultSet rs) throws DaoException {
        try {
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
        } catch (SQLException e) {
            throw new DaoException("Error return event");
        }
    }

    public Event getById(int id) throws DaoException {
        Event event = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                event = getEvent(rs);
            }
            return event;
        } catch (SQLException e) {
            throw new DaoException("Error creating event. Object is empty");
        }
    }

    public void update(Event event) throws DaoException {
        try {
            updateStmt.setInt(10, event.getId());
        } catch (SQLException e) {
            throw new DaoException("Error update event");
        }
    }

    public void add(Event event) throws DaoException {
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
            throw new DaoException("Error add event");
        }
    }

    public void delete(int id) throws DaoException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error delete event");
        }
    }
}
