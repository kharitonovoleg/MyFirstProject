package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.dao.DaoException;
import com.oleg.entity.ConnectorDB;
import com.oleg.entity.UserBase;
import java.sql.*;

public class UserBaseDatabaseDao implements ItemDao<UserBase> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public UserBaseDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, userId, userEventId FROM users_base WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE users_base SET userId=?, userEventId=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO users_base (userId, userEventId) VALUES (?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM users_base WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in UserBaseDatabaseDao");
        }
    }

    private UserBase getUserBase(ResultSet rs) throws DaoException {
        try {
            UserBase userBase = new UserBase();
            userBase.setId(rs.getInt("id"));
            userBase.setUserId(rs.getInt("userId"));
            userBase.setUserEventId(rs.getInt("userEventId"));
            return userBase;
        } catch (SQLException e) {
            throw new DaoException("Error return userBase");
        }
    }

    public UserBase getById(int id) throws DaoException {
        UserBase userBase = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userBase = getUserBase(rs);
            }
            return userBase;
        } catch (SQLException e) {
            throw new DaoException("Error getting userBase. Object is empty");
        }
    }

    public void update(UserBase userBase) throws DaoException {
        try {
            updateStmt.setInt(3, userBase.getId());
        } catch (SQLException e) {
            throw new DaoException("Error update userBase");
        }
    }

    public void add(UserBase userBase) throws DaoException {
        try {
            addStmt.setInt(1, userBase.getUserId());
            addStmt.setInt(2, userBase.getUserEventId());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error add userBase");
        }
    }

    public void delete(int id) throws DaoException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error delete userBase");
        }
    }
}
