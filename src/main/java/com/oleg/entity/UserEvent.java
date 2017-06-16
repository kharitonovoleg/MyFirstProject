package com.oleg.entity;

public class UserEvent extends Model {

    private int userId;
    private int eventId;

    public UserEvent(int userId, int eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public UserEvent(int id) {
        super(id);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "UserEvent{" + "id= " + id + ", userId=" + userId + ", eventId= " + eventId + "}";
    }
}
