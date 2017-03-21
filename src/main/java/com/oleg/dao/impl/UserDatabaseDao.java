package com.oleg.dao.impl;

import com.oleg.dao.AbstractDAO;
import com.oleg.first.ConnectorDB;
import com.oleg.first.User;

import java.sql.*;

public class UserDatabaseDao extends AbstractDAO<User> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    Connection con = ConnectorDB.getConnection();

    public UserDatabaseDao() throws SQLException {

        getByIdStmt = con.prepareStatement("SELECT * FROM user WHERE id=?");
        updateStmt = con.prepareStatement("UPDATE user SET nickname=?, firstName=?, secondName=?, WHERE id=?");
        addStmt = con.prepareStatement("INSERT INTO user (nickname, firstName, secondName, password, email)" +
                " VALUES (?,?,?,?,?)");
        deleteStmt = con.prepareStatement("DELETE FROM user WHERE id=?");

    }


    private User getUser(ResultSet rs) throws SQLException {

        User user = new User();

        user.setId(rs.getInt("id"));
        user.setNickname(rs.getString("nickname"));
        user.setFirstName(rs.getString("firstName"));
        user.setSecondName(rs.getString("secondName"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        return user;
    }

    public User getById(int id) throws SQLException {

        User user = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                user = getUser(rs);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error getting user. Object is empty");
        }
        throw new SQLException("Error getting user. Object is empty");
    }

    public void update(User user) throws SQLException {
        try {
            updateStmt.setInt(4, user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error update user");
        }
    }

    public void add(User user) throws SQLException {
        try {
            addStmt.setString(1, user.getNickname());
            addStmt.setString(2, user.getFirstName());
            addStmt.setString(3, user.getSecondName());
            addStmt.setString(4, user.getPassword());
            addStmt.setString(5, user.getEmail());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error add user");
        }
    }

    public void delete(int id) throws SQLException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error delete user");
        }
    }

    public void closeConnection() throws SQLException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void closeStatement() throws SQLException {
        try {
            if (getByIdStmt != null) {
                getByIdStmt.close();
            }
            if (updateStmt != null) {
                updateStmt.close();
            }
            if (addStmt != null) {
                addStmt.close();
            }
            if (deleteStmt != null) {
                deleteStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error close Statement");
        }
    }
}
