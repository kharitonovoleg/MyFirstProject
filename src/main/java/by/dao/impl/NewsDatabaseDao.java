package by.dao.impl;

import by.connection.ConnectorDB;
import by.dao.ItemDao;
import by.entity.NewsEntity;
import by.exception.DaoException;

import java.sql.*;

public class NewsDatabaseDao implements ItemDao<NewsEntity> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public NewsDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, header, text, date FROM news WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE news SET header=?, text=?, date=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO news (header, text, date)" +
                    " VALUES (?,?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM news WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in NewsDatabaseDao");
        }
    }

    private NewsEntity getNews(ResultSet rs) throws DaoException {
        try {
            NewsEntity newsEntity = new NewsEntity();
            newsEntity.setId(rs.getInt("id"));
            newsEntity.setHeader(rs.getString("header"));
            newsEntity.setText(rs.getString("text"));
            newsEntity.setDate(rs.getDate("date"));
            return newsEntity;
        } catch (SQLException e) {
            throw new DaoException("Error return news");
        }
    }

    public NewsEntity getById(int id) throws DaoException {
        NewsEntity newsEntity = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                newsEntity = getNews(rs);
            }
            return newsEntity;
        } catch (SQLException e) {
            throw new DaoException("Error getting newsEntity. Object is empty");
        }
    }

    public void update(NewsEntity newsEntity) throws DaoException {
        try {
            updateStmt.setInt(4, newsEntity.getId());
        } catch (SQLException e) {
            throw new DaoException("Error update newsEntity");
        }
    }

    public void add(NewsEntity newsEntity) throws DaoException {
        try {
            addStmt.setString(1, newsEntity.getHeader());
            addStmt.setString(2, newsEntity.getText());
            addStmt.setDate(3, (Date) newsEntity.getDate());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error add newsEntity");
        }
    }

    public void delete(int id) throws DaoException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error delete news");
        }
    }
}
