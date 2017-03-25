package com.oleg.dao.impl;

import com.oleg.dao.ItemDao;
import com.oleg.first.ConnectorDB;
import com.oleg.first.News;
import java.sql.*;

public class NewsDatabaseDao implements ItemDao<News> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    Connection con = ConnectorDB.getConnection();

    public NewsDatabaseDao() throws Exception {

        getByIdStmt = con.prepareStatement("SELECT id, header, text, date FROM news WHERE id=?");
        updateStmt = con.prepareStatement("UPDATE news SET header=?, text=?, date=?, WHERE id=?");
        addStmt = con.prepareStatement("INSERT INTO news (header, text, date)" +
                " VALUES (?,?,?)");
        deleteStmt = con.prepareStatement("DELETE FROM news WHERE id=?");
    }

    private News getNews(ResultSet rs) throws Exception {
        try {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setHeader(rs.getString("header"));
            news.setText(rs.getString("text"));
            news.setDate(rs.getDate("date"));
            return news;
        } catch (Exception e) {
            System.out.println("Error return news");
        }
        throw new Exception("Error return news");
    }

    public News getById(int id) throws Exception {
        News news = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                news = getNews(rs);
            }
            return news;
        } catch (Exception e) {
            System.out.println("Error getting news. Object is empty");
        }
        throw new Exception("Error getting news. Object is empty");
    }

    public void update(News news) {
        try {
            updateStmt.setInt(4, news.getId());
        } catch (Exception e) {
            System.out.println("Error update news");
        }
    }

    public void add(News news) {
        try {
            addStmt.setString(1, news.getHeader());
            addStmt.setString(2, news.getText());
            addStmt.setDate(3, (Date) news.getDate());
            addStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error add news");
        }
    }

    public void delete(int id) {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error delete news");
        }
    }
}
