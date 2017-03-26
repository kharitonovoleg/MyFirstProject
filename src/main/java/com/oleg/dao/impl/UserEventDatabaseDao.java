package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.dao.MyException;
import com.oleg.first.ConnectorDB;
import com.oleg.first.UserEvent;

import java.sql.*;

public class UserEventDatabaseDao implements ItemDao<UserEvent> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public UserEventDatabaseDao() throws MyException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, userId, eventId FROM user_event WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE user_event SET userId=?, eventId=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO user_event (userId, eventId) VALUES (?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM user_event WHERE id=?");
        } catch (SQLException e) {
            throw new MyException("Error in UserEventDatabaseDao");
        }
    }

    private UserEvent getUserEvent(ResultSet rs) throws MyException {
        try {
            UserEvent userEvent = new UserEvent();
            userEvent.setId(rs.getInt("id"));
            userEvent.setUserId(rs.getInt("userId"));
            userEvent.setEventId(rs.getInt("eventId"));
            return userEvent;
        } catch (SQLException e) {
            throw new MyException("Error return userEvent");
        }
    }

    public UserEvent getById(int id) throws MyException {
        UserEvent userEvent = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userEvent = getUserEvent(rs);
            }
            return userEvent;
        } catch (SQLException e) {
            throw new MyException("Error getting user. Object is empty");
        }
    }

    public void update(UserEvent userEvent) throws MyException {
        try {
            updateStmt.setInt(3, userEvent.getId());
        } catch (SQLException e) {
            throw new MyException("Error update userEvent");
        }
    }

    public void add(UserEvent userEvent) throws MyException {
        try {
            addStmt.setInt(1, userEvent.getUserId());
            addStmt.setInt(2, userEvent.getEventId());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            throw new MyException("Error add userEvent");
        }
    }

    public void delete(int id) throws MyException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            throw new MyException("Error delete userEvent");
        }
    }
}