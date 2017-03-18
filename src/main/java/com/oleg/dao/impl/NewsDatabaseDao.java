package com.oleg.dao.impl;

import com.oleg.dao.AbstractDAO;
import com.oleg.first.ConnectorDB;
import com.oleg.first.News;

import java.sql.*;

public class NewsDatabaseDao extends AbstractDAO<News> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    Connection con = ConnectorDB.getConnection();

    public NewsDatabaseDao(Connection con) throws SQLException {

        getByIdStmt = con.prepareStatement("SELECT * FROM news WHERE id=?");
        updateStmt = con.prepareStatement("UPDATE news SET header=?, text=?, date=?, WHERE id=?");
        addStmt = con.prepareStatement("INSERT INTO news (header, text, date)" +
                " VALUES (?,?,?)");
        deleteStmt = con.prepareStatement("DELETE FROM news WHERE id=?");
    }

    private News getNews(ResultSet rs) throws SQLException {

        News news = new News();

        news.setId(rs.getInt("id"));
        news.setHeader(rs.getString("header"));
        news.setText(rs.getString("text"));
        news.setDate(rs.getDate("date"));

        return news;
    }

    public News getById(int id) {
        News news = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                news = getNews(rs);
            }
            getByIdStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return news;
    }

    public void update(News news) {
        try {
            updateStmt.setInt(4, news.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(News news) {
        try {
            addStmt.setString(1, news.getHeader());
            addStmt.setString(2, news.getText());
            addStmt.setDate(3, (Date) news.getDate());
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
