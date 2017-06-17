package by.dao.impl;

import by.dao.ItemDao;
import by.entity.EventEntity;
import by.exception.DaoException;
import by.connection.ConnectorDB;

import java.sql.*;

public class EventDatabaseDao implements ItemDao<EventEntity> {

    private PreparedStatement getByIdStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;

    private Connection con = ConnectorDB.getConnection();

    public EventDatabaseDao() throws DaoException {
        try {
            getByIdStmt = con.prepareStatement("SELECT id, eventName, text, type, city, street, mobilePhone, phone, " +
                    "eventStartTime, date FROM event WHERE id=?");
            updateStmt = con.prepareStatement("UPDATE event SET eventName=?, text=?, type=?, city=?, street=?, " +
                    "mobilePhone=?, phone=?, eventStartTime=?, date=? WHERE id=?");
            addStmt = con.prepareStatement("INSERT INTO event (eventName, text, type, city, street, mobilePhone, " +
                    "phone, eventStartTime, date) VALUES (?,?,?,?,?,?,?,?,?)");
            deleteStmt = con.prepareStatement("DELETE FROM event WHERE id=?");
        } catch (SQLException e) {
            throw new DaoException("Error in EventDatabaseDao");
        }
    }

    private EventEntity getEvent(ResultSet rs) throws DaoException {
        try {
            EventEntity eventEntity = new EventEntity();
            eventEntity.setId(rs.getInt("id"));
            eventEntity.setEventName(rs.getString("eventName"));
            eventEntity.setText(rs.getString("text"));
            eventEntity.setType(rs.getString("type"));
            eventEntity.setCity(rs.getString("city"));
            eventEntity.setStreet(rs.getString("street"));
            eventEntity.setMobilePhone(rs.getString("mobilePhone"));
            eventEntity.setPhone(rs.getString("phone"));
            eventEntity.setEventStartTime(rs.getTime("eventStartTime"));
            eventEntity.setDate(rs.getDate("date"));
            return eventEntity;
        } catch (SQLException e) {
            throw new DaoException("Error return event");
        }
    }

    public EventEntity getById(int id) throws DaoException {
        EventEntity eventEntity = null;
        try {
            getByIdStmt.setInt(1, id);
            ResultSet rs = getByIdStmt.executeQuery();
            if (rs.next()) {
                eventEntity = getEvent(rs);
            }
            return eventEntity;
        } catch (SQLException e) {
            throw new DaoException("Error creating eventEntity. Object is empty");
        }
    }

    public void update(EventEntity eventEntity) throws DaoException {
        try {
            updateStmt.setInt(10, eventEntity.getId());
        } catch (SQLException e) {
            throw new DaoException("Error update eventEntity");
        }
    }

    public void add(EventEntity eventEntity) throws DaoException {
        try {
            addStmt.setString(1, eventEntity.getEventName());
            addStmt.setString(2, eventEntity.getText());
            addStmt.setString(3, eventEntity.getType());
            addStmt.setString(4, eventEntity.getCity());
            addStmt.setString(5, eventEntity.getStreet());
            addStmt.setString(6, eventEntity.getMobilePhone());
            addStmt.setString(7, eventEntity.getPhone());
            addStmt.setTime(8, eventEntity.getEventStartTime());
            addStmt.setDate(9, (Date) eventEntity.getDate());
            addStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error add eventEntity");
        }
    }

    public void delete(int id) throws DaoException {
        try {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error delete event");
        }
    }
}
