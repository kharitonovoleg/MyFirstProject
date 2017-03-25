package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.first.ConnectorDB;
import com.oleg.first.UserBase;
import java.sql.*;

public class UserBaseDatabaseDao implements ItemDao<UserBase> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    Connection con = ConnectorDB.getConnection();

    public UserBaseDatabaseDao() throws Exception {

        getByIdStmt = con.prepareStatement("SELECT id, userId, userEventId FROM users_base WHERE id=?");
        updateStmt = con.prepareStatement("UPDATE users_base SET userId=?, userEventId=? WHERE id=?");
        addStmt = con.prepareStatement("INSERT INTO users_base (userId, userEventId) VALUES (?,?)");
        deleteStmt = con.prepareStatement("DELETE FROM users_base WHERE id=?");
    }

    private UserBase getUserBase(ResultSet rs) throws Exception {
        try {
            UserBase userBase = new UserBase();
            userBase.setId(rs.getInt("id"));
            userBase.setUserId(rs.getInt("userId"));
            userBase.setUserEventId(rs.getInt("userEventId"));
            return userBase;
        } catch (Exception e) {
            System.out.println("Error return userBase");
        }
        throw new Exception("Error return userBase");
    }

    public UserBase getById(int id) throws Exception {
        UserBase userBase = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userBase = getUserBase(rs);
            }
            return userBase;
        } catch (Exception e) {
            System.out.println("Error getting userBase. Object is empty");
        }
        throw new Exception("Error getting userBase. Object is empty");
    }

    public void update(UserBase userBase) {
        try {
            updateStmt.setInt(3, userBase.getId());
        } catch (Exception e) {
            System.out.println("Error update userBase");
        }
    }

    public void add(UserBase userBase) {
        try {
            addStmt.setInt(1, userBase.getUserId());
            addStmt.setInt(2, userBase.getUserEventId());
            addStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error add userBase");
        }
    }

    public void delete(int id) {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error delete userBase");
        }
    }
}
