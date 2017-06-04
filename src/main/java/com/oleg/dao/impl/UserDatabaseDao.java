package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.dao.DaoException;
import com.oleg.first.ConnectorDB;
import com.oleg.first.User;

import java.sql.*;

public class UserDatabaseDao implements ItemDao<User> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public UserDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, nickname, firstName, secondName, password, email FROM user WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE user SET nickname=?, firstName=?, secondName=?, WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO user (nickname, firstName, secondName, password, email)" +
                    " VALUES (?,?,?,?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM user WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in UserDatabaseDao");
        }
    }

    private User getUser(ResultSet rs) throws DaoException {
        try {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNickname(rs.getString("nickname"));
            user.setFirstName(rs.getString("firstName"));
            user.setSecondName(rs.getString("secondName"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            return user;
        } catch (SQLException e) {
            throw new DaoException("Error return user");
        }
    }

    public User getById(int id) throws DaoException {
        User user = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                user = getUser(rs);
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException("Error getting user. Object is empty");
        }
    }

    public void update(User user) throws DaoException {
        try {
            updateStmt.setInt(4, user.getId());
        } catch (SQLException e) {
            throw new DaoException("Error! User don't update!");
        }
    }

    public void add(User user) throws DaoException {
        try {
            addStmt.setString(1, user.getNickname());
            addStmt.setString(2, user.getFirstName());
            addStmt.setString(3, user.getSecondName());
            addStmt.setString(4, user.getPassword());
            addStmt.setString(5, user.getEmail());
            addStmt.executeUpdate();
        } catch (Exception e) {
            throw new DaoException("Error! New user not added");
        }
    }

    public void delete(int id) throws DaoException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (Exception e) {
            throw new DaoException("Error. User not deleted");
        }
    }

    private void closeConnection() throws DaoException {
        try {
            con.close();
        } catch (Exception e) {
            throw new DaoException("Error. Connection is not closed");
        }
        System.out.println("Connection close");
    }

    private void closeStatement() throws DaoException {
        Exception exception = null;
        try {
            getByIdStmt.close();
        } catch (SQLException e) {
            exception = e;
            System.out.println("Attention! getByIdStmt not closed!");
        }
        try {
            updateStmt.close();
        } catch (SQLException e) {
            exception = e;
            System.out.println("Attention!  updateStmt not closed!");
        }
        try {
            addStmt.close();
        } catch (SQLException e) {
            exception = e;
            System.out.println("Attention! addStmt not closed!");
        }
        try {
            deleteStmt.close();
        } catch (SQLException e) {
            exception = e;
            System.out.println("Attention! deleteStmt not closed!");
        }
        if (exception != null)
        {
            throw new DaoException("Error! Statement is not closed");
        }
    }

    public void close() throws DaoException {
        Exception exception = null;
        try {
            closeStatement();
            System.out.println("Statement close");
        } catch (Exception e) {
            exception = e;
            System.out.println("Attention! There was an error in method closeStatement");
        }
        try {
            closeConnection();
        } catch (Exception e) {
            exception = e;
            System.out.println("Attention! There was an error in method closeConnection");
        }
        if (exception != null)
        {
            throw new DaoException("Error in method \"close()\"");
        }

    }
}
