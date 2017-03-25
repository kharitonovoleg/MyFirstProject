package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.first.ConnectorDB;
import com.oleg.first.UserEvent;
import java.sql.*;

public class UserEventDatabaseDao implements ItemDao<UserEvent> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    Connection con = ConnectorDB.getConnection();

    public UserEventDatabaseDao() throws Exception {

        getByIdStmt = con.prepareStatement("SELECT id, userId, eventId FROM user_event WHERE id=?");
        updateStmt = con.prepareStatement("UPDATE user_event SET userId=?, eventId=? WHERE id=?");
        addStmt = con.prepareStatement("INSERT INTO user_event (userId, eventId) VALUES (?,?)");
        deleteStmt = con.prepareStatement("DELETE FROM user_event WHERE id=?");
    }

    private UserEvent getUserEvent(ResultSet rs) throws Exception {
        try {
            UserEvent userEvent = new UserEvent();
            userEvent.setId(rs.getInt("id"));
            userEvent.setUserId(rs.getInt("userId"));
            userEvent.setEventId(rs.getInt("eventId"));
            return userEvent;
        } catch (Exception e) {
            System.out.println("Error return user");
        }
        throw new Exception("Error return user");
    }

    public UserEvent getById(int id) throws Exception {
        UserEvent userEvent = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userEvent = getUserEvent(rs);
            }
            return userEvent;
        } catch (Exception e) {
            System.out.println("Error getting user. Object is empty");
        }
        throw new Exception("Error getting user. Object is empty");
    }

    public void update(UserEvent userEvent) {
        try {
            updateStmt.setInt(3, userEvent.getId());
        } catch (Exception e) {
            System.out.println("Error update userEvent");
        }
    }

    public void add(UserEvent userEvent) {
        try {
            addStmt.setInt(1, userEvent.getUserId());
            addStmt.setInt(2, userEvent.getEventId());
            addStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error add userEvent");
        }
    }

    public void delete(int id) {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error delete userEvent");
        }
    }
}