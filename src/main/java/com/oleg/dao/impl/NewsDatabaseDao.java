package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.dao.DaoException;
import com.oleg.first.ConnectorDB;
import com.oleg.first.News;

import java.sql.*;

public class NewsDatabaseDao implements ItemDao<News> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public NewsDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, header, text, date FROM news WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE news SET header=?, text=?, date=?, WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO news (header, text, date)" +
                    " VALUES (?,?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM news WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in NewsDatabaseDao");
        }
    }

    private News getNews(ResultSet rs) throws DaoException {
        try {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setHeader(rs.getString("header"));
            news.setText(rs.getString("text"));
            news.setDate(rs.getDate("date"));
            return news;
        } catch (SQLException e) {
            throw new DaoException("Error return news");
        }
    }

    public News getById(int id) throws DaoException {
        News news = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                news = getNews(rs);
            }
            return news;
        } catch (SQLException e) {
            throw new DaoException("Error getting news. Object is empty");
        }
    }

    public void update(News news) throws DaoException {
        try {
            updateStmt.setInt(4, news.getId());
        } catch (SQLException e) {
            throw new DaoException("Error update news");
        }
    }

    public void add(News news) throws DaoException {
        try {
            addStmt.setString(1, news.getHeader());
            addStmt.setString(2, news.getText());
            addStmt.setDate(3, (Date) news.getDate());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error add news");
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
