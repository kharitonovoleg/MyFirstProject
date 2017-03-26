package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.dao.MyException;
import com.oleg.first.ConnectorDB;
import com.oleg.first.UserBase;
import java.sql.*;

public class UserBaseDatabaseDao implements ItemDao<UserBase> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public UserBaseDatabaseDao() throws MyException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, userId, userEventId FROM users_base WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE users_base SET userId=?, userEventId=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO users_base (userId, userEventId) VALUES (?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM users_base WHERE id=?");
        } catch (SQLException e) {
            throw new MyException("Error in UserBaseDatabaseDao");
        }
    }

    private UserBase getUserBase(ResultSet rs) throws MyException {
        try {
            UserBase userBase = new UserBase();
            userBase.setId(rs.getInt("id"));
            userBase.setUserId(rs.getInt("userId"));
            userBase.setUserEventId(rs.getInt("userEventId"));
            return userBase;
        } catch (SQLException e) {
            throw new MyException("Error return userBase");
        }
    }

    public UserBase getById(int id) throws MyException {
        UserBase userBase = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userBase = getUserBase(rs);
            }
            return userBase;
        } catch (SQLException e) {
            throw new MyException("Error getting userBase. Object is empty");
        }
    }

    public void update(UserBase userBase) throws MyException {
        try {
            updateStmt.setInt(3, userBase.getId());
        } catch (SQLException e) {
            throw new MyException("Error update userBase");
        }
    }

    public void add(UserBase userBase) throws MyException {
        try {
            addStmt.setInt(1, userBase.getUserId());
            addStmt.setInt(2, userBase.getUserEventId());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            throw new MyException("Error add userBase");
        }
    }

    public void delete(int id) throws MyException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            throw new MyException("Error delete userBase");
        }
    }
}
