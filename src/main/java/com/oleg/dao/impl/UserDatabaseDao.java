package com.oleg.dao.impl;

import com.oleg.dao.UserDao;
import com.oleg.first.User;

import java.sql.*;

public class UserDatabaseDao implements UserDao {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;


    public UserDatabaseDao(Connection con) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_project?verifyServerCertificate=false&useSSL=true", "root", "admin");;

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
            rs.close();
            getByIdStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getByIdStmt.close();
        }
        return user;
    }

    public void update(User user) throws SQLException {
        try {
            updateStmt.setInt(4, user.getId());
            updateStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            updateStmt.close();
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
            addStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            addStmt.close();
        }
    }

    public void delete(int id) throws SQLException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
            deleteStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            deleteStmt.close();
        }
    }

    public void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                con.close();
            }
        }
    }
}
