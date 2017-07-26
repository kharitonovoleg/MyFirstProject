package by.dao.impl;

import by.connection.ConnectorDB;
import by.entity.UserEntity;
import by.dao.ItemDao;
import by.exception.DaoException;

import java.sql.*;

public class UserDatabaseDao implements ItemDao<UserEntity> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public UserDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, nickname, firstName, secondName, password, email FROM user WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE user SET nickname=?, firstName=?, secondName=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO user (nickname, firstName, secondName, password, email)" +
                    " VALUES (?,?,?,?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM user WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in UserDatabaseDao");
        }
    }

    private UserEntity getUser(ResultSet rs) throws DaoException {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(rs.getInt("id"));
            userEntity.setNickname(rs.getString("nickname"));
            userEntity.setFirstName(rs.getString("firstName"));
            userEntity.setSecondName(rs.getString("secondName"));
            userEntity.setPassword(rs.getString("password"));
            userEntity.setEmail(rs.getString("email"));
            return userEntity;
        } catch (SQLException e) {
            throw new DaoException("Error return user");
        }
    }

    public UserEntity getById(int id) throws DaoException {
        UserEntity userEntity = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                userEntity = getUser(rs);
            }
            return userEntity;
        } catch (SQLException e) {
            throw new DaoException("Error getting userEntity. Object is empty");
        }
    }

    public void update(UserEntity userEntity) throws DaoException {
        try {
            updateStmt.setInt(4, userEntity.getId());
        } catch (SQLException e) {
            throw new DaoException("Error! UserEntity don't update!");
        }
    }

    public void add(UserEntity userEntity) throws DaoException {
        try {
            addStmt.setString(1, userEntity.getNickname());
            addStmt.setString(2, userEntity.getFirstName());
            addStmt.setString(3, userEntity.getSecondName());
            addStmt.setString(4, userEntity.getPassword());
            addStmt.setString(5, userEntity.getEmail());
            addStmt.executeUpdate();
        } catch (Exception e) {
            throw new DaoException("Error! New userEntity not added");
        }
    }

    public void delete(int id) throws DaoException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (Exception e) {
            throw new DaoException("Error. UserEntity not deleted");
        }
    }

    private void closeConnection() throws DaoException {
        try {
            con.close();
        } catch (Exception e) {
            throw new DaoException("Error. connection is not closed");
        }
        System.out.println("connection close");
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
