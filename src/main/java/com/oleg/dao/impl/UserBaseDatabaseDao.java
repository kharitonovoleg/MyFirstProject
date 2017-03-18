package com.oleg.dao.impl;

import com.oleg.dao.AbstractDAO;
import com.oleg.first.ConnectorDB;
import com.oleg.first.UserBase;

import java.sql.*;

public class UserBaseDatabaseDao extends AbstractDAO<UserBase> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    Connection con = ConnectorDB.getConnection();

    public UserBaseDatabaseDao(Connection con) throws SQLException {

        getByIdStmt = con.prepareStatement("SELECT * FROM user_base WHERE id=?");
        updateStmt = con.prepareStatement("UPDATE user_base SET userId=?, userEventId=? WHERE id=?");
        addStmt = con.prepareStatement("INSERT INTO user_base (userId, userEventId) VALUES (?,?)");
        deleteStmt = con.prepareStatement("DELETE FROM user_base WHERE id=?");
    }

    private UserBase getUserBase(ResultSet rs) throws SQLException {

        UserBase userBase = new UserBase();
        userBase.setId(rs.getInt("id"));
        userBase.setUserId(rs.getInt("userId"));
        userBase.setUserEventId(rs.getInt("userEventId"));

        return userBase;
    }

    public UserBase getById(int id) {
        UserBase userBase = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userBase = getUserBase(rs);
            }
            getByIdStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBase;
    }

    public void update(UserBase userBase) {
        try {
            updateStmt.setInt(3, userBase.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(UserBase userBase) {
        try {
            addStmt.setInt(1, userBase.getUserId());
            addStmt.setInt(2, userBase.getUserEventId());
            addStmt.executeUpdate();
            addStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
