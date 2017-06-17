package by.dao.impl;

import by.connection.ConnectorDB;
import by.dao.ItemDao;
import by.entity.UserEventEntity;
import by.exception.DaoException;

import java.sql.*;

public class UserEventDatabaseDao implements ItemDao<UserEventEntity> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public UserEventDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, userId, eventId FROM user_event WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE user_event SET userId=?, eventId=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO user_event (userId, eventId) VALUES (?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM user_event WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in UserEventDatabaseDao");
        }
    }

    private UserEventEntity getUserEvent(ResultSet rs) throws DaoException {
        try {
            UserEventEntity userEventEntity = new UserEventEntity();
            userEventEntity.setId(rs.getInt("id"));
            userEventEntity.setUserId(rs.getInt("userId"));
            userEventEntity.setEventId(rs.getInt("eventId"));
            return userEventEntity;
        } catch (SQLException e) {
            throw new DaoException("Error return userEvent");
        }
    }

    public UserEventEntity getById(int id) throws DaoException {
        UserEventEntity userEventEntity = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userEventEntity = getUserEvent(rs);
            }
            return userEventEntity;
        } catch (SQLException e) {
            throw new DaoException("Error getting user. Object is empty");
        }
    }

    public void update(UserEventEntity userEventEntity) throws DaoException {
        try {
            updateStmt.setInt(3, userEventEntity.getId());
        } catch (SQLException e) {
            throw new DaoException("Error update userEventEntity");
        }
    }

    public void add(UserEventEntity userEventEntity) throws DaoException {
        try {
            addStmt.setInt(1, userEventEntity.getUserId());
            addStmt.setInt(2, userEventEntity.getEventId());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error add userEventEntity");
        }
    }

    public void delete(int id) throws DaoException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error delete userEvent");
        }
    }
}