package com.oleg.entity;

public class UserBase extends Model {

    private int userId;
    private int userEventId;

    public UserBase(int userId, int userEventId) {
        this.userId = userId;
        this.userEventId = userEventId;
    }

    public UserBase() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserEventId() {
        return userEventId;
    }

    public void setUserEventId(int userEventId) {
        this.userEventId = userEventId;
    }

    @Override
    public String toString() {
        return "UserBase{" + "id= " + id + ", userId= " + userId + ", userEventId= " + userEventId + "}";
    }
}